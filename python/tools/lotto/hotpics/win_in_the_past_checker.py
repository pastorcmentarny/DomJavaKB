import csv
import logging
import sys

# this app is used to provide information for given numbers how many times you won. it will check for 3,4,5,5+ and 6 number
# validate numbers to ensure is 6 of them and they are unique
# split them into all possible 3s 4s 5s and 6 number combinations
# load all results
# scan for hit for each combination
# result
base_dir = '../../../../data/lotto/'
logging.basicConfig(level=logging.DEBUG, format=' %(asctime)s - %(levelname)s - %(message)s',
                    filename=base_dir + 'log.txt')
sys.path.insert(0, '../utils')
import past_result_checker


# numbers = ['2 ', '5 ', '14', '22', '44']
numbers = ['51', '46', '59', '31', '22']


def main():
    logging.debug("checking if numbers you selected won in the past results for LOTTO HOTPICS")

    lotto_hotpicks_history_path = base_dir + 'lotto-hotpicks-all-draws.csv'
    lotto_hotpics_draw_history_file = open(lotto_hotpicks_history_path)

    print("If no result, ensure you format all results in " + lotto_hotpicks_history_path)

    # load data
    euro_hotpics_history_csv = csv.reader(lotto_hotpics_draw_history_file)
    data = list(euro_hotpics_history_csv)

    past_result_checker.check_for(True,numbers, data)


def validate():
    if len(numbers) > len(set(numbers)):
        raise ValueError("Numbers are not equal")
    else:
        print("Validation done. Given numbers are unique.")


if __name__ == '__main__':
    main()
