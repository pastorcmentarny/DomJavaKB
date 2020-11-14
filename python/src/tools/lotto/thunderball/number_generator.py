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

NEW_LINE = '\n'
SPLITTER = ','
EMPTY = ""
SPACE = " "
WRITABLE = 'w'
GOOD_SCORE = 4000

total_thunderballs = 40  # 39

# SETTINGS
url = 'https://www.national-lottery.co.uk/results/thunderball/draw-history/csv'
path = thunderball_history_path = config.path["base"] + 'thunderball-draws.csv'
all_draws = config.path["base"] + 'thunderball-all-draws.csv'
all_draws_path = 'B:\\GitHub\\DomJavaKB\\data\\lotto\\thunderball-all-draws.csv'

log_path = 'B:\GitHub\DomJavaKB\data\lotto\log.txt'
logging.basicConfig(level=logging.DEBUG, format=' %(asctime)s - %(levelname)s - %(message)s',
                    filename=log_path)

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


def display_past_wins_result_for(draw_result, numbers):
    ui_utils.title(f'display result for {draw_result}')
    wins_result = count_wins_in_the_past(draw_result)
    calculate_score_for_draw(draw_result, numbers, wins_result)

    for result_level, number in wins_result.items():
        print('{} x{}'.format(get_result_description(result_level), number))


def calculate_score_for_draw(draw_result, numbers, wins_result):
    f_score = 0
    if wins_result[9]:
        f_score = -1
        print(f'WOW! THE GOOD NEWS IS YOU GENERATED NUMBERS THAT WON JACKPOT\n'
              + 'BAD NEWS IS YOU SHOULD NOT PLAY THIS NUMBERS\n\n\n'
              + 'numbers: {draw}')
    else:
        # calculate score from games that number was hit
        f_score += wins_result[9]
        f_score += wins_result[7]
        f_score += wins_result[5]
        f_score += wins_result[3]
        f_score *= 3  # if number match 2-5 numbers multiply x 3 for 1 match don't multiply just add
        f_score += wins_result[1]

        # calculate score from numbers were drawn
        for s in draw_result:
            for t in numbers:
                if int(s) is int(t[0]):
                    f_score += int(t[1])

    if f_score > GOOD_SCORE:
        ui_utils.title(f'NUMBERS TO PLAY  (More than {GOOD_SCORE})')
    print(f'score: {f_score}')


def generate_numbers_for_thunderball():
    excluded = []

    data = get_data()

    ui_utils.title('number counter')
    numbers = {}
    for i in range(1, lotto_utils.get_last(39)):
        numbers[str(i)] = 0

    for line in data[1: len(data)]:
        for i in range(1, lotto_utils.get_last(5)):
            numbers[line[i]] = numbers.get(line[i], 0) + 1

    sorted_numbers = output.display_numbers(numbers)

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

    numbers = output.display_numbers(numbers)  # TODO delete it?

    print("\n\n thunderballs that didn't play in last 10 games:")

    thunderball_to_delete = []
    for line in data[0:10]:
        thunderball_to_delete.append(line[thunderball_column])

    thunderball_to_delete = list(set(thunderball_to_delete))
    logging.debug(thunderball_to_delete)

    for value in thunderball_to_delete:
        thunderballs.pop(value)

    thunderballs = output.display_numbers(thunderballs)  # TODO delete it?

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

    shuffles_times = random.randint(780, 780 + (total_thunderballs * total_thunderballs))

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
            display_past_wins_result_for(draw_result, sorted_numbers)
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
    all_draws_file = open('B:\\GitHub\\DomJavaKB\\data\\lotto\\thunderball-all-draws.csv')  # move this config
    thunderball_history_csv = csv.reader(all_draws_file)
    return list(thunderball_history_csv)


def update_draws():
    ui_utils.title('UPDATING DRAWS')
    recent_draws_list = draws_downloader.get_draws_for(url, path)
    last_column = len(recent_draws_list[0]) - 1
    print(last_column)
    all_draws_list = get_data()
    print(all_draws_list)

    last_draw = int(all_draws_list[0][last_column])
    draw_to_add = []
    current_draw = int(recent_draws_list[0][last_column])
    counter = 0
    while last_draw != current_draw:
        # TODO clean draw from space
        draw_to_add.append(recent_draws_list[counter])
        counter += 1
        current_draw = int(recent_draws_list[counter][last_column])

    print(f'draws to add {draw_to_add}')
    all_draws_file = open(all_draws_path, WRITABLE)
    all_draws_file = update_file_for(all_draws_file, draw_to_add)
    all_draws_file = update_file_for(all_draws_file, all_draws_list)
    all_draws_file.close()
    ui_utils.title('DRAWS UPDATED')


def update_file_for(all_draw_file, all_draw_list):
    for draw in all_draw_list:
        all_draw_file.write(SPLITTER.join(draw).replace(SPACE, EMPTY))
        all_draw_file.write(NEW_LINE)
    return all_draw_file


if __name__ == '__main__':
    start_time = timer()
    update_draws()
    stats()
    generate_numbers_for_thunderball()
    end_time = timer()
    print('It took {} ms.'.format(int((end_time - start_time) * 1000)))
