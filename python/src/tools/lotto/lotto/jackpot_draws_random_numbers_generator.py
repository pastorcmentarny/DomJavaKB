import os
import random

from src.tools.lotto import config
from src.tools.lotto.utils import lotto_utils
from src.tools.lotto.tools import draws_manager
from src.tools.lotto.utils.output import draw_title

# ======== settings ========
debug_mode = config.settings['debug_mode']
excluded_custom_numbers = []
# ======== -------- ========

recent_draws_data = draws_manager.get_recent_draws_for_lotto_and_hotpicks()
all_draws_list = draws_manager.get_all_draws_for_lotto()


def generate_random_draws_for_jackpot():
    numbers = []
    excluded = []

    # exclude some numbers
    for line in recent_draws_data[0: 2]:
        for number in range(1, lotto_utils.get_last(6)):
            excluded.append(int(line[number]))
    for excluded_custom_number in excluded_custom_numbers:
        excluded.append(excluded_custom_number)
    excluded = list(set(excluded))  # clean duplicated numbers

    print_numbers(excluded, "Excluded numbers")

    # shuffle numbers
    for number in range(1, 60):
        if number not in excluded:
            numbers.append(number)

    for number in range(1, 1770):
        random.shuffle(numbers)
    print_numbers(excluded, "Shuffled numbers")

    # display draws
    count = 1
    draw = []
    draw_title('Draws')
    for number in numbers:
        draw.append(number)
        count += 1
        if count == 7:
            count = 1
            print(sorted(draw))
            # TODO add past result checker
            draw.clear()


def print_numbers(excluded: list, title: str):
    if debug_mode:
        draw_title(title)
        print(excluded)


# FIX ME
def check_wins_in_the_past(draw: list):
    print("checking if numbers you selected won in the past results for LOTTO HOTPICS")

    print('Numbers' + str(draw))
    print(os.getcwd())

    for n in range(len(draw), 0, -1):
        print(str(n) + "'s : " + str(lotto_utils.count_hits(n, draw, data)))


if __name__ == '__main__':
    generate_random_draws_for_jackpot()
