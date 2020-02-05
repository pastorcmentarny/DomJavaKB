def convert_list_of_string_to_list_of_integer(string_list: list) -> list:
    int_list = []
    for item in string_list:
        try:
            int_list.append(int(item))
        except ValueError as exception:
            print('Item not added due non integer item in string list: {}'.format(exception))
    return int_list


if __name__ == '__main__':
    example = ['1', '2', '3', '3', '1', 'lol']
    result = convert_list_of_string_to_list_of_integer(example)
    print(type(result[0]))
    print(result)
