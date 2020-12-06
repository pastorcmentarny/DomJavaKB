import csv
import itertools
import os
import random
import webbrowser
from timeit import default_timer as timer

import requests

from src.tools.lotto import config
from src.tools.lotto.utils import lotto_utils, output, draws_downloader
from src.tools.lotto.utils.output import draw_title

# ======== settings ========
debug_mode = config.settings['debug_mode']
detailed_mode = config.settings['detailed_mode']
open_lotto_website_in_webrowser = config.settings['open_page']
# ======== -------- ========

lotto_hotpicks_url = 'https://www.national-lottery.co.uk/results/lotto-hotpicks/draw-history/csv'
path = config.get_project_path('lotto-hotpicks-draws.csv')
all_draws = config.get_project_path('lotto-hotpicks-all-draws.csv')
result = config.get_project_path('result_double.txt')
percentage_format = "%.2f"

all_draws_file = open(all_draws, 'r')
all_draws_csv = csv.reader(all_draws_file)
all_draws_data = list(all_draws_csv)
print('Downloading  data from ' + lotto_hotpicks_url)
response = requests.get(lotto_hotpicks_url)
print('Download complete with response ' + str(response.status_code))
recent_draws_path = config.get_project_path('lotto-hotpicks-draws.csv')
recent_draws_history_file = open(recent_draws_path)
recent_hotpics_history_csv = csv.reader(recent_draws_history_file)
recent_data = list(recent_hotpics_history_csv)
data = {}
all_draws_number_counter = {}
all_doubles_result = {}


class Doubles:
    def __init__(self, number1, number2):
        # sorted from smallest to highest
        self.number1 = number1
        self.number2 = number2
        self.count = 0

    def __repr__(self):
        return repr((self.number1, self.number2, self.count))

    def contains_number(self, number):
        return number == self.number1 or number == self.number2

    def contains_all_numbers(self, n1, n2):
        return self.contains_number(int(n1)) and self.contains_number(int(n2))

    def verify(self):
        return self.number1 != self.number2

    def add(self):
        self.count += 1

    def get_count(self):
        return self.count

    def sort_numbers(self):
        list = [self.number1, self.number2]
        list.sort(key=int)
        self.number1 = list [0]
        self.number2 = list[1]


def update_draws():
    global data
    data = draws_downloader.get_draws_for(lotto_hotpicks_url, path)
    draws_downloader.update_all_draws_v2(data, all_draws)


def generate_stats():
    global all_draws_number_counter
    lotto_hotpicks_history_path = config.get_project_path('lotto-hotpicks-all-draws.csv')
    lotto_hotpics_draw_history_file = open(lotto_hotpicks_history_path)
    euro_hotpics_history_csv = csv.reader(lotto_hotpics_draw_history_file)
    data = list(euro_hotpics_history_csv)

    # display numbers count
    all_draws_number_counter = {}

    for line in data[1: len(data)]:
        for number in range(1, 7):
            line_number = line[number].strip()
            all_draws_number_counter[line_number] = all_draws_number_counter.get(line_number, 0) + 1

    count_doubles()


def display_numbers(numbers: dict):
    numbers = [(key, numbers[key]
                ) for key in sorted(numbers, key=numbers.get, reverse=True)]
    for key, value in numbers:
        print(str(key) + ': ' + str(value))


def generate_numbers_for_hotpics():
    numbers = {}

    for i in range(1, 60):
        numbers[str(i)] = 0

    for line in data[1: len(data)]:
        for i in range(1, lotto_utils.get_last(6)):
            numbers[line[i]] = numbers.get(line[i], 0) + 1

    if detailed_mode:
        output.display_numbers(numbers)

    numbers_to_delete = []
    for line in data[0:10]:
        for i in range(1, lotto_utils.get_last(6)):
            numbers_to_delete.append(line[i])

    numbers_to_delete = list(set(numbers_to_delete))

    output.debug_print(f'Numbers to delete: {numbers_to_delete}')

    for value in numbers_to_delete:
        numbers.pop(value)

    numbers_to_select = numbers
    output.display_numbers(numbers)

    return lotto_utils.select_random_number_from_two_highest_len_of_played_game(
        lotto_utils.sort_with_key_as_number_game_played(numbers_to_select))


def display_stats():
    numbers = [(key, all_draws_number_counter[key]
                ) for key in sorted(all_draws_number_counter, key=all_draws_number_counter.get, reverse=True)]
    for key, value in numbers:
        print(str(key) + ': ' + str(value))

    for double in all_doubles_result:
        print(double)


def count_doubles():
    global all_doubles_result
    print("generate pair number counter..")

    doubles_list = generate_all_possible_doubles()

    all_sorted_combinations = generate_all_possible_doubles_combination()

    total = int(len(list(all_sorted_combinations)) * len(doubles_list))
    step = int(total / 12500)

    count_all_doubles_drawn(all_sorted_combinations, step, total, doubles_list)

    doubles_list = sorting_result(doubles_list)

    saving_result_to_file(doubles_list)

    all_doubles_result = doubles_list
    print("Counting doubles done")


def generate_all_possible_doubles_combination():
    print("generate all possible doubles from all draws")
    all_sorted_combinations = []
    for draw in all_draws_data:
        numbers = [draw[1], draw[2], draw[3], draw[4], draw[5], draw[6]]
        draw_combinations = itertools.combinations(numbers, 2)
        all_sorted_combinations.extend(draw_combinations)
    return all_sorted_combinations


def saving_result_to_file(doubles_list):
    print("saving result to file")
    result_file = open(result, 'w')
    for triple in doubles_list:
        result_file.write(
            str(triple.number1) + " " + str(triple.number2) + ": Count:" + str(
                triple.count) + '\n')
    result_file.close()


def sorting_result(doubles_list):
    print("sorting result ...")
    doubles_list = list(doubles_list)
    doubles_list = sorted(doubles_list, reverse=True, key=lambda triple: triple.count)
    return doubles_list


def count_all_doubles_drawn(all_sorted_combinations, step, total, triples_list):
    print("start counting")
    counter = 0
    for sc in all_sorted_combinations:
        if counter % step == 0:
            progress = counter / total * 100
            print(f'Counting.. Progress: {(percentage_format % progress)}')

        sorted_list = [sc[0], sc[1]]
        sorted_list = list(sorted_list)
        sorted_list.sort(key=int)
        for triple in triples_list:
            counter += 1
            if triple.contains_all_numbers(sorted_list[0], sorted_list[1]):
                triple.add()


def generate_all_possible_doubles():
    print("generate all possible doubles")
    triples_list = set()
    all_doubles_combinations = itertools.combinations(range(1, 60), 2)
    for triple_combination in all_doubles_combinations:
        sorted_list = [triple_combination[0], triple_combination[1]]
        sorted_list.sort(key=int)
        triples_list.add(Doubles(sorted_list[0], sorted_list[1]))
    return triples_list


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

def n34() -> list:
    numbers = get_numbers_played_count_for_all_draws()
    return [(key, numbers[key]) for key in sorted(numbers, key=numbers.get, reverse=True)]


def n56() -> list:
    numbers = get_numbers_played_count_in_recent_draws()
    return [(key, numbers[key]) for key in sorted(numbers, key=numbers.get, reverse=True)]


def check_wins_in_the_past(draw: list):
    print("checking if numbers you selected won in the past results for LOTTO HOTPICS")
    output.print_if_detailed_mode_enabled('Numbers' + str(draw))
    output.debug_print(os.getcwd())

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


def generate_numbers_for_lotto():
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
    numbers_for_fifth_six = n56()
    output.debug_print(f'5th and 6th {n56()}')

    fifth_six_list = {}
    # for fs in numbers_for_fifth_six:
    # fifth_six_list[fs]

    # two_numbers = lotto_utils.select_random_number_from_two_highest_len_of_played_game(
    # lotto_utils.sort_with_key_as_number_game_played(n56()))
    # next_draw_number.append(two_numbers[0])
    # next_draw_number.append(two_numbers[1])

    excluded = []
    for line in data[0: 2]:
        for number in range(1, lotto_utils.get_last(6)):
            excluded.append(int(line[number]))
    while len(next_draw_number) < 6:
        next_draw_number = list(next_draw_number)
        next_draw_number.append(int(str(random.randint(1, 60))))
        next_draw_number = set(next_draw_number)

    # check against stats
    next_draw_number = list(next_draw_number)
    check_wins_in_the_past(next_draw_number)

    return next_draw_number


if __name__ == '__main__':
    start_time = timer()

    update_draws()
    generate_stats()
    print(generate_numbers_for_hotpics())
    print(generate_numbers_for_lotto())
    if detailed_mode:
        display_stats()
    end_time = timer()
    print('It took {} ms.'.format(int((end_time - start_time) * 1000)))
    output.debug_mode_warning()
    if open_lotto_website_in_webrowser:
        webbrowser.open('https://www.national-lottery.co.uk/games/lotto-hotpicks')