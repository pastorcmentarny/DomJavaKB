import csv

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


def generate_results_for(game: str, path, won_amount_column: int, ticket_cost: float):
    results = load_results_for(path)
    wins_count = 0
    wins_amount = 0
    all_games = len(results)
    for result in results:
        line = result[0].split(';')
        win_amount = int(line[won_amount_column])
        if win_amount > 0:
            wins_count += 1
            wins_amount += win_amount
    print(
        f'You play {all_games} times.You won {wins_count} of {all_games}.\n'
        f'You win rate is {get_percent_for(wins_count, all_games)}%\n'
        f'You spent £{all_games}. You won £{wins_amount}. Your balance is £{wins_amount - all_games * ticket_cost}.')
    output.debug_print(f'Results stats for {game} completed.')


def generate_results():
    game = 'Lotto'
    output.draw_title(game, 1)
    generate_results_for(game, r'B:\GitHub\DomJavaKB\data\lotto\lotto-results-2021.csv', 1, 2)

    game = 'Lotto Hotpicks'
    output.draw_title(game, 1)
    generate_results_for(game, r'B:\GitHub\DomJavaKB\data\lotto\lotto-hotpicks-results-2021.csv', 1, 1)

    game = 'Euro Hotpicks'
    output.draw_title(game, 1)
    generate_results_for(game, r'B:\GitHub\DomJavaKB\data\lotto\euro-hotpicks-results-2021.csv', 1, 1.5)

    game = 'EuroMillions'
    output.draw_title(game, 1)
    generate_results_for(game, r'B:\GitHub\DomJavaKB\data\lotto\euro-results-2021.csv', 8, 2.5)

    game = 'Thunderball'
    output.draw_title(game, 1)
    generate_results_for(game, r'B:\GitHub\DomJavaKB\data\lotto\thunderball-results-2021.csv', 7, 1)


if __name__ == '__main__':
    print('Generating results...')
    generate_results()
    print('\nDone.')
