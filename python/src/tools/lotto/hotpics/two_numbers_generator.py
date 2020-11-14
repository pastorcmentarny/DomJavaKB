"""
* Author Dominik Symonowicz
* WWW:	https://dominiksymonowicz.com/welcome
* IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
* Github:	https://github.com/pastorcmentarny
* Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
* LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
"""

import requests
import webbrowser
from src.tools.lotto import config
from src.tools.lotto.utils import draws_downloader
from src.tools.lotto.utils import get_result_for
from src.tools.lotto.utils import output
from src.tools.lotto.utils import lotto_utils

lotto_hotpicks_url = 'https://www.national-lottery.co.uk/results/lotto-hotpicks/draw-history/csv'
path = config.get_project_path('lotto-hotpicks-draws.csv')
all_draws = config.get_project_path('lotto-hotpicks-all-draws.csv')
print('Downloading  data from ' + lotto_hotpicks_url)
response = requests.get(lotto_hotpicks_url)
print('Download complete with response ' + str(response.status_code))

data = draws_downloader.get_draws_for(lotto_hotpicks_url, path)
draws_downloader.update_all_draws_v2(data, all_draws)

numbers = {}

for i in range(1, 60):
    numbers[str(i)] = 0

for line in data[1: len(data)]:
    for i in range(1, lotto_utils.get_last(6)):
        numbers[line[i]] = numbers.get(line[i], 0) + 1

x = output.display_numbers(numbers)

numbers_to_delete = []
for line in data[0:10]:
    for i in range(1, lotto_utils.get_last(6)):
        numbers_to_delete.append(line[i])

numbers_to_delete = list(set(numbers_to_delete))
print(numbers_to_delete)

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

get_result_for.get_result(data, remaining_numbers, 2, 6)

webbrowser.open('https://www.national-lottery.co.uk/games/lotto-hotpicks')
