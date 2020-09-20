import logging
import random
import sys

from src.tools.lotto import config
from src.tools.lotto.utils import draws_downloader

sys.path.insert(0, '../utils')

# SETTINGS
url = 'https://www.national-lottery.co.uk/results/euromillions-hotpicks/draw-history/csv'
path = lotto_hotpics_history_path = config.path["base"] + 'euro-hotpics-draws.csv'
all_draws = config.path["base"] + 'euro-hotpicks-all-draws.csv'
logging.basicConfig(level=logging.DEBUG, format=' %(asctime)s - %(levelname)s - %(message)s',
                    filename=config.path["base"] + 'log.txt')

data = draws_downloader.get_draws_for(url, path)
draws_downloader.update_all_draws(data, all_draws)


numbers = []


 # all no played numbers , last draw
def is_not_excluded(i):
    if i in [6,12,17,34,42,9,10,19,42,49]:
        return False
    return True


def draw():
    for i in range(1, 51):
        if is_not_excluded(i):
            numbers.append(i)
    random.shuffle(numbers)

    count = 1
    for i in numbers:
        print(i)
        count += 1
        if count == 6:
            count = 1
            print()
            bonus = list(range(1, 13))
            random.shuffle(bonus)
            random.shuffle(bonus)
            print('1: {} , 2: {}'.format(bonus[3], bonus[7]))



if __name__ == '__main__':
    draw()
