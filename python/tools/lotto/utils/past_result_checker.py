import logging
import os

# this app is used to provide information for given numbers how many times you won. it will check for 3,4,5,5+ and 6 number
# validate numbers to ensure is 6 of them and they are unique
# split them into all possible 3s 4s 5s and 6 number combinations
# load all results
# scan for hit for each combination
# result
base_dir = '../../../../data/lotto/'
logging.basicConfig(level=logging.DEBUG, format=' %(asctime)s - %(levelname)s - %(message)s',
                    filename=base_dir + 'log.txt')


def check_for(display_info: bool, numbers, data: list):
    logging.debug("checking if numbers you selected won in the past results")
    if display_info:
        info(numbers)

    for n in range(len(numbers), 0, -1):
        print(str(n) + "'s : " + str(count_hits(data, n, numbers)))


def info(numbers: list):
    print('Numbers' + str(numbers))
    print(os.getcwd())


# improve it
def count_hits(data: list, must_hit: int, numbers: list):
    counter = 0
    for draw in data:
        hit = 0
        for n in range(0, len(numbers)):
            if numbers[n] in draw:
                hit += 1
        if hit >= must_hit:
            counter += 1
    return counter
