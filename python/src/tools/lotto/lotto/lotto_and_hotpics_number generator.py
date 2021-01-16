import os
import random
import webbrowser
from timeit import default_timer as timer

import itertools

from src.tools.lotto import config
from src.tools.lotto.utils import lotto_utils, output
from src.tools.lotto.tools import draws_manager

# ======== settings ========
debug_mode = config.settings['debug_mode']
detailed_mode = config.settings['detailed_mode']
open_lotto_website_in_webrowser = config.settings['open_page']
skip_counting = True

# ======== -------- ========

result = config.get_project_path('result_double.txt')
percentage_format = "%.2f"

recent_draws_data = draws_manager.get_recent_draws_for_lotto_and_hotpicks()
all_draws_data = draws_manager.get_all_draws_for_lotto()
data = {}
all_draws_number_counter = {}
all_doubles_result = {}
n1 = 0
n2 = 0
n3 = 0
n4 = 0
n5 = 0
n6 = 0


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

    def contains_all_numbers(self, first_number, second_number):
        return self.contains_number(int(first_number)) and self.contains_number(int(second_number))

    def verify(self):
        return self.number1 != self.number2

    def add(self):
        self.count += 1

    def get_count(self):
        return self.count

    def sort_numbers(self):
        number_list = [self.number1, self.number2]
        number_list.sort(key=int)
        self.number1 = number_list[0]
        self.number2 = number_list[1]


def generate_stats():
    global all_draws_number_counter
    print('Generating stats')

    # display numbers count
    all_draws_number_counter = {}

    for line in all_draws_data[1: len(all_draws_data)]:
        for number in range(1, 7):
            line_number = line[number].strip()
            all_draws_number_counter[line_number] = all_draws_number_counter.get(line_number, 0) + 1
    if not skip_counting:
        count_doubles()
    print("Stats generated. (If you don't see them in console, then enable them in config.)")


def generate_numbers_for_hotpics():
    global n5, n6
    print('Generating hotpics numbers...')
    numbers = {}

    for i in range(1, 60):
        numbers[str(i)] = 0

    for line in recent_draws_data[1: len(recent_draws_data)]:
        for i in range(1, lotto_utils.get_last(6)):
            numbers[line[i]] = numbers.get(line[i], 0) + 1  # FIXME

    if detailed_mode:
        output.display_numbers(numbers)

    numbers_to_delete = []
    for line in recent_draws_data[0:10]:
        for i in range(1, lotto_utils.get_last(6)):
            numbers_to_delete.append(line[i])

    numbers_to_delete = list(set(numbers_to_delete))

    output.debug_print(f'Numbers to delete: {numbers_to_delete}')

    for value in numbers_to_delete:
        numbers.pop(value)

    numbers_to_select = numbers
    output.display_numbers(numbers)
    hotpicks_numbers = lotto_utils.select_random_number_from_two_highest_len_of_played_game(
        lotto_utils.sort_with_key_as_number_game_played(numbers_to_select))
    n5 = hotpicks_numbers[0]
    n6 = hotpicks_numbers[1]
    print('Numbers for lotto hotpics generated.')
    return hotpicks_numbers


def display_stats():
    numbers = [(key, all_draws_number_counter[key]
                ) for key in sorted(all_draws_number_counter, key=all_draws_number_counter.get, reverse=True)]
    for key, value in numbers:
        print(str(key) + ': ' + str(value))

    for double in all_doubles_result:
        print(double)


# TODO move to draw manager ?
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

    all_doubles_result = doubles_list.copy()
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
    doubles = set()
    all_doubles_combinations = itertools.combinations(range(1, 60), 2)
    for triple_combination in all_doubles_combinations:
        sorted_list = [triple_combination[0], triple_combination[1]]
        sorted_list.sort(key=int)
        doubles.add(Doubles(sorted_list[0], sorted_list[1]))
    return doubles


def get_numbers_played_count_in_recent_draws() -> dict:
    output.draw_title('total numbers played count in RECENT draws')
    numbers = {}
    for number in range(1, 60):
        numbers[str(number)] = 0

    for line in recent_draws_data[1: len(recent_draws_data)]:
        for number in range(1, 7):
            line_number = line[number].strip()
            numbers[line_number] = numbers.get(line_number, 0) + 1
    return numbers


def get_numbers_played_count_for_all_draws() -> dict:
    output.draw_title('total numbers played count in ALL draws')

    numbers = {}
    for number in range(1, 60):
        numbers[str(number)] = 0

    for line in all_draws_data[1: len(all_draws_data)]:
        for number in range(1, 7):
            line_number = line[number].strip()
            numbers[line_number] = numbers.get(line_number, 0) + 1
    return numbers


def n34() -> list:
    numbers = get_numbers_played_count_for_all_draws()
    return [(key, numbers[key]) for key in sorted(numbers, key=numbers.get, reverse=True)]


def check_wins_in_the_past(draw: list):
    print("Checking if numbers you selected won in the past results for LOTTO and HOTPICS..")
    output.print_if_detailed_mode_enabled('Numbers' + str(draw))
    output.debug_print(os.getcwd())

    for n in range(len(draw), 0, -1):
        print(str(n) + "'s : " + str(lotto_utils.count_hits(n, draw, all_draws_data)))


def generate_numbers_for_lotto():
    global n1, n2, n3, n4
    output.draw_title('Generate numbers for next draw', 2)
    next_draw_number = []
    first_second_number_list = []

    # select 2 numbers that played between 3 and 9th draw
    for line in recent_draws_data[3: 9]:
        for number in range(1, lotto_utils.get_last(6)):
            first_second_number_list.append(int(line[number]))
    for number in range(1, 1770):
        random.shuffle(first_second_number_list)
    n1 = first_second_number_list[1]
    n2 = first_second_number_list[2]
    next_draw_number.append(n1)
    next_draw_number.append(n2)

    # select 2 from top 10 numbers that didn't play longest
    n3 = int(n34()[3][0])
    n4 = int(n34()[4][0])
    next_draw_number.append(n3)
    next_draw_number.append(n4)

    # use 2 numbers from hotpics
    next_draw_number.append(int(n5))
    next_draw_number.append(int(n6))

    # draw random number if any of above number was duplicated
    next_draw_number = set(next_draw_number)  # remove duplicated number selected to play
    excluded = []
    for line in recent_draws_data[0: 2]:
        for number in range(1, lotto_utils.get_last(6)):
            excluded.append(int(line[number]))
    while len(next_draw_number) < 6:
        next_draw_number = list(next_draw_number)
        next_draw_number.append(int(str(random.randint(1, 60))))
        next_draw_number = set(next_draw_number)

    # check against stats
    next_draw_number = list(next_draw_number)
    next_draw_number = sorted(next_draw_number)
    check_wins_in_the_past(next_draw_number)

    return next_draw_number


"""
def get_numbers_played_count_for_all_draws() -> dict:
    output.draw_title('total numbers played count in ALL draws')
    return get_numbers_played_count_for(data)

def get_numbers_played_count_in_recent_draws() -> dict:
    return get_numbers_played_count_for(recent_data,'total numbers played count in RECENT draws')


def get_numbers_played_count_for(number_list:list,title:str) -> dict:
    output.draw_title(title)    
    numbers = {}
    for number in range(1, 60):
        numbers[str(number)] = 0

    for line in number_list[1: len(number_list)]:
        for number in range(1, 7):
            line_number = line[number].strip()
            numbers[line_number] = numbers.get(line_number, 0) + 1
    return numbers


def stats():
    output.display_numbers(get_numbers_played_count_for_all_draws())
    output.display_numbers(get_numbers_played_count_in_recent_draws())
"""

if __name__ == '__main__':
    start_time = timer()
    generate_stats()
    generate_numbers_for_hotpics()
    print(f'Hotpics numbers: {n5} and {n6}')
    print(f'Lotto numbers: {generate_numbers_for_lotto()}')
    if detailed_mode:
        display_stats()
    end_time = timer()
    print('It took {} ms.'.format(int((end_time - start_time) * 1000)))
    output.debug_mode_warning()
    if open_lotto_website_in_webrowser:
        webbrowser.open('https://www.national-lottery.co.uk/games/lotto-hotpicks')
