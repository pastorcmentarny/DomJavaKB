import csv
import logging
import sys

from src.tools.lotto import config

logging.basicConfig(level=logging.DEBUG, format=' %(asctime)s - %(levelname)s - %(message)s',
                    filename=config.path["base"] + 'log.txt')

sys.path.insert(0, '../utils')
import past_result_checker

numbers = ['2', '25', '39', '0', '0']
thunderbaall = [1]

def main():
    logging.debug("checking if numbers you selected won in the past results for THUNDERBALL")
    thunderball_path = config.path["base"] + 'thunderball-all-draws.csv'
    thunderball_file = open(thunderball_path)

    config.display_warning_message(thunderball_path)

    # load data
    thunderball_csv = csv.reader(thunderball_file)
    data = list(thunderball_csv)

    past_result_checker.check_for(True, numbers, data,thunderbaall)

if __name__ == '__main__':
    main()
