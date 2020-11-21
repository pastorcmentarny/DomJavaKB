import logging
import webbrowser

from src.tools.lotto import config
from src.tools.lotto.utils import draws_downloader, lotto_utils, output

# SETTINGS
open_lotto_website_in_webrowser = False
url = 'https://www.national-lottery.co.uk/results/euromillions-hotpicks/draw-history/csv'
path = lotto_hotpics_history_path = config.get_project_path('euro-hotpics-draws.csv')
all_draws = config.get_project_path('euro-hotpicks-all-draws.csv')
logging.basicConfig(level=logging.DEBUG, format=' %(asctime)s - %(levelname)s - %(message)s',
                    filename=config.get_project_path('log.txt'))

data = draws_downloader.get_draws_for(url, path)


#  draws_downloader.update_all_draws(data, all_draws)


def generate_two_random_numbers():
    numbers = {}

    for i in range(1, 51):
        numbers[str(i)] = 0

    for line in data[1: len(data)]:
        for i in range(1, lotto_utils.get_last(5)):
            numbers[line[i]] = numbers.get(line[i], 0) + 1

    numbers_to_delete = []
    for line in data[0:10]:
        for i in range(1, lotto_utils.get_last(5)):
            numbers_to_delete.append(line[i])

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
