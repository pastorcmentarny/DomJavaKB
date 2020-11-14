import csv
import os
import random

from src.tools.lotto.utils import lotto_utils, output

# load all draws
# exclude last 2 draws
# exclude first most numbers and 2 least
# lotto_hotpicks_url = 'https://www.national-lottery.co.uk/results/lotto-hotpicks/draw-history/csv'
# path = config.path["base"] + 'lotto-hotpicks-draws.csv'
# all_draws = config.path["base"] + 'lotto-hotpicks-all-draws.csv'
# logging.debug('downloading  data from ' + lotto_hotpicks_url)
# response = requests.get(lotto_hotpicks_url)
# logging.debug('download complete with response ' + str(response.status_code))
# data = draws_downloader.get_draws_for(lotto_hotpicks_url, path)
# draws_downloader.update_all_draws_v2(data, all_draws)
# bonus ball
# check results in the past

# 2 random number
# 2 numbers that played 3-9
# 2 numbers that played 10+

from src.tools.lotto import config
from src.tools.lotto.utils.output import draw_title

all_draws_path = config.get_project_path('lotto-hotpicks-all-draws.csv')
draw_history_file = open(all_draws_path)
hotpics_history_csv = csv.reader(draw_history_file)
data = list(hotpics_history_csv)

recent_draws_path = config.get_project_path('lotto-hotpicks-draws.csv')
recent_draws_history_file = open(recent_draws_path)
recent_hotpics_history_csv = csv.reader(recent_draws_history_file)
recent_data = list(recent_hotpics_history_csv)


def get_numbers_played_count_for_all_draws() -> dict:
    output.draw_title('total numbers played count in ALL draws')

    numbers = {}
    for number in range(1, 60):
        numbers[str(number)] = 0

    for line in data[1: len(data)]:
        for number in range(1, 7):
            line_number = line[number].strip()
            numbers[line_number] = numbers.get(line_number, 0) + 1
    return numbers


def get_numbers_played_count_in_recent_draws() -> dict:
    output.draw_title('total numbers played count in RECENT draws')
    numbers = {}
    for number in range(1, 60):
        numbers[str(number)] = 0

    for line in recent_data[1: len(recent_data)]:
        for number in range(1, 7):
            line_number = line[number].strip()
            numbers[line_number] = numbers.get(line_number, 0) + 1
    return numbers


def stats():
    output.display_numbers(get_numbers_played_count_for_all_draws())
    output.display_numbers(get_numbers_played_count_in_recent_draws())


def generate_random_number():
    numbers = []
    excluded = []
    for line in data[0: 2]:
        for number in range(1, lotto_utils.get_last(6)):
            excluded.append(int(line[number]))
    print_excluded_numbers(excluded)

    for number in range(1, 60):
        if number not in excluded:
            numbers.append(number)

    for number in range(1, 1770):
        random.shuffle(numbers)
    print(f'after {numbers}')

    count = 1
    draw = []
    draw_title('draws')
    for number in numbers:
        draw.append(number)
        count += 1
        if count == 7:
            count = 1
            print(sorted(draw))
            draw.clear()


def print_excluded_numbers(excluded):
    draw_title('excluded numbers')
    print(excluded)


def generate_next_draw():
    draw_title('Generate numbers for next draw', 2)
    next_draw_number = []
    first_second_number_list = []

    # select 2 numbers that played between 3 and 9th draw
    for line in data[3: 9]:
        for number in range(1, lotto_utils.get_last(6)):
            first_second_number_list.append(int(line[number]))
    for number in range(1, 1770):
        random.shuffle(first_second_number_list)
    next_draw_number.append(first_second_number_list[1])
    next_draw_number.append(first_second_number_list[2])

    # select 2 from top 10 numbers that didn't play longest

    next_draw_number.append(int(n34()[3][0]))
    next_draw_number.append(int(n34()[4][0]))

    # select one number that didn't play longer than 10 draws
    next_draw_number.append(int(n56()[5][0]))
    next_draw_number.append(int(n56()[6][0]))

    # generate random numbers if number is duplicate
    next_draw_number = set(next_draw_number)

    excluded = []
    for line in data[0: 2]:
        for number in range(1, lotto_utils.get_last(6)):
            excluded.append(int(line[number]))
    while len(next_draw_number) < 6:
        next_draw_number = list(next_draw_number)
        next_draw_number.append(str(random.randint(1, 60)))
        next_draw_number = set(next_draw_number)

    # check against stats
    next_draw_number = list(next_draw_number)
    check_wins_in_the_past(next_draw_number)

    print(next_draw_number)


def n34() -> list:
    numbers = get_numbers_played_count_for_all_draws()
    return [(key, numbers[key]) for key in sorted(numbers, key=numbers.get, reverse=True)]


def n56() -> list:
    numbers = get_numbers_played_count_in_recent_draws()
    return [(key, numbers[key]) for key in sorted(numbers, key=numbers.get, reverse=True)]


def check_wins_in_the_past(draw: list):
    print("checking if numbers you selected won in the past results for LOTTO HOTPICS")

    print('Numbers' + str(draw))
    print(os.getcwd())

    for n in range(len(draw), 0, -1):
        print(str(n) + "'s : " + str(count_hits(n, draw)))


def count_hits(must_hit: int, numbers: list):
    counter = 0
    for draw in data:
        hit = 0
        for n in range(0, len(numbers)):
            if str(numbers[n]) in draw:
                hit += 1
        if hit >= must_hit:
            counter += 1

    return counter


if __name__ == '__main__':
    stats()
    generate_random_number()
    generate_next_draw()
