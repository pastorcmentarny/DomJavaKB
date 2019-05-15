import logging
import os
from src.tools.lotto import config

# this app is used to provide information for given numbers how many times you won. it will check for 3,4,5,5+ and 6 number
# validate numbers to ensure is 6 of them and they are unique
# split them into all possible 3s 4s 5s and 6 number combinations
# load all results
# scan for hit for each combination
# result

logging.basicConfig(level=logging.DEBUG, format=' %(asctime)s - %(levelname)s - %(message)s',
                    filename=config.path["base"] + 'log.txt')


def check_for(display_info: bool, numbers, data: list):
    logging.debug("checking if numbers you selected won in the past results")
    if display_info:
        info(numbers)

    for n in range(len(numbers), 0, -1):
        print(str(n) + "'s : " + str(count_hits(data, n, numbers)))


def check_for_with_bonus(display_info: bool, numbers, data: list, bonus: int):
    logging.debug("checking if numbers you selected won in the past results")
    if display_info:
        info(numbers)

    for n in range(len(numbers), 0, -1):
        print(str(n) + "'s : " + str(count_hits(data, n, numbers, bonus)))


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


# improve it
# Prize breakdown listed below.
# No. of matches	All winners	Prize per winner	Prize fund
# Match 5 + Thunderball	0	£0	£0
# Match 5	10	£5,000	£50,000
# Match 4 + Thunderball	88	£250	£22,000
# Match 4	1,056	£100	£105,600
# Match 3 + Thunderball	1,761	£20	£35,220
# Match 3	22,467	£10	£224,670
# Match 2 + Thunderball	17,989	£10	£179,890
# Match 1 + Thunderball	69,168	£5	£345,840
# Match 0 + Thunderbal
def count_hits_with_bonus(data: list, must_hit: int, numbers: list, bonus_drawn: int, bonus_your: int):
    counter = 0
    for draw in data:
        hit = 0
        for n in range(0, len(numbers)):
            if numbers[n] in draw:
                hit += 1
        if hit >= must_hit:
            counter += 1
    return counter
