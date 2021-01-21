import csv
import random

WRITING_MODE = 'w'

EMPTY = ""
NEW_LINE = '\n'
SPACE = " "
SPLITTER = ','


def get_last(value):
    return value + 1


def validate(numbers):
    if len(numbers) > len(set(numbers)):
        raise ValueError("Numbers are not equal")
    else:
        print("Validation done. Given numbers are unique.")


def sort_with_key_as_number_game_played(number_in_count: dict) -> dict:
    result = {}
    for key in number_in_count:
        if number_in_count[key] in result:
            result[number_in_count[key]].append(key)
        else:
            result[number_in_count[key]] = [key]
    return result


def select_random_number_from_two_highest_len_of_played_game(game_list: dict) -> list:
    first = 0
    first_equals_no = 0
    second = 0
    result = []
    for key in game_list:
        if len(game_list[key]) > first:
            second = first
            first = len(game_list[key])
            first_equals_no = 1
        elif len(game_list[key]) == first:
            first_equals_no += 1
        elif len(game_list[key]) > second:
            second = len(game_list[key])

    if first_equals_no > 1:
        for key in game_list:
            if len(game_list[key]) == first:
                result.extend(game_list[key])
        for number in range(1, 1982):
            random.shuffle(result)
        return result[0:2]
    else:
        first_list = []
        second_list = []
        for key in game_list:
            if len(game_list[key]) == first:
                first_list.extend(game_list[key])
            if len(game_list[key]) == second:
                second_list.extend(game_list[key])

        for number in range(1, 1982):
            random.shuffle(first_list)
            random.shuffle(second_list)
        return [first_list[0], second_list[0]]


def count_hits(must_hit: int, numbers: list, draws):
    counter = 0
    for draw in draws:
        hit = 0
        for n in range(0, len(numbers)):
            if str(numbers[n]) in draw:
                hit += 1
        if hit >= must_hit:
            counter += 1

    return counter


def count_pairs(pairs: list):
    result = {}
    for item in pairs:
        if item in result:
            result[item] = result.get(item) + 1
        else:
            result[item] = 1
    return result


def assign_last_played_if_never_play_before(number: int, draw_date: str, last_played_list: dict):
    if last_played_list[number] == 'Never':
        last_played_list[number] = draw_date


def update_file_for(lotto_file, all_draws_list):
    for draw in all_draws_list:
        lotto_file.write(SPLITTER.join(draw).replace(SPACE, EMPTY))
        lotto_file.write(NEW_LINE)
    return lotto_file


# all no played numbers , last draw
def is_not_excluded(a_number: int, recent_draw_data: list):
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


def save_to_file(path_to_analysis_file: str, numbers_data: dict):
    analysis_data = open(path_to_analysis_file, WRITING_MODE)
    writer = csv.writer(analysis_data)
    for idx in numbers_data:
        writer.writerow(numbers_data.get(idx).to_row())
