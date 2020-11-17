import csv
import logging
import random
import sys

from src.tools.lotto import config
from src.tools.lotto.utils import draws_downloader

sys.path.insert(0, '../utils')

# SETTINGS
url = 'https://www.national-lottery.co.uk/results/euromillions/draw-history/csv'
path = lotto_hotpics_history_path = config.get_project_path('euro-draws.csv')
# all_draws = config.get_project_path('euro-all-draws.csv')
logging.basicConfig(level=logging.DEBUG, format=' %(asctime)s - %(levelname)s - %(message)s',
                    filename=config.get_project_path('log.txt'))

data = draws_downloader.get_draws_for(url, path)
# draws_downloader.update_all_draws(data, all_draws)


numbers = []


# all no played numbers , last draw
def is_not_excluded(a_number):
    excluded_numbers_list = []

    for a_draw in data[0:2]:
        excluded_numbers_list.append(a_draw[1])
        excluded_numbers_list.append(a_draw[2])
        excluded_numbers_list.append(a_draw[3])
        excluded_numbers_list.append(a_draw[4])
        excluded_numbers_list.append(a_draw[5])

    if a_number in excluded_numbers_list:
        return False
    return True


def draw():
    for i in range(1, 51):
        if is_not_excluded(i):
            numbers.append(i)
    random.shuffle(numbers)

    count = 1
    for i in numbers:
        print(i)
        count += 1
        if count == 6:
            count = 1
            print()
            bonus = list(range(1, 13))
            random.shuffle(bonus)
            random.shuffle(bonus)
            print('1: {} , 2: {}'.format(bonus[3], bonus[7]))


def update_data():
    cleaned_data = []
    for draw in data:
        draw_line = [draw[9], draw[0], draw[1], draw[2], draw[3], draw[4], draw[5], draw[6], draw[7]]
        cleaned_data.append(draw_line)
    last_column = len(data[0]) - 1
    print(last_column)
    all_draws_file = open(all_draws)
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
    all_draws_file = update_file_for(all_draws_file, draw_to_add)
    all_draws_file = update_file_for(all_draws_file, all_draws_list)
    all_draws_file.close()

if __name__ == '__main__':
    #update_data()
    draw()
