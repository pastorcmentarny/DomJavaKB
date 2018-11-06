import logging

# Don’t Debug with print()
logging.basicConfig(level=logging.DEBUG, format=' %(asctime)s - %(levelname)s - %(message)s',
                    filename='myProgramLog.txt')

logging.debug('Starting application ..')


def factorial(number):
    logging.debug('Calculating factorial for: ' + str(number))
    total = 1
    for i in range(1, number + 1):
        total *= i
        logging.debug("For " + str(i) + ' total is : ' + str(total))
    logging.debug("Result is :" + str(total))


def displayLogs():
    logging.debug("This is a debugging level")
    logging.info("This is a info level")
    logging.warning('This is a warning level')
    logging.error('This is a error level')
    logging.critical('This is a critcal level .shit happens')


print(factorial(6))

print('set logs to INFO')
logging.basicConfig(level=logging.INFO, format=' %(asctime)s - %(levelname)s - %(message)s',
                    filename='myProgramLog.txt')
displayLogs()

print('set logs to WARN')
logging.basicConfig(level=logging.WARN, format=' %(asctime)s - %(levelname)s - %(message)s',
                    filename='myProgramLog.txt')
displayLogs()

logging.debug('End of the application. Goodbye!')
