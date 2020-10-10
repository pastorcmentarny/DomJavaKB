import csv
import random

from src.tools.lotto.utils import lotto_utils

# load all draws
# exclude last 2 draws
# exclude first most numbers and 2 least
# lotto_hotpicks_url = 'https://www.national-lottery.co.uk/results/lotto-hotpicks/draw-history/csv'
# path = config.path["base"] + 'lotto-hotpicks-draws.csv'
# all_draws = config.path["base"] + 'lotto-hotpicks-all-draws.csv'
# logging.debug('downloading  data from ' + lotto_hotpicks_url)
# response = requests.get(lotto_hotpicks_url)
# logging.debug('download complete with response ' + str(response.status_code))
# data = draws_downloader.get_draws_for(lotto_hotpicks_url, path)
# draws_downloader.update_all_draws_v2(data, all_draws)
# bonus ball
# check results in the past

# 2 random number
# 2 numbers that played 3-9
# 2 numbers that played 10+

# TODO make it system independent
# all_draws_path = 'D:/Projects/DomJavaKB/data/lotto/lotto-hotpicks-all-draws.csv'
# all_draws_path = 'D:/GitHub/DomJavaKB/data/lotto/lotto-hotpicks-all-draws.csv'
all_draws_path = 'B:/GitHub/DomJavaKB/data/lotto/lotto-hotpicks-all-draws.csv'
draw_history_file = open(all_draws_path)
hotpics_history_csv = csv.reader(draw_history_file)
data = list(hotpics_history_csv)


def stats():
    all_numbers = []
    for number in range(1, 60):
        all_numbers.append(number)

    numbers = {}
    for number in range(1, 60):
        numbers[number] = 0

    for line in data[1: len(data)]:
        for number in range(1, 7):
            line_number = line[number].strip()
            numbers[line_number] = numbers.get(line_number, 0) + 1


def generate_random_number():
    numbers = []
    excluded = []
    for line in data[0: 2]:
        for i in range(1, lotto_utils.get_last(6)):
            excluded.append(int(line[i]))

    for i in range(1, 60):
        if i not in excluded:
            numbers.append(i)

    print(f'before {numbers}')

    for i in range(1, 1770):
        random.shuffle(numbers)
    print(f'after {numbers}')

    count = 1
    for i in numbers:
        print(i)
        count += 1
        if count == 7:
            count = 1
            print()

    print(f'excluded numbers: {excluded}')


if __name__ == '__main__':
    stats()
    generate_random_number()
