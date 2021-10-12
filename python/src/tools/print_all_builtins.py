# it is useless script but it helps me track changes in python
builtins_list = [name for name in dir(__builtins__) if name > 'a']


def get_builtins_count():
    return str(len(builtins_list))


def get_builtins_count_list():
    return builtins_list


if __name__ == '__main__':
    print(get_builtins_count_list())
    print(get_builtins_count())
