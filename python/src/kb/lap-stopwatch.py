import logging
import time

"""
# time.perf_counter() is for measure time! time.time is for time only

def measure_time_with_time_using_perf_counter():
    start = time.perf_counter()
    time.sleep(1)
    end = time.perf_counter()
    logging.info(end - start)

"""


def stopwatch():
    logging.info('Press ENTER to begin.\n\t Afterwards, press ENTER to "click" the stopwatch.\n\tPress CTRL+c to quit')

    input()
    logging.debug('Start .. ')
    start_time = time.perf_counter()
    last_time = time.perf_counter()
    lap_number = 1
    carry_on = True

    try:
        while carry_on:
            user_input = input()
            if user_input.lower() == 'x':
                carry_on = False
            lap_time = round(time.perf_counter() - last_time, 2)
            total_time = round(time.perf_counter() - start_time, 2)
            logging.info('Lap #%s: %ss (%ss)' % (lap_number, total_time, lap_time))
            lap_number += 1
            last_time = time.perf_counter()
    except KeyboardInterrupt:
        logging.warning("Game\n\tOver")


if __name__ == '__main__':
    logging_level = logging.DEBUG
    logging_format = "%(levelname)s :: %(asctime)s :: %(message)s"
    logging.basicConfig(level=logging_level, format=logging_format)

    stopwatch()
