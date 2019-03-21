import csv
import logging
import sys
sys.path.insert(0, '../utils')
import past_result_checker
from src.tools.lotto import config


# this app is used to provide information for given numbers how many times you won. it will check for 3,4,5,5+ and 6 number
# validate numbers to ensure is 6 of them and they are unique
# split them into all possible 3s 4s 5s and 6 number combinations
# load all results
# scan for hit for each combination
# result

logging.basicConfig(level=logging.DEBUG, format=' %(asctime)s - %(levelname)s - %(message)s',
                    filename=config.path["base"] + 'log.txt')

numbers = ['2', '25', '57', '11', '8', '33']


def main():
    logging.debug("checking if numbers you selected won in the past results for LOTTO HOTPICS")

    lotto_hotpicks_history_path = config.path["base"] + 'lotto-hotpicks-all-draws.csv'
    lotto_hotpics_draw_history_file = open(lotto_hotpicks_history_path)

    config.display_warning_message(lotto_hotpicks_history_path)

    # load data
    euro_hotpics_history_csv = csv.reader(lotto_hotpics_draw_history_file)
    data = list(euro_hotpics_history_csv)

    past_result_checker.check_for(True, numbers, data)


def validate():
    if len(numbers) > len(set(numbers)):
        raise ValueError("Numbers are not equal")
    else:
        print("Validation done. Given numbers are unique.")


if __name__ == '__main__':
    main()
