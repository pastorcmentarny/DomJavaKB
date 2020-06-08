def convert_list_of_string_to_list_of_integer(string_list: list) -> list:
    int_list = []
    for item in string_list:
        try:
            int_list.append(int(item))
        except ValueError as exception:
            print('Item not added due non integer item in string list: {}'.format(exception))
    return int_list


def split_string_to_list_of_single_digit(word):
    digits = []
    for digit in word:
        try:
            digits.append(int(digit))
        except ValueError as exception:
            print('Item not added due non integer item in string: {}'.format(exception))
    return digits
