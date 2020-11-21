import random


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
