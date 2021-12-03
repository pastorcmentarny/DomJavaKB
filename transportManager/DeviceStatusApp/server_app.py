import json
import logging
import psutil
import re
import requests
import time
from blinkt import set_pixel, set_brightness, show, clear
from subprocess import PIPE, Popen

logger = logging.getLogger('app')
# HOSTNAME = "http://192.168.0.205"
HOSTNAME = "http://192.168.0.15"
set_brightness(0.05)

ALERT_COLOR = [255, 0, 0]
WARNING_COLOR = [224, 63, 0]
TEMP_ABOVE_55_COLOR = [160, 127, 64]
TEMP_ABOVE_50_COLOR = [127, 127, 0]
TEMP_ABOVE_40_COLOR = [64, 224, 0]
GOOD_COLOR = [64, 255, 24]
OFF_COLOR = [155, 38, 182]
UNKNOWN_COLOR = [0, 0, 255]
ALL_COLORS = [ALERT_COLOR, WARNING_COLOR, GOOD_COLOR, OFF_COLOR, UNKNOWN_COLOR, TEMP_ABOVE_55_COLOR,
              TEMP_ABOVE_50_COLOR, TEMP_ABOVE_40_COLOR]

"""
0 CPU temp
1 RAM
2 SPACE
3 
5 UI
6 SERVICE
7 DB
"""

KEY_CPU = "CPU"
KEY_SPACE = "SPACE"
KEY_RAM = "KEY_RAM"
KEY_TM_UI = "TM_UI"
KEY_TM_SERVICE = "TM_SERVICE"
KEY_TM_DB = "TM_DB"

status = {
    KEY_CPU: UNKNOWN_COLOR,
    KEY_RAM: UNKNOWN_COLOR,
    KEY_SPACE: UNKNOWN_COLOR,
    KEY_TM_UI: UNKNOWN_COLOR,
    KEY_TM_SERVICE: UNKNOWN_COLOR,
    KEY_TM_DB: UNKNOWN_COLOR,
}

RED = 0
GREEN = 1
BLUE = 2


def get_cpu_temperature():
    with Popen(['vcgencmd', 'measure_temp'], stdout=PIPE) as process:
        output, _error = process.communicate()
        output = output.decode()

        pos_start = output.index('=') + 1
        pos_end = output.rindex("'")

        temp = float(output[pos_start:pos_end])
        process.kill()
        return temp


def get_ram_available():
    return psutil.virtual_memory().available / 1000000


def get_space_available():
    with Popen("df / -m --output=avail", stdout=PIPE, shell=True) as process:
        result, _ = process.communicate()
        process.kill()
        return re.sub('[^0-9.]', '', str(result).strip())


def display_light():
    set_pixel(0, status[KEY_CPU][RED], status[KEY_CPU][GREEN], status[KEY_CPU][BLUE])
    set_pixel(1, status[KEY_RAM][RED], status[KEY_RAM][GREEN], status[KEY_RAM][BLUE])
    set_pixel(2, status[KEY_SPACE][RED], status[KEY_SPACE][GREEN], status[KEY_SPACE][BLUE])

    set_pixel(4, status[KEY_TM_UI][RED], status[KEY_TM_UI][GREEN], status[KEY_TM_UI][BLUE])
    set_pixel(5, status[KEY_TM_SERVICE][RED], status[KEY_TM_SERVICE][GREEN], status[KEY_TM_SERVICE][BLUE])
    set_pixel(6, status[KEY_TM_DB][RED], status[KEY_TM_DB][GREEN], status[KEY_TM_DB][BLUE])
    show()


def cpu_health_check():
    temp = get_cpu_temperature()
    if temp > 70.0:
        status[KEY_CPU] = ALERT_COLOR
    elif temp > 60.0:
        status[KEY_CPU] = WARNING_COLOR
    elif temp > 55.0:
        status[KEY_CPU] = TEMP_ABOVE_55_COLOR
    elif temp > 50.0:
        status[KEY_CPU] = TEMP_ABOVE_50_COLOR
    elif temp > 45.0:
        status[KEY_CPU] = TEMP_ABOVE_40_COLOR
    else:
        status[KEY_CPU] = GOOD_COLOR


def free_space_health_check():
    space = int(get_space_available())
    if space < 250:
        status[KEY_SPACE] = ALERT_COLOR
    elif space < 1000:
        status[KEY_SPACE] = WARNING_COLOR
    else:
        status[KEY_SPACE] = GOOD_COLOR


def ram_available_health_check():
    ram = int(get_ram_available())
    if ram < 500:
        status[KEY_RAM] = ALERT_COLOR
    elif ram < 250:
        status[KEY_RAM] = WARNING_COLOR
    else:
        status[KEY_RAM] = GOOD_COLOR


def healthcheck():
    # cpu_hc()
    cpu_health_check()
    ram_available_health_check()
    free_space_health_check()


def log_status():
    logger.info(
        f"Status: CPU:{status[KEY_RAM]}, RAM:{status[KEY_CPU]}, SPACE:{status[KEY_SPACE]}, UI:{status[KEY_TM_UI]}, SERVICE:{status[KEY_TM_SERVICE]},DB:{status[KEY_TM_DB]}")


def app_loop():
    while True:
        healthcheck()
        microservices_healthcheck()
        display_light()
        log_status()
        time.sleep(5)


def setup():
    display_light()


def get_data_for(url: str, timeout: int = 1) -> str:
    try:
        with requests.get(url, timeout=timeout) as response:
            response.raise_for_status()
            data_response = response.text
            return json.loads(data_response)["status"]
    except Exception as whoops:
        logger.error(f"Unable to get data from url: {url} due to {whoops}")
        return "ERROR"


def microservices_healthcheck():
    ui = get_data_for(HOSTNAME + ":18001/actuator/health")
    status[KEY_TM_UI] = get_color_for_response(ui)
    service = get_data_for(HOSTNAME + ":18002/actuator/health")
    status[KEY_TM_SERVICE] = get_color_for_response(service)
    db = get_data_for(HOSTNAME + ":18003/actuator/health")
    status[KEY_TM_DB] = get_color_for_response(db)


def get_color_for_response(response):
    if response == "ERROR":
        return ALERT_COLOR
    elif response == "DOWN":
        return WARNING_COLOR
    else:
        return GOOD_COLOR


def set_to_red():
    for index in range(0, 8):
        set_pixel(index, 255, 0, 0)
    set_brightness(0.3)
    show()


def set_to_orange():
    for index in range(0, 8):
        set_pixel(index, 224, 64, 0)
    set_brightness(0.2)
    show()


def startup():
    idx = 0  # move to loop
    for color in ALL_COLORS:
        set_pixel(idx, color[RED], color[GREEN], color[BLUE])
        idx += 1
    show()
    time.sleep(5)
    clear()


if __name__ == '__main__':
    logging_level = logging.DEBUG
    logging_format = "%(levelname)s\t\t:: %(asctime)s :: %(message)s"
    logging_filename = 'server.txt'
    logging.basicConfig(level=logging_level, format=logging_format, filename='server.txt')
    logger.info('Starting web server')
    startup()
    try:
        setup()
        app_loop()
    except KeyboardInterrupt as keyboard_exception:
        clear()
    except Exception as exception:
        print(f'Whoops. {exception}')
        set_to_orange()
    except BaseException as disaster:
        msg = 'Shit hit the fan and application died badly because {}'.format(disaster)
        set_to_red()
