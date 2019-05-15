import logging
import sys

sys.path.insert(0, '../utils')

import draws_downloader
import output
import lotto_utils
from src.tools.lotto import config

number_1 = 5
number_2 = 11
number_3 = 19
number_4 = 23
number_5 = 37
thunderball = 4

# SETTINGS
url = 'https://www.national-lottery.co.uk/results/thunderball/draw-history/csv'
path = thunderball_history_path = config.path["base"] + 'thunderball-draws.csv'
all_draws = config.path["base"] + 'thunderball-all-draws.csv'

logging.basicConfig(level=logging.DEBUG, format=' %(asctime)s - %(levelname)s - %(message)s',
                    filename=config.path["base"] + 'log.txt')

data = draws_downloader.get_draws_for(url, path)
print('number counter')
numbers = {}
for i in range(1, lotto_utils.get_last(39)):
    numbers[str(i)] = 0

for line in data[1: len(data)]:
    for i in range(1, lotto_utils.get_last(5)):
        numbers[line[i]] = numbers.get(line[i], 0) + 1

output.display_numbers(numbers)

thunderballs = {}
for i in range(1, lotto_utils.get_last(14)):
    thunderballs[str(i)] = 0

thunderball_column = 6
for line in data[1: len(data)]:
    thunderballs[line[thunderball_column]] = thunderballs.get(line[thunderball_column], 0) + 1

print('\n\nthunderballs:')
output.display_numbers(thunderballs)

print("\n\n numbers that didn't play in last 10 games:")

numbers_to_delete = []
for line in data[0:10]:
    for i in range(1, lotto_utils.get_last(5)):
        numbers_to_delete.append(line[i])

numbers_to_delete = list(set(numbers_to_delete))
logging.debug(numbers_to_delete)

for value in numbers_to_delete:
    numbers.pop(value)

numbers = output.display_numbers(numbers)

print("\n\n thunderballs that didn't play in last 10 games:")

thunderball_to_delete = []
for line in data[0:10]:
    thunderball_to_delete.append(line[thunderball_column])

thunderball_to_delete = list(set(thunderball_to_delete))
logging.debug(thunderball_to_delete)

for value in thunderball_to_delete:
    thunderballs.pop(value)

thunderballs = output.display_numbers(thunderballs)
