"""
* Author Dominik Symonowicz
* WWW:	https://dominiksymonowicz.com/welcome
* IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
* Github:	https://github.com/pastorcmentarny
* Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
* LinkedIn: https://www.linkedin.com/in/dominik-symonowicz

draw system 2.0  exlude last draw , least 2 numbers and first number generate randomly with one number from most count

DESIGN FOR v2
N1,N2,N3,N4,N5 T1
N6,N7,N8,N9,N0 T2

N1-N4 and N6-N9 generate randomly exlcuding last draw, minus last 2 least played number for while and most
N5,N0 generate from below
5: 16 EXLUCDED
3: 12
38: 12
11: 11
33: 9
1: 8
13: 8
31: 7
22: 6
37: 6 EXCLUDED

T1 from second  numbers that didn't play in last 10 games: 3 or 12
T2 from most count of number  12x or 8x
5: 16 EXCLUDED
3: 12
38: 12
11: 11
33: 9
1: 8
13: 8
31: 7
22: 6 EXCLUDED
37: 6 EXCLUDED
"""

import logging
import random
import csv
from timeit import default_timer as timer


from src.tools.lotto import config
from src.tools.lotto.utils import draws_downloader, output, lotto_utils
from src.utils import ui_utils

total_thunderballs = 40  # 39

# SETTINGS
url = 'https://www.national-lottery.co.uk/results/thunderball/draw-history/csv'
path = thunderball_history_path = config.path["base"] + 'thunderball-draws.csv'
all_draws = config.path["base"] + 'thunderball-all-draws.csv'

logging.basicConfig(level=logging.DEBUG, format=' %(asctime)s - %(levelname)s - %(message)s',
                    filename=config.path["base"] + 'log.txt')

matches = {
    9: 'Match 5 + Thunderball(£500.000)',
    8: 'Match 5(£5.000)',
    7: 'Match 4 + Thunderball(£250)',
    6: 'Match 4(£100)',
    5: 'Match 3 + Thunderball(£20)',
    4: 'Match 3)(£10)',
    3: 'Match 2 + Thunderball(£10)',
    2: 'Match 1 + Thunderball(£5)',
    1: 'Match 0 + Thunderball(£3)',
    0: 'No Match'
}


def convert_to_list(numbers) -> list:
    result = []
    numbers = [(key, numbers[key]) for key in sorted(numbers, key=numbers.get, reverse=True)]
    for key_value, _ in numbers:
        result.append(key_value)
    return numbers


def get_result_description(level: int) -> str:
    return str(matches[level])


def get_draw_result(hits: int, tb: bool = True):
    if tb:
        if hits is 5:
            return 9
        if hits is 4:
            return 7
        if hits is 3:
            return 5
        if hits is 2:
            return 3
        if hits is 1:
            return 2
        else:
            return 1
    else:
        if hits is 5:
            return 8
        if hits is 4:
            return 6
        if hits is 3:
            return 4
    return 0


def count_wins_in_the_past(chosen_numbers: list):
    all_draw_results = get_data()
    wins = {
        9: 0,
        8: 0,
        7: 0,
        6: 0,
        5: 0,
        4: 0,
        3: 0,
        2: 0,
        1: 0,
        0: 0
    }

    for draw in all_draw_results:
        hit = 0
        for n in chosen_numbers:
            if str(n) in draw:
                hit += 1

        wins[get_draw_result(hit, True)] += 1
        wins[get_draw_result(hit, False)] += 1
    return wins


def display_past_wins_result_for(draw_result,numbers):
    ui_utils.title(f'display result for {draw_result}')
    wins_result = count_wins_in_the_past(draw_result)
    score = 0
    for s in draw_result:
        for t in numbers:
            if s is t[0]:
                score += int(t[1])
    print(f'score: {score}')
    for result_level, number in wins_result.items():
        print('{} x{}'.format(get_result_description(result_level), number))

#score from numbers played
# score from numbers hit x3

def generate_numbers_for_thunderball():
    excluded = []
    #recent_draws = draws_downloader.get_draws_for(url, path)
    data = get_data()

    ui_utils.title('number counter')
    numbers = {}
    for i in range(1, lotto_utils.get_last(39)):
        numbers[str(i)] = 0

    for line in data[1: len(data)]:
        for i in range(1, lotto_utils.get_last(5)):
            numbers[line[i]] = numbers.get(line[i], 0) + 1

    x = output.display_numbers(numbers)

    thunderballs = {}
    for i in range(1, lotto_utils.get_last(14)):
        thunderballs[str(i)] = 0

    thunderball_column = 6
    for line in data[1: len(data)]:
        thunderballs[line[thunderball_column]] = thunderballs.get(line[thunderball_column], 0) + 1

    ui_utils.title("thunderballs:")
    output.display_numbers(thunderballs)

    ui_utils.title("numbers that didn't play in last 10 games")

    numbers_to_delete = []
    for line in data[0:10]:
        for i in range(1, lotto_utils.get_last(5)):
            numbers_to_delete.append(line[i])

    numbers_to_delete = list(set(numbers_to_delete))
    print(numbers_to_delete)

    for value in numbers_to_delete:
        numbers.pop(value)

    # exclude most popular number and two least popular
    numbers_as_list = convert_to_list(numbers)
    excluded.append(int(numbers_as_list[0][0]))
    excluded.append(int(numbers_as_list[len(numbers_as_list) - 2][0]))
    excluded.append(int(numbers_as_list[len(numbers_as_list) - 1][0]))

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

    draw_numbers = []

    for line in data[0: 2]:
        for i in range(1, lotto_utils.get_last(5)):
            excluded.append(int(line[i]))

    print('excluded number count: {} with numbers {}'.format(len(excluded), excluded))
    excluded = list(set(excluded))

    numbers_to_draw = []
    counter = 0

    for i in range(1, total_thunderballs):
        if i not in excluded:
            numbers_to_draw.append(i)
        else:
            counter += 1

    print('excluded unique number counter : {}'.format(counter))

    shuffles_times = random.randint(780,780 + (total_thunderballs * total_thunderballs))

    for i in range(1, shuffles_times):
        random.shuffle(numbers_to_draw)
    print(f'shuffled {shuffles_times} times')

    count = 1
    draw_result = []
    for i in numbers_to_draw:
        draw_result.append(i)
        count += 1
        if count is 6:
            count = 1
            display_past_wins_result_for(draw_result,x)
            draw_result.clear()


def stats():
    # load data
    data = get_data()
    numbers = {}
    for line in data[1: len(data)]:
        first_number = line[1].strip()
        second_number = line[2].strip()
        third_number = line[3].strip()
        forth_number = line[4].strip()
        fifth_number = line[5].strip()
        numbers[first_number] = numbers.get(first_number, 0) + 1
        numbers[second_number] = numbers.get(second_number, 0) + 1
        numbers[third_number] = numbers.get(third_number, 0) + 1
        numbers[forth_number] = numbers.get(forth_number, 0) + 1
        numbers[fifth_number] = numbers.get(fifth_number, 0) + 1

    numbers = [(key, numbers[key]) for key in sorted(numbers, key=numbers.get, reverse=True)]
    for key, value in numbers:
        print(str(key) + ': ' + str(value))


def get_data() -> list:
    #all_draws_file = open('B:\GitHub\DomJavaKB\data\lotto\euro-hotpicks-all-draws.csv')
    all_draws_file = open('D:\\Projects\\DomJavaKB\\data\\lotto\\thunderball-all-draws.csv')
    thunderball_history_csv = csv.reader(all_draws_file)
    return list(thunderball_history_csv)


if __name__ == '__main__':
    start_time = timer()
    stats()
    generate_numbers_for_thunderball()
    end_time = timer()
    print('It took {} ms.'.format(int((end_time - start_time) * 1000)))
