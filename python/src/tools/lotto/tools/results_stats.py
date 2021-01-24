import csv

from src.tools.lotto.utils import output


def load_results_for(path: str) -> list:
    output.debug_print(f'Loading results from {path}')
    result_path = open(path)
    result_as_csv = csv.reader(result_path)
    result_as_list = list(result_as_csv)
    output.debug_print(f'File loaded.')
    return result_as_list[1:len(result_as_list)]


def get_percent_for(amount: int, total: int) -> str:
    return "{:.1f}".format(amount / total * 100)


def as_money(money) -> str:
    return "{:.2f}".format(money)


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
    all_ticket_cost = all_games * ticket_cost
    balance = wins_amount - all_ticket_cost

    print(
        f'You play {all_games} times.You won {wins_count} of {all_games}.\n'
        f'You win rate is {get_percent_for(wins_count, all_games)}%\n'
        f'You spent £{all_games * ticket_cost}. You won £{wins_amount}. Your balance is £{as_money(balance)}.')
    output.debug_print(f'Results stats for {game} completed.')
    return {
        'wins_count': wins_count,
        'wins_amount': wins_amount,
        'all_games': all_games,
        'all_ticket_cost': all_ticket_cost,
        'balance': balance,
    }


def generate_results():
    game = 'Lotto'
    output.draw_title(game, 1)
    lotto_result = generate_results_for(game, r'B:\GitHub\DomJavaKB\data\lotto\lotto-results-2021.csv', 1, 2)

    game = 'Lotto Hotpicks'
    output.draw_title(game, 1)
    lotto_hotpicks_result = generate_results_for(game,
                                                 r'B:\GitHub\DomJavaKB\data\lotto\lotto-hotpicks-results-2021.csv', 1,
                                                 1)

    game = 'Euro Hotpicks'
    output.draw_title(game, 1)
    euro_hotpicks_result = generate_results_for(game, r'B:\GitHub\DomJavaKB\data\lotto\euro-hotpicks-results-2021.csv',
                                                1, 1.5)

    game = 'EuroMillions'
    output.draw_title(game, 1)
    euro_result = generate_results_for(game, r'B:\GitHub\DomJavaKB\data\lotto\euro-results-2021.csv', 8, 2.5)

    game = 'Thunderball'
    output.draw_title(game, 1)
    thunderball_result = generate_results_for(game, r'B:\GitHub\DomJavaKB\data\lotto\thunderball-results-2021.csv', 7,
                                              1)

    all_games = lotto_result.get('all_games') + lotto_hotpicks_result.get('all_games') + euro_hotpicks_result.get(
        'all_games') + euro_result.get('all_games') + thunderball_result.get('all_games')
    wins_count = lotto_result.get('wins_count') + lotto_hotpicks_result.get('wins_count') + euro_hotpicks_result.get(
        'wins_count') + euro_result.get('wins_count') + thunderball_result.get('wins_count')
    all_wins_amount = lotto_result.get('wins_amount') + lotto_hotpicks_result.get(
        'wins_amount') + euro_hotpicks_result.get('wins_amount') + euro_result.get(
        'wins_amount') + thunderball_result.get('wins_amount')
    all_ticket_cost = lotto_result.get('all_ticket_cost') + lotto_hotpicks_result.get(
        'all_ticket_cost') + euro_hotpicks_result.get('all_ticket_cost') + euro_result.get(
        'all_ticket_cost') + thunderball_result.get('all_ticket_cost')

    output.draw_title('Summary', 2)
    print(f'All games count {all_games}. You won {wins_count}. Winning rate {get_percent_for(wins_count, all_games)} %')
    print(
        f'You won £{all_wins_amount}, spent £{all_ticket_cost} on games and your balance is £{as_money(all_wins_amount - all_ticket_cost)}.\n')


if __name__ == '__main__':
    print('Generating results...')
    generate_results()
    print('\nDone.')