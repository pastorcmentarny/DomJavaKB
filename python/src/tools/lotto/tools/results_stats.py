import csv

import time

from src.tools.lotto.utils import output


def load_results_for(path: str) -> list:
    print(f'Loading results from {path}')
    result_path = open(path)
    result_as_csv = csv.reader(result_path)
    result_as_list = list(result_as_csv)
    output.debug_print(f'File loaded.')
    return result_as_list[1:len(result_as_list)]


def get_percent_for(amount: int, total: int) -> str:
    return "{:.1f}".format(amount / total * 100)


def generate_results_for(game: str, path):
    results = load_results_for(path)
    wins_count = 0
    wins_amount = 0
    all_games = len(results)
    for result in results:
        line = result[0].split(';')
        win_amount = int(line[7])
        if win_amount > 0:
            wins_count += 1
            wins_amount += win_amount
    print(
        f'You play {all_games} times.You won {wins_count} of {all_games}.\n'
        f'You win rate is {get_percent_for(wins_count, all_games)}%\n'
        f'You spent £{all_games}. You won £{wins_amount}. Your balance is £{wins_amount - all_games}.')


def generate_results():
    game = 'thunderball'
    output.draw_title(game)
    generate_results_for(game, r'B:\GitHub\DomJavaKB\data\lotto\thunderball-results-2021.csv')


if __name__ == '__main__':
    print('Generating results...')
    generate_results()
    print('Done.')
