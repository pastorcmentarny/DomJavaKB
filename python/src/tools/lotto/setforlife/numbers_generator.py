import logging
import os
import sys
import webbrowser
import csv
import requests
from src.tools.lotto import config

sys.path.insert(0, '../utils')

import draws_downloader
import lotto_utils
import output

game_name = 'set-for-life'
set_for_life_url = 'https://www.national-lottery.co.uk/results/' + game_name + '/draw-history/csv'
path = config.path["base"] + game_name + '.csv'
all_draws = config.path["base"] + game_name + '-all-draws.csv'

WRITABLE = 'w'  # move to config


def update_all_draws(recent_draws_list, all_draws_file_path):
    logging.debug('updating all draws if needed')
    last_column = len(recent_draws_list[0]) - 1
    print(last_column)
    all_draws_file = open(all_draws_file_path)
    all_draws_list = list(csv.reader(all_draws_file))

    last_draw = int(all_draws_list[0][last_column])
    draw_to_add = []
    current_draw = int(recent_draws_list[0][last_column])
    counter = 0
    while last_draw != current_draw:
        draw_to_add.append(recent_draws_list[counter])
        counter += 1
        current_draw = int(recent_draws_list[counter][last_column])

    print(draw_to_add)
    all_draws_file = open(all_draws_file_path, WRITABLE)
    all_draws_file = draws_downloader.update_file_for(all_draws_file, draw_to_add)
    all_draws_file = draws_downloader.update_file_for(all_draws_file, all_draws_list)
    all_draws_file.close()


def main():
    logging.debug('downloading  data from ' + set_for_life_url)
    response = requests.get(set_for_life_url)
    logging.debug('download complete with response ' + str(response.status_code))

    logging.debug(os.getcwd())

    data = draws_downloader.get_draws_for(set_for_life_url, path)
    update_all_draws(data, all_draws)

    logging.basicConfig(level=logging.DEBUG, format=' %(asctime)s - %(levelname)s - %(message)s',
                        filename=config.path["base"] + 'log.txt')

    print('number counter')
    numbers = {}
    for i in range(1, lotto_utils.get_last(47)):
        numbers[str(i)] = 0

    for line in data[1: len(data)]:
        for i in range(1, lotto_utils.get_last(5)):
            numbers[line[i]] = numbers.get(line[i], 0) + 1

    output.display_numbers(numbers)


if __name__ == '__main__':
    main()
