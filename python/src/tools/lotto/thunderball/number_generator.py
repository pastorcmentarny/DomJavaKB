import logging
import sys
from timeit import default_timer as timer

sys.path.insert(0, '../utils')

import draws_downloader
import output
import lotto_utils
from src.tools.lotto import config

total_thunderballs = 40  # 39

# SETTINGS
url = 'https://www.national-lottery.co.uk/results/thunderball/draw-history/csv'
path = thunderball_history_path = config.path["base"] + 'thunderball-draws.csv'
all_draws = config.path["base"] + 'thunderball-all-draws.csv'

logging.basicConfig(level=logging.DEBUG, format=' %(asctime)s - %(levelname)s - %(message)s',
                    filename=config.path["base"] + 'log.txt')

matches = {
    9: 'Match 5 + Thunderball(£500.000)',
    8: 'Match 5(£5.000)',
    7: 'Match 4 + Thunderball(£250)',
    6: 'Match 4(£100)',
    5: 'Match 3 + Thunderball(£20)',
    4: 'Match 3)(£10)',
    3: 'Match 2 + Thunderball(£10)',
    2: 'Match 1 + Thunderball(£5)',
    1: 'Match 0 + Thunderball(£3)',
    0: 'No Match'
}


def convert_to_list(numbers) -> list:
    result = []
    numbers = [(key, numbers[key]) for key in sorted(numbers, key=numbers.get, reverse=True)]
    for key_value, _ in numbers:
        result.append(key_value)
    return numbers


def get_result_description(level: int) -> str:
    return matches[level]


def get_draw_result(hits: int, tb: bool = True):
    if tb:
        if hits == 5:
            return 9
        if hits == 4:
            return 7
        if hits == 3:
            return 5
        if hits == 2:
            return 3
        if hits == 1:
            return 2
        else:
            return 1
    else:
        if hits == 5:
            return 8
        if hits == 4:
            return 6
        if hits == 3:
            return 4
    return 0


def count_wins_in_the_past(chosen_numbers: list, data_results):
    wins = {
        9: 0,
        8: 0,
        7: 0,
        6: 0,
        5: 0,
        4: 0,
        3: 0,
        2: 0,
        1: 0,
        0: 0
    }
    print("all draws size {}".format(len(data_results)))
    for draw in data_results[1:6]:
        hit = 0
        for n in chosen_numbers:
            if str(n) in draw:
                hit += 1

        wins[get_draw_result(hit, True)] += 1
        wins[get_draw_result(hit, False)] += 1
    return wins


WITHOUT_THUNDERBALL = False


def test():
    print(get_result_description(get_draw_result(5)))
    print(get_result_description(get_draw_result(5, WITHOUT_THUNDERBALL)))
    print(get_result_description(get_draw_result(4)))
    print(get_result_description(get_draw_result(4, WITHOUT_THUNDERBALL)))
    print(get_result_description(get_draw_result(3)))
    print(get_result_description(get_draw_result(3, WITHOUT_THUNDERBALL)))
    print(get_result_description(get_draw_result(2)))
    print(get_result_description(get_draw_result(1)))
    print(get_result_description(get_draw_result(0)))
    print(get_result_description(get_draw_result(0, WITHOUT_THUNDERBALL)))


def display_wins_result_for(draw_result, data_results):
    print(draw_result)
    wins_result = count_wins_in_the_past(draw_result, data_results)
    for result_level, number in wins_result.items():
        print('{} x{}'.format(get_result_description(result_level), number))


def generate_numbers_for_thunderball():
    excluded = []
    data = draws_downloader.get_draws_for(url, path)
    print('number counter')
    numbers = {}
    for i in range(1, lotto_utils.get_last(39)):
        numbers[str(i)] = 0

    for line in data[1: len(data)]:
        for i in range(1, lotto_utils.get_last(5)):
            numbers[line[i]] = numbers.get(line[i], 0) + 1

    output.display_numbers(numbers)

    thunderballs = {}
    for i in range(1, lotto_utils.get_last(14)):
        thunderballs[str(i)] = 0

    thunderball_column = 6
    for line in data[1: len(data)]:
        thunderballs[line[thunderball_column]] = thunderballs.get(line[thunderball_column], 0) + 1

    print('\n\nthunderballs:')
    output.display_numbers(thunderballs)

    print("\n\n numbers that didn't play in last 10 games:")

    numbers_to_delete = []
    for line in data[0:10]:
        for i in range(1, lotto_utils.get_last(5)):
            numbers_to_delete.append(line[i])

    numbers_to_delete = list(set(numbers_to_delete))
    print(numbers_to_delete)

    for value in numbers_to_delete:
        numbers.pop(value)

    # exclude most popular number and two least popular
    numbers_as_list = convert_to_list(numbers)
    excluded.append(int(numbers_as_list[0][0]))
    excluded.append(int(numbers_as_list[len(numbers_as_list) - 2][0]))
    excluded.append(int(numbers_as_list[len(numbers_as_list) - 1][0]))

    numbers = output.display_numbers(numbers)

    print("\n\n thunderballs that didn't play in last 10 games:")

    thunderball_to_delete = []
    for line in data[0:10]:
        thunderball_to_delete.append(line[thunderball_column])

    thunderball_to_delete = list(set(thunderball_to_delete))
    logging.debug(thunderball_to_delete)

    for value in thunderball_to_delete:
        thunderballs.pop(value)

    thunderballs = output.display_numbers(thunderballs)

    # draw system 2.0  exlude last draw , least 2 numbers and first number generate randomly with one number from most count
    draw_numbers = []

    for line in data[0: 2]:
        for i in range(1, lotto_utils.get_last(5)):
            excluded.append(int(line[i]))

    print('excluded number count: {} with numbers {}'.format(len(excluded), excluded))
    excluded = list(set(excluded))

    numbers_to_draw = []
    counter = 0

    for i in range(1, total_thunderballs):
        if i not in excluded:
            numbers_to_draw.append(i)
        else:
            counter += 1

    print('excluded unique number counter : {}'.format(counter))

    shuffles_times = random.randint(1, total_thunderballs * total_thunderballs)
    for i in range(1, shuffles_times):
        random.shuffle(numbers_to_draw)

    count = 1
    draw_result = []
    for i in numbers_to_draw:
        draw_result.append(i)
        count += 1
        if count == 6:
            count = 1
            display_wins_result_for(draw_result, data)
            draw_result.clear()


data = draws_downloader.get_draws_for(url, path)
print('number counter')
numbers = {}
for i in range(1, lotto_utils.get_last(39)):
    numbers[str(i)] = 0

for line in data[1: len(data)]:
    for i in range(1, lotto_utils.get_last(5)):
        numbers[line[i]] = numbers.get(line[i], 0) + 1

output.display_numbers(numbers)

thunderballs = {}
for i in range(1, lotto_utils.get_last(14)):
    thunderballs[str(i)] = 0

thunderball_column = 6
for line in data[1: len(data)]:
    thunderballs[line[thunderball_column]] = thunderballs.get(line[thunderball_column], 0) + 1

print('\n\nthunderballs:')
output.display_numbers(thunderballs)

print("\n\n numbers that didn't play in last 10 games:")

numbers_to_delete = []
for line in data[0:10]:
    for i in range(1, lotto_utils.get_last(5)):
        numbers_to_delete.append(line[i])

numbers_to_delete = list(set(numbers_to_delete))
print(numbers_to_delete)

for value in numbers_to_delete:
    numbers.pop(value)

# exclude most popular number and two least popular
numbers_as_list = convert_to_list(numbers)
excluded.append(int(numbers_as_list[0][0]))
excluded.append(int(numbers_as_list[len(numbers_as_list) - 2][0]))
excluded.append(int(numbers_as_list[len(numbers_as_list) - 1][0]))

numbers = output.display_numbers(numbers)

print("\n\n thunderballs that didn't play in last 10 games:")

thunderball_to_delete = []
for line in data[0:10]:
    thunderball_to_delete.append(line[thunderball_column])

thunderball_to_delete = list(set(thunderball_to_delete))
logging.debug(thunderball_to_delete)

for value in thunderball_to_delete:
    thunderballs.pop(value)

thunderballs = output.display_numbers(thunderballs)
