"""
* Author Dominik Symonowicz
* WWW:	https://dominiksymonowicz.com/welcome
* IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
* GitHub:	https://github.com/pastorcmentarny
* Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
* LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
"""
from src.tools.lotto import config

# TODO move to ui_utils
EMPTY_LINE = ''
NEW_LINE = '\n'
HR_SYMBOL = '-'


def draw_title(title: str, pre_new_lines: int = 0):
    pre_new_lines = NEW_LINE * pre_new_lines
    left_align = ' ' * 4
    line = HR_SYMBOL * 6
    print(f'{pre_new_lines}{left_align}{line}{title}{line}')


def display_numbers(numbers, title: str = EMPTY_LINE):
    # list of numbers that haven't been played in last 10 draws with how often they play in last 52 games
    if title != EMPTY_LINE:
        print(title)
    numbers = [(key, numbers[key]) for key in sorted(numbers, key=numbers.get, reverse=True)]
    for key, value in numbers:
        print(str(key) + ': ' + str(value))
    print(HR_SYMBOL * 20)
    return numbers


def debug_mode_warning():
    hr = HR_SYMBOL * 6
    br = NEW_LINE * 2
    if config.settings['debug_mode']:
        print(hr +
              '\nWARNING!\n'
              + hr + br +
              'You are running this with debug mode so it will produce lots of extra logs!\n'
              'Disable for normal usage\n'
              + hr + br)


def debug_print(content):
    if config.settings['debug_mode']:
        print(content)


def print_if_detailed_mode_enabled(content):
    if config.settings['detailed_mode']:
        print(content)
