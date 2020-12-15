import random
from timeit import default_timer as timer

from src.tools.lotto import config
from src.tools.lotto.utils import draws_manager, output, lotto_utils

# ====== SETTINGS ========
open_lotto_website_in_webrowser = config.settings['open_page']
debug_mode = config.settings['debug_mode']
# ====== -------- ========

recent_draw_data = draws_manager.get_recent_draws_for_euromillions()
numbers = []


# all no played numbers , last draw
def is_not_excluded(a_number):
    excluded_numbers_list = []

    for a_draw in recent_draw_data[0:2]:
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


def stats():
    all_draws_list = draws_manager.load_all_draws_for_euromillions()
    stars = {}
    stars_pair = []
    for a_draw in all_draws_list:
        first_number = int(a_draw[7].strip())
        second_number = int(a_draw[8].strip())
        stars[first_number] = stars.get(first_number, 0) + 1
        stars[second_number] = stars.get(second_number, 0) + 1
        stars_pair.append((first_number, second_number))
    output.display_numbers(stars, 'stars count:')
    output.display_numbers(lotto_utils.count_pairs(stars_pair), 'stars pairs count:')
    last_played()


def last_played():
    all_draws_list = draws_manager.load_all_draws_for_euromillions()
    last_played_list = {}
    last_played_stars_list = {}

    for number in range(1, 51):
        last_played_list[number] = 'Never'
        if number <= 12:
            last_played_stars_list[number] = 'Never'

    for a_draw in all_draws_list:
        for column in range(2, 7):
            lotto_utils.assign_last_played_if_never_play_before(int(a_draw[column]), a_draw[1], last_played_list)
        for column in range(7, 9):
            lotto_utils.assign_last_played_if_never_play_before(int(a_draw[column]), a_draw[1], last_played_stars_list)

    output.display_numbers(last_played_list, 'last played number date:')
    output.display_numbers(last_played_stars_list, 'last played stars date:')


if __name__ == '__main__':
    start_time = timer()
    stats()
    draw()
    output.debug_mode_warning()
    end_time = timer()
    print('It took {} ms.'.format(int((end_time - start_time) * 1000)))
