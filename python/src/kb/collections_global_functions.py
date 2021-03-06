words = ['tiny', 'a very long string', 'medium']


def is_long_string(string: str):
    return len(string) > 10


def to_first_three_characters(string: str):
    return string[0:3]


def run_example_filter():
    return list(filter(is_long_string, words))


def run_example_map():
    return list(map(to_first_three_characters, words))
