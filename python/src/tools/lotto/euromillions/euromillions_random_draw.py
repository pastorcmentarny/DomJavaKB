import csv
import logging
import random
from timeit import default_timer as timer

from src.tools.lotto import config
from src.tools.lotto.utils import draws_downloader, output, lotto_utils

# ====== SETTINGS ========
open_lotto_website_in_webrowser = config.settings['open_page']
debug_mode = config.settings['debug_mode']
url = 'https://www.national-lottery.co.uk/results/euromillions/draw-history/csv'
path = lotto_hotpics_history_path = config.get_project_path('euro-draws.csv')
all_draws = config.get_project_path('euro-all-draws.csv')
# ====== -------- ========
logging.basicConfig(level=logging.DEBUG, format=' %(asctime)s - %(levelname)s - %(message)s',
                    filename=config.get_project_path('log.txt'))

data = draws_downloader.get_draws_for(url, path)
WRITABLE = 'w'
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
    if debug_mode:
        print(f'first line: {data[0]}')
        print(f'no. of column in first line : {len(data[0])}')

    all_draws_file = open(all_draws)
    all_draws_list = list(csv.reader(all_draws_file))
    last_column = len(all_draws_list[0]) - 1
    print(last_column)
    print(all_draws_list[0])
    last_draw = int(all_draws_list[0][0])
    draw_to_add = []
    current_draw = int(cleaned_data[0][0])
    counter = 0
    while last_draw != current_draw:  # FIXME
        print(f'current draw:{current_draw}, last draw: {last_draw}')
        draw_to_add.append(cleaned_data[counter])
        counter += 1
        current_draw = int(cleaned_data[counter][0])

    print(draw_to_add)
    all_draws_file = open(all_draws, WRITABLE)

    all_draws_file = draws_downloader.update_file_for(all_draws_file, draw_to_add)
    all_draws_file = draws_downloader.update_file_for(all_draws_file, all_draws_list)
    all_draws_file.close()


def stats():
    all_draws_file = open(all_draws)
    all_draws_list = list(csv.reader(all_draws_file))
    stars = {}
    stars_pair = []
    for a_draw in all_draws_list:
        first_number = int(a_draw[7].strip())
        second_number = int(a_draw[8].strip())
        stars[first_number] = stars.get(first_number, 0) + 1
        stars[second_number] = stars.get(second_number, 0) + 1
        stars_pair.append((first_number, second_number))
    print(f'stars count: {stars}')
    print(f'stars pairs count: {lotto_utils.count_pairs(stars_pair)}')
    last_played()


def last_played():
    all_draws_file = open(all_draws)
    all_draws_list = list(csv.reader(all_draws_file))
    last_played_list = {}
    last_played_stars_list = {}

    for number in range(1, 51):
        last_played_list[number] = 'Never'
        if number <= 12:
            last_played_stars_list[number] = 'Never'

    for draw in all_draws_list:
        print(draw)
        for column in range(2, 7):
            lotto_utils.assign_last_played_if_never_play_before(int(draw[column]), draw[1], last_played_list)
        for column in range(7,9):
            lotto_utils.assign_last_played_if_never_play_before(int(draw[column]), draw[1], last_played_stars_list)

    print(last_played_list)
    print(last_played_stars_list)


if __name__ == '__main__':
    start_time = timer()
    update_data()
    stats()
    draw()
    output.debug_mode_warning()
    end_time = timer()
    print('It took {} ms.'.format(int((end_time - start_time) * 1000)))
