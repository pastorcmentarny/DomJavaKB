"""
* Author Dominik Symonowicz
* WWW:	https://dominiksymonowicz.com/welcome
* IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
* Github:	https://github.com/pastorcmentarny
* Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
* LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
"""
import webbrowser

from src.tools.lotto import config
from src.tools.lotto.utils import draws_manager
from src.tools.lotto.utils import lotto_utils
from src.tools.lotto.utils import output

data = draws_manager.get_recent_draws_for_lotto_and_hotpicks()


def generate_two_random_numbers():
    numbers = {}

    for number in range(1, 60):
        numbers[str(number)] = 0

    for line in data[1: len(data)]:
        for number in range(1, lotto_utils.get_last(6)):
            numbers[line[number]] = numbers.get(line[number], 0) + 1

    output.display_numbers(numbers)

    numbers_to_delete = []
    for line in data[0:10]:
        for number in range(1, lotto_utils.get_last(6)):
            numbers_to_delete.append(line[number])

    numbers_to_delete = list(set(numbers_to_delete))

    output.debug_print(f'Numbers to delete: {numbers_to_delete}')

    for value in numbers_to_delete:
        numbers.pop(value)

    output.display_numbers(numbers)

    return sorted(lotto_utils.select_random_number_from_two_highest_len_of_played_game(
        lotto_utils.sort_with_key_as_number_game_played(numbers)))


if __name__ == '__main__':
    print(f'result: {generate_two_random_numbers()}')
    output.debug_mode_warning()
    if config.settings['open_page']:
        webbrowser.open('https://www.national-lottery.co.uk/games/lotto-hotpicks')
