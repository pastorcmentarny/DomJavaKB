import datetime
import json
import re
import time
from subprocess import PIPE, Popen

import psutil
import requests
from blinkt import set_pixel, set_brightness, show

ALERT_COLOR = [255, 0, 0]
WARNING_COLOR = [255, 112, 0]
GOOD_COLOR = [64, 255, 24]
OFF_COLOR = [155, 38, 182]
UNKNOWN_COLOR = [0, 0, 255]
ALL_COLORS = [ALERT_COLOR, WARNING_COLOR, GOOD_COLOR, OFF_COLOR, UNKNOWN_COLOR]

"""
0 CPU temp
1 RAM
2 SPACE
3 
5 UI
6 SERVICE
7 DB
"""

status = {
    "CPU": UNKNOWN_COLOR,
    "RAM": UNKNOWN_COLOR,
    "SPACE": UNKNOWN_COLOR,
    "TM_UI": UNKNOWN_COLOR,
    "TM_SERVICE": UNKNOWN_COLOR,
    "TM_DB": UNKNOWN_COLOR,
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


def update_brightness():
    now = datetime.datetime.now()
    hour = now.hour
    if hour < 9 or hour >= 19:
        set_brightness(0.05)
    else:
        set_brightness(0.1)


def display_light():
    set_pixel(0, status["CPU"][RED], status["CPU"][GREEN], status["CPU"][BLUE])
    set_pixel(1, status["RAM"][RED], status["RAM"][GREEN], status["RAM"][BLUE])
    set_pixel(2, status["SPACE"][RED], status["SPACE"][GREEN], status["SPACE"][BLUE])

    set_pixel(4, status["TM_UI"][RED], status["TM_UI"][GREEN], status["TM_UI"][BLUE])
    set_pixel(5, status["TM_SERVICE"][RED], status["TM_SERVICE"][GREEN], status["TM_SERVICE"][BLUE])
    set_pixel(6, status["TM_DB"][RED], status["TM_DB"][GREEN], status["TM_DB"][BLUE])
    update_brightness()
    show()


def cpu_health_check():
    temp = get_cpu_temperature()
    if temp > 70.0:
        status["CPU"] = ALERT_COLOR
    elif temp > 60.0:
        status["CPU"] = WARNING_COLOR
    else:
        status["CPU"] = GOOD_COLOR


def free_space_health_check():
    space = int(get_space_available())
    if space < 250:
        status["SPACE"] = ALERT_COLOR
    elif space < 1000:
        status["SPACE"] = WARNING_COLOR
    else:
        status["SPACE"] = GOOD_COLOR


def ram_available_health_check():
    ram = int(get_ram_available())
    if ram < 500:
        status["RAM"] = ALERT_COLOR
    elif ram < 250:
        status["RAM"] = WARNING_COLOR
    else:
        status["RAM"] = GOOD_COLOR


def healthcheck():
    cpu_health_check()
    ram_available_health_check()
    free_space_health_check()


def app_loop():
    while True:
        healthcheck()
        microservices_healthcheck()
        display_light()
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
        return "ERROR"


def microservices_healthcheck():
    ui = get_data_for("http://192.168.0.18:18001/actuator/health")
    status["TM_UI"] = get_color_for_response(ui)
    service = get_data_for("http://192.168.0.18:18002/actuator/health")
    status["TM_SERVICE"] = get_color_for_response(service)
    db = get_data_for("http://192.168.0.18:18003/actuator/health")
    status["TM_DB"] = get_color_for_response(db)


def get_color_for_response(response):
    if response == "ERROR":
        return ALERT_COLOR
    elif response == "DOWN":
        return WARNING_COLOR
    else:
        return GOOD_COLOR


if __name__ == '__main__':
    setup()
    app_loop()

"""
if __name__ == '__main__':
    startup()
    try:
        logging.info('Mounting network drives')
        commands.mount_all_drives()

        logging.info("Sensor warming up, please wait...")
        air_quality_service.start_measurement()
        motion_service.sample()
        logging.info('Sensor needed {} seconds to warm up'.format(counter))
        two_led_service.off()
        app_loop()
    except KeyboardInterrupt as keyboard_exception:
        print('Received request application to shut down.. goodbye. {}'.format(keyboard_exception))
        logging.info('Received request application to shut down.. goodbye!', exc_info=True)
        cleanup_before_exit()
    except Exception as exception:
        print(f'Whoops. {exception}')
        logger.error('Something went badly wrong\n{}'.format(exception), exc_info=True)
        email_sender_service.send_error_log_email("application", "Application crashed due to {}.".format(exception))
        cleanup_before_exit()
    except BaseException as disaster:
        msg = 'Shit hit the fan and application died badly because {}'.format(disaster)
        print(msg)
        traceback.print_exc()
        logger.fatal(msg, exc_info=True)
"""
