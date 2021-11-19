import logging
"""
Don't Debug with print() use logging instead
"""


def display_logs():
    logging.debug("This is a debugging level")
    logging.info("This is a info level")
    logging.warning('This is a warning level')
    logging.error('This is a error level')
    logging.critical('This is a critical level .shit happens')


logging.debug('End of the application. Goodbye!')

# DEFAULT LOGS SETUP FOR MY SCRIPT TO USe
if __name__ == '__main__':
    #   Screen version:
    logging_level = logging.DEBUG
    logging_format = "%(levelname)s :: %(asctime)s :: %(message)s"

    logging.basicConfig(level=logging_level, format=logging_format)

    #   File version
    logging_filename = 'logs.txt'

    # logging.basicConfig(level=logging_level, format=logging_format, filename=logging_filename)

    display_logs()
