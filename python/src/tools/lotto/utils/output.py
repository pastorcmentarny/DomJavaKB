"""
* Author Dominik Symonowicz
* WWW:	https://dominiksymonowicz.com/welcome
* IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
* Github:	https://github.com/pastorcmentarny
* Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
* LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
"""
from src.tools.lotto import config

# TODO move to ui_utils
def draw_title(title: str, pre_new_lines: int = 0):
    pre_new_lines = '\n' * pre_new_lines
    left_align = ' ' * 4
    line = '-' * 6
    print(f'{pre_new_lines}{left_align}{line}{title}{line}')


def display_numbers(numbers):
    # list of numbers that haven't been played in last 10 draws with how often they play in last 52 games
    numbers = [(key, numbers[key]) for key in sorted(numbers, key=numbers.get, reverse=True)]
    for key, value in numbers:
        print(str(key) + ': ' + str(value))
    print('--------------------')
    return numbers


def debug_mode_warning():
    hr = '-' * 6
    br = '\n' * 2
    if config.settings['debug_mode']:
        print(hr +
              '\nWARNING!\n'
              + hr + br +
              'You are running this with debug mode so it will produce lots of extra logs!\n'
              'Disable for normal usage\n'
              + hr + br)
