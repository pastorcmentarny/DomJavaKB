import collections

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
    ordered = collections.OrderedDict(sorted(game_list.keys(), reverse=True))
    for key in ordered:
        print(len(ordered[key]))
    result = []
    return result
