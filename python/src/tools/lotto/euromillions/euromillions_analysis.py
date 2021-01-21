"""
1. Load recent draws data
1. Load all draws data
2. Process data
3. Display data
4. Save data

# name, recent_count, all_count, last_played,
"""
import csv
import os

from src.tools.lotto import config
from src.tools.lotto.tools import draws_manager
from src.tools.lotto.utils import output, lotto_utils

recent_draws_data = draws_manager.get_recent_draws_for_euromillions()
all_draw_data = draws_manager.get_all_draws_for_euromillions()
games = int(all_draw_data[0][0])
path_to_analysis_file = r'b:\test\euro_analysis.csv'


class EuroNumber:
    def __init__(self, number: int, recent_games_counter: int, all_games_counter: int, last_played_date: str,
                 last_played_counter, play_between_games: dict, recent_average_play: float,
                 all_draws_average_play: float, candles: dict):
        self._ball = number
        self._recent_games_counter = recent_games_counter
        self._all_games_counter = all_games_counter
        self._last_played_date = last_played_date
        self._last_played_counter = last_played_counter
        self._play_between_games = play_between_games
        self._recent_average_play = recent_average_play
        self._all_draws_average_play = all_draws_average_play
        self._candles = candles

    def set_recent(self, recent_counter: int):
        self._recent_games_counter = recent_counter

    def set_all_draws(self, all_draws: int):
        self._all_games_counter = all_draws

    def set_last_played_date(self, last_played_date: str):
        if self._last_played_date == 'Never':
            self._last_played_date = last_played_date

    def set_last_played_counter(self, last_played_counter: int):
        if self._last_played_counter == -1:
            self._last_played_counter = last_played_counter

    def set_recent_average_play(self, recent_average_play: float):
        if self._recent_average_play == -1:
            self._recent_average_play = recent_average_play

    def set_all_draws_average_play(self, all_draws_average_play: float):
        if self._all_draws_average_play == -1:
            self._all_draws_average_play = all_draws_average_play

    def set_candles(self, candles):
        self._candles = candles

    def set_between_games(self, play_between_games: dict):
        self._play_between_games = play_between_games

    def info(self) -> str:
        return f'{self._ball} : {self._recent_games_counter} : {self._all_games_counter} : {self._last_played_date}' \
               f' ({self._last_played_counter} draws ago) : {"%.2f" % self._recent_average_play} : {"%.2f" % self._all_draws_average_play} : {self._candles} : {self._play_between_games}'

    def to_row(self) -> list:
        number_data = [self._ball, self._recent_games_counter, self._all_games_counter, self._last_played_date,
                       self._last_played_counter, "%.2f" % self._recent_average_play,
                       "%.2f" % self._all_draws_average_play]
        for item in self._candles:
            number_data.append(item)
        for item in self._play_between_games.items():
            number_data.append(item[1])
        return number_data

    def __repr__(self):
        return repr((self._ball, self._recent_games_counter, self._all_games_counter, self._last_played_date,
                     self._last_played_counter, self._play_between_games, self._recent_average_play,
                     self._all_draws_average_play, self._candles))


numbers_data = {}

for number in range(1, 51):
    numbers_data[number] = EuroNumber(number, -1, -1, 'Never', -1, {}, -1, -1, {})


def recent_updater():
    recent_numbers = {}
    for a_number_idx in range(1, 51):
        recent_numbers[int(a_number_idx)] = 0

    for line in recent_draws_data[1: len(recent_draws_data)]:
        for column_idx in range(2, lotto_utils.get_last(7)):
            recent_numbers[int(line[column_idx])] = recent_numbers.get(column_idx) + 1

    output.debug_print(f'recent_numbers len {len(recent_numbers)}')

    for recent_number in recent_numbers:
        numbers_data.get(int(recent_number)).set_recent(recent_numbers[recent_number])
        numbers_data.get(int(recent_number)).set_recent_average_play(float(recent_numbers[recent_number] / 51) * 100)

    if config.settings['detailed_mode']:
        output.display_numbers(recent_numbers, 'balls (recent):')


def all_updater():
    all_numbers = {}
    for a_number in range(1, 51):
        a_number = int(a_number)
        all_numbers[a_number] = 0

    for line in all_draw_data[0: len(all_draw_data)]:
        for all_number in range(2, lotto_utils.get_last(7)):
            all_numbers[line[all_number]] = all_numbers.get(line[all_number], 0) + 1

    for a_number in all_numbers:
        idx = int(a_number)
        numbers_data.get(idx).set_all_draws(all_numbers[a_number])
        numbers_data.get(idx).set_all_draws_average_play(float(idx / games) * 100)
    ranges_1to10 = count_ball_played_in_games(all_draw_data[0:10])
    ranges_11to20 = count_ball_played_in_games(all_draw_data[10:20])
    ranges_21to30 = count_ball_played_in_games(all_draw_data[20:30])
    ranges_31to40 = count_ball_played_in_games(all_draw_data[30:40])
    ranges_41to50 = count_ball_played_in_games(all_draw_data[40:50])
    ranges_51to60 = count_ball_played_in_games(all_draw_data[50:60])
    ranges_61to70 = count_ball_played_in_games(all_draw_data[60:70])
    ranges_71to80 = count_ball_played_in_games(all_draw_data[70:80])
    ranges_81to90 = count_ball_played_in_games(all_draw_data[80:90])
    ranges_91to100 = count_ball_played_in_games(all_draw_data[90:100])

    candles = {}
    for ball in range(1, 51):
        candles[ball] = [ranges_1to10[ball], ranges_11to20[ball], ranges_21to30[ball], ranges_31to40[ball],
                         ranges_41to50[ball], ranges_51to60[ball], ranges_61to70[ball], ranges_71to80[ball],
                         ranges_71to80[ball], ranges_81to90[ball], ranges_91to100[ball]]
        numbers_data.get(ball).set_candles(candles[ball])
        numbers_data.get(ball).set_between_games(count_ball_played_between_games(ball, all_draw_data))

    for pos, a_draw in enumerate(all_draw_data):
        for column in range(2, 7):
            idx = int(a_draw[column])
            numbers_data.get(idx).set_last_played_date(a_draw[1])
            numbers_data.get(idx).set_last_played_counter(pos)


def count_ball_played_in_games(draws_list: list) -> dict:
    all_numbers = {}
    for a_number in range(1, 51):
        a_number = int(a_number)
        all_numbers[a_number] = 0

    for line in draws_list[0: len(draws_list)]:
        for all_number in range(2, 7):
            all_numbers[int(line[all_number])] = all_numbers.get(int(line[all_number])) + 1

    return all_numbers.copy()


def count_ball_played_between_games(selected_ball: int, draw_list: list) -> dict:
    counter_between_games = {}
    for a_number in range(1, 11):
        a_number = int(a_number)
        counter_between_games[a_number] = 0
    counter_between_games[99] = 0
    last_played_ball = 0
    for draw in draw_list:
        last_played_ball = last_played_ball + 1
        for ball in range(2, 7):
            if selected_ball == int(draw[ball]):
                if last_played_ball > 10:
                    counter_between_games[99] = counter_between_games.get(99) + 1
                else:
                    counter_between_games[last_played_ball] = counter_between_games.get(last_played_ball) + 1
                last_played_ball = 0

    return counter_between_games.copy()


def stats():
    recent_updater()
    all_updater()

    stars = {}
    stars_pair = []
    for a_draw in all_draw_data:
        first_number = int(a_draw[7].strip())
        second_number = int(a_draw[8].strip())
        stars[first_number] = stars.get(first_number, 0) + 1
        stars[second_number] = stars.get(second_number, 0) + 1
        stars_pair.append((first_number, second_number))
    output.display_numbers(stars, 'stars count:')
    output.display_numbers(lotto_utils.count_pairs(stars_pair), 'stars pairs count:')
    last_played()


def last_played():
    all_draws_list = draws_manager.get_all_draws_for_euromillions()
    last_played_list = {}
    last_played_stars_list = {}

    for last_played_number in range(1, 51):
        last_played_list[last_played_number] = 'Never'
        if last_played_number <= 12:
            last_played_stars_list[last_played_number] = 'Never'

    for a_draw in all_draws_list:
        for column in range(2, 7):
            lotto_utils.assign_last_played_if_never_play_before(int(a_draw[column]), a_draw[1], last_played_list)
        for column in range(7, 9):
            lotto_utils.assign_last_played_if_never_play_before(int(a_draw[column]), a_draw[1], last_played_stars_list)

    output.display_numbers(last_played_list, 'last played number date:')
    output.display_numbers(last_played_stars_list, 'last played stars date:')


def save_to_file():
    analysis_data = open(path_to_analysis_file, 'w')
    writer = csv.writer(analysis_data)
    for idx in numbers_data:
        writer.writerow(numbers_data.get(idx).to_row())


if __name__ == '__main__':
    stats()
    for number in numbers_data:
        print(numbers_data.get(number).info())
    save_to_file()
    os.startfile(path_to_analysis_file)
