import logging
import webbrowser

from src.tools.lotto import config
from src.tools.lotto.utils import lotto_utils, output, draws_manager

# ====== SETTINGS ========
open_lotto_website_in_webrowser = config.settings['open_page']
# ====== -------- ========


recent_draws_data = draws_manager.get_recent_draws_for_euromillions_hotpicks()


def generate_two_random_numbers():
    numbers = {}

    for number in range(1, 51):
        numbers[str(number)] = 0

    for line in recent_draws_data[1: len(recent_draws_data)]:
        for number in range(1, lotto_utils.get_last(5)):
            numbers[line[number]] = numbers.get(line[number], 0) + 1

    numbers_to_delete = []
    for line in recent_draws_data[0:10]:
        for number in range(1, lotto_utils.get_last(5)):
            numbers_to_delete.append(line[number])

    numbers_to_delete = list(set(numbers_to_delete))
    logging.debug(numbers_to_delete)

    for value in numbers_to_delete:
        numbers.pop(value)

    numbers_to_select = numbers
    output.display_numbers(numbers)

    return lotto_utils.select_random_number_from_two_highest_len_of_played_game(
        lotto_utils.sort_with_key_as_number_game_played(numbers_to_select))


if __name__ == '__main__':
    print(f'result: {generate_two_random_numbers()}')
    if open_lotto_website_in_webrowser:
        webbrowser.open('https://www.national-lottery.co.uk/games/euromillions-hotpicks')
