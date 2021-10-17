import datetime
import time
from subprocess import PIPE, Popen

from blinkt import set_pixel, set_brightness, show

set_brightness(0.1)

ALERT_COLOR = [255, 0, 0]
WARNING_COLOR = [255, 126, 0]
GOOD_COLOR = [154, 205, 50]
OFF_COLOR = [155, 38, 182]
UNKNOWN_COLOR = [0, 0, 255]
ALL_COLORS = [ALERT_COLOR, WARNING_COLOR, GOOD_COLOR, OFF_COLOR, UNKNOWN_COLOR]

"""
0 system
1 app itself
2
3 UI
4 SERVICE
5 DB
6
7
"""

status = {
    "System": UNKNOWN_COLOR,
    "App": UNKNOWN_COLOR,
    "TM_UI": UNKNOWN_COLOR,
    "TM_SERVICE": UNKNOWN_COLOR,
    "TM_DB": UNKNOWN_COLOR,
}

RED = 0
GREEN = 1
BLUE = 2


def get_cpu_temperature():
    process = Popen(['vcgencmd', 'measure_temp'], stdout=PIPE)
    output, _error = process.communicate()
    output = output.decode()

    pos_start = output.index('=') + 1
    pos_end = output.rindex("'")

    temp = float(output[pos_start:pos_end])

    return temp


def get_ram_available():
    pass


def get_space_free():
    pass


def update_brightness():
    now = datetime.datetime.now()
    hour = now.hour
    if hour < 6 or hour >= 22:
        set_brightness(0.1)
    elif hour < 9 or hour > 15:
        set_brightness(0.2)
    else:
        set_brightness(0.4)


def display_light():
    set_pixel(0, status["System"][RED], status["System"][GREEN], status["System"][BLUE])
    set_pixel(1, status["App"][RED], status["App"][GREEN], status["App"][BLUE])
    set_pixel(3, status["TM_UI"][RED], status["TM_UI"][GREEN], status["TM_UI"][BLUE])
    set_pixel(4, status["TM_SERVICE"][RED], status["TM_SERVICE"][GREEN], status["TM_SERVICE"][BLUE])
    set_pixel(5, status["TM_DB"][RED], status["TM_DB"][GREEN], status["TM_DB"][BLUE])
    update_brightness()
    show()


def device_healthcheck():
    temp = get_cpu_temperature()
    if temp > 70.0:
        status["System"] = ALERT_COLOR
    elif temp > 50.0:
        status["System"] = WARNING_COLOR
    else:
        status["System"] = GOOD_COLOR


def app_healthcheck():
    status["App"] = GOOD_COLOR


def healthcheck():
    device_healthcheck()
    app_healthcheck()


def app_loop():
    while True:
        healthcheck()
        display_light()
        time.sleep(5)


def setup():
    display_light()


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
