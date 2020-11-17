import logging

from src.tools.lotto import config
# SETTINGS
from src.tools.lotto.utils import draws_downloader, lotto_utils, output, get_result_for

url = 'https://www.national-lottery.co.uk/results/euromillions-hotpicks/draw-history/csv'
path = lotto_hotpics_history_path = config.get_project_path('euro-hotpics-draws.csv')
all_draws = config.get_project_path('euro-hotpicks-all-draws.csv')
logging.basicConfig(level=logging.DEBUG, format=' %(asctime)s - %(levelname)s - %(message)s',
                    filename=config.get_project_path('log.txt'))

data = draws_downloader.get_draws_for(url, path)
#  draws_downloader.update_all_draws(data, all_draws)

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

numbers = output.display_numbers(numbers)

remaining_numbers = {}
least_value = int(numbers[-1][1])
print(least_value)

while len(remaining_numbers) < 2:
    for key, value in numbers:
        if value == least_value:
            remaining_numbers.update({key: value})
    least_value += 1

get_result_for.get_result(data, remaining_numbers, 2, 5)

print(remaining_numbers)

# webbrowser.open('https://www.national-lottery.co.uk/games/euromillions-hotpicks')
