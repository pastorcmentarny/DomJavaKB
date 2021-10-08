"""
* Author Dominik Symonowicz
* WWW:	https://dominiksymonowicz.com/welcome
* IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
* GitHub:	https://github.com/pastorcmentarny
* Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
* LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
"""

import random
from timeit import default_timer as timer

from src.tools.lotto.tools import draws_manager
from src.tools.lotto.utils import output, lotto_utils
from src.utils import ui_utils

NEW_LINE = '\n'
SPLITTER = ','
EMPTY = ""
SPACE = " "
WRITABLE = 'w'
GOOD_SCORE = 555

total_thunderballs = 40  # 39

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

all_draws_data = draws_manager.load_all_draws_for(draws_manager.THUNDERBALL, draws_manager.thunderball_all_draws_path)


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
        if hits == 5:
            return 9
        if hits == 4:
            return 7
        if hits == 3:
            return 5
        if hits == 2:
            return 3
        if hits == 1:
            return 2
        else:
            return 1
    else:
        if hits == 5:
            return 8
        if hits == 4:
            return 6
        if hits == 3:
            return 4
    return 0


def count_wins_in_the_past(chosen_numbers: list):
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

    for draw in all_draws_data:
        hit = 0
        for n in chosen_numbers:
            if str(n) in draw:
                hit += 1

        wins[get_draw_result(hit, True)] += 1
        wins[get_draw_result(hit, False)] += 1
    return wins


def display_past_wins_result_for(draw_result, numbers):
    ui_utils.title(f'display result for {sorted(draw_result)}')
    wins_result = count_wins_in_the_past(draw_result)
    score_v1 = calculate_score_for_draw(draw_result, numbers, wins_result)
    score_v2 = calculate_score_for_draw_v2(wins_result)
    score_result = f'Score : {score_v2} (old score: {score_v1})'

    if score_v2 > GOOD_SCORE:
        print(f'GOOD NUMBERS ALERT: (More than {GOOD_SCORE}) : {score_result}')
    else:
        print(score_result)
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

    return f_score


def calculate_score_for_draw_v2(wins_result):
    f_score = 0
    if wins_result[9]:
        f_score = -1
        print(f'WOW! THE GOOD NEWS IS YOU GENERATED NUMBERS THAT WON JACKPOT\n'
              + 'BAD NEWS IS YOU SHOULD NOT PLAY THIS NUMBERS\n\n\n'
              + 'numbers: {draw}')
    else:
        # calculate score from games that number was hit
        f_score += wins_result[7] * 10
        f_score += wins_result[5] * 1
        f_score *= 5
        f_score += wins_result[3] / 10
        f_score += wins_result[1] / 25
        f_score = int(f_score)

    return f_score


def generate_numbers_for_thunderball():
    excluded = []

    data = all_draws_data

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

    for value in numbers_to_delete:
        numbers.pop(value)

    # exclude most popular number and two least popular
    numbers_as_list = convert_to_list(numbers)
    excluded.append(int(numbers_as_list[0][0]))
    excluded.append(int(numbers_as_list[len(numbers_as_list) - 2][0]))
    excluded.append(int(numbers_as_list[len(numbers_as_list) - 1][0]))

    output.display_numbers(numbers)

    ui_utils.title("\n\n thunderballs that didn't play in last 10 games:")

    thunderball_to_delete = []
    for line in data[0:10]:
        thunderball_to_delete.append(line[thunderball_column])

    thunderball_to_delete = list(set(thunderball_to_delete))

    for value in thunderball_to_delete:
        thunderballs.pop(value)

    output.display_numbers(thunderballs)

    for line in data[0: 2]:
        for i in range(1, lotto_utils.get_last(5)):
            excluded.append(int(line[i]))

    output.debug_print('excluded number count: {} with numbers {}'.format(len(excluded), excluded))
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
    output.debug_print(f'shuffled {shuffles_times} times')

    count = 1
    draw_result = []
    for i in numbers_to_draw:
        draw_result.append(i)
        count += 1
        if count == 6:
            count = 1
            display_past_wins_result_for(draw_result, sorted_numbers)
            draw_result.clear()


def stats():
    numbers = {}
    for line in all_draws_data[1: len(all_draws_data)]:
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


def update_file_for(all_draw_file, all_draw_list):
    for draw in all_draw_list:
        all_draw_file.write(SPLITTER.join(draw).replace(SPACE, EMPTY))
        all_draw_file.write(NEW_LINE)
    return all_draw_file


if __name__ == '__main__':
    start_time = timer()
    stats()
    generate_numbers_for_thunderball()
    end_time = timer()
    print('It took {} ms.'.format(int((end_time - start_time) * 1000)))
