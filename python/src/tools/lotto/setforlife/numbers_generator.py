import csv
import logging
import os

import requests

from src.tools.lotto import config
from src.tools.lotto.utils import draws_downloader
from src.tools.lotto.utils import lotto_utils
from src.tools.lotto.utils import output

game_name = 'set-for-life'
set_for_life_url = f'https://www.national-lottery.co.uk/results/{game_name}/draw-history/csv'
path = config.get_project_path(f'{game_name}-draws.csv')
all_draws = config.get_project_path(f'{game_name}-all-draws.csv')


def generate_random_numbers_for_setforlife():
    logging.debug('downloading  data from ' + set_for_life_url)
    response = requests.get(set_for_life_url)
    logging.debug('download complete with response ' + str(response.status_code))

    logging.debug(os.getcwd())

    data = draws_downloader.get_draws_for(set_for_life_url, path)
    draws_downloader.update_all_draws_for_set_for_life(data, all_draws)

    logging.basicConfig(level=logging.DEBUG, format=' %(asctime)s - %(levelname)s - %(message)s',
                        filename=config.get_project_path('log.txt'))

    print('number counter')
    numbers = {}
    for i in range(1, lotto_utils.get_last(47)):
        numbers[str(i)] = 0

    for line in data[1: len(data)]:
        for i in range(1, lotto_utils.get_last(5)):
            numbers[line[i]] = numbers.get(line[i], 0) + 1

    output.display_numbers(numbers)


if __name__ == '__main__':
    generate_random_numbers_for_setforlife()
