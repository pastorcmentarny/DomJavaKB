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

# check results in the past

all_draws_path = 'D:/GitHub/DomJavaKB/data/lotto/lotto-hotpicks-all-draws.csv'
draw_history_file = open(all_draws_path)
hotpics_history_csv = csv.reader(draw_history_file)
data = list(hotpics_history_csv)


def generate_random_number():
    numbers = []
    excluded = [2, 5, 11, 14, 33, 1, 6, 8, 32, 2, 33, 35, 27, 17, 53, 9]
    for line in data[0: 2]:
        print(line)
        for i in range(1, lotto_utils.get_last(6)):
            excluded.append(int(line[i]))

    for i in range(1, 60):
        if i not in excluded:
            numbers.append(i)
    random.shuffle(numbers)
    random.shuffle(numbers)

    count = 1
    for i in numbers:
        print(i)
        count += 1
        if count == 7:
            count = 1
            print()

    print('excluded numbers: {}'.format(excluded))


if __name__ == '__main__':
    generate_random_number()
