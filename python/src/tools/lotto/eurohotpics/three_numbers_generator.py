import random

from src.tools.lotto import config

from src.tools.lotto.utils import draws_downloader, lotto_utils, output

# SETTINGS
url = 'https://www.national-lottery.co.uk/results/euromillions-hotpicks/draw-history/csv'
path = lotto_hotpics_history_path = config.get_project_path('euro-hotpics-draws.csv')
all_draws = config.get_project_path('euro-hotpicks-all-draws.csv')

data = draws_downloader.get_draws_for(url, path)
draws_downloader.update_all_draws(data, all_draws)

numbers = {}

first_number = 0  # number that is in top 10 that didn't play at least 2 draws
second_number = 0  # that is second most popular that didn't play in last 10 draws
third_number = 0  # random number that didn't play in last draw but play between 2 and 9 draws

for i in range(1, 51):
    numbers[str(i)] = 0

for line in data[1: len(data)]:
    for i in range(1, lotto_utils.get_last(5)):
        numbers[line[i]] = numbers.get(line[i], 0) + 1

third_number_to_chose_from_list = []
for line in data[1:9]:
    for i in range(1, lotto_utils.get_last(5)):
        third_number_to_chose_from_list.append(line[i])

third_number = third_number_to_chose_from_list[random.randint(0, len(third_number_to_chose_from_list) - 1)]

numbers_to_delete = []
for line in data[0:10]:
    for i in range(1, lotto_utils.get_last(5)):
        numbers_to_delete.append(line[i])

numbers_to_delete = list(set(numbers_to_delete))
print('Numbers to delete {}'.format(numbers_to_delete))

for value in numbers_to_delete:
    numbers.pop(value)

numbers = output.display_numbers(numbers)

second_number = numbers[random.randint(0, len(numbers) - 1)]

remaining_numbers = {}
least_value = int(numbers[-1][1])
print(least_value)

while len(remaining_numbers) < 2:
    for key, value in numbers:
        if value == least_value:
            remaining_numbers.update({key: value})
    least_value += 1

print(f'Numbers to play are: {first_number}, {second_number} and {third_number}')
