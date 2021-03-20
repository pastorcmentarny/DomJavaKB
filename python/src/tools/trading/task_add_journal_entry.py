import ast
import datetime
import json

# SETTINGS
AMOUNT = 'amount'
TRANSATION_ID = 'transaction id'
DATA = "data"
TYPE = "type"
debug_mode = False

ENCODING = 'utf-8'
PATH = r'e:\Dropbox\trading\journal.txt'

DOT = '.'
SPACE = ' '
EMPTY = ''

# EXIT TYPES
EARLY_PROFIT_EXIT = 'EARLY EXIT TO PROTECT REVENUE'
MANUAL_EXIT = 'manual exit'
EXIT_BY_ERROR = 'accidental exit'
AUTO_EXIT_PROFIT_SL = 'auto exit profit SL'
AUTO_EXIT_TARGET_PRICE = 'auto exit (TP)'
AUTO_EXIT_STOP_LOSS = "STOP LOSS"
MANUAL_EXIT_STOP_LOSS = "MANUAL EXIT DUE TO STOP LOSS"
MAX_DAILY_LOST_CAP = 'exit due to it reach max daily lost cap'

# FIELDS
COMMENT_FIELD = "comment"
STRATEGY_NAME = "Strategy Name"
STATUS_OPEN = 'open'
STATUS_CLOSE = 'closed'

TRADE_TYPE_BUY = 'buy'
TRADE_TYPE_SELL = 'sell'

MANDATORY_FIELD = None

WIN = 'Winner'
LOSE = 'Loser'
journal_entry = {
    TYPE: 'trade',
    "id": 0,
    DATA: EMPTY
}

trade_data = {
    "status": EMPTY,  # planned, open, close
    TRANSATION_ID: 0,  # ticket number
    STRATEGY_NAME: EMPTY,
    "Market": EMPTY,
    "Long/Short": None,
    "entry": {
        "points": 0,
        "datetime": None,
        "target": 0,
        "stop": 0,
        "stake": 0  # in pence
    },
    "exit": {
        "datetime": None,
        "Exit Reason": None,
        "Exit Price": None,
        "Exit Points": None,

    },
    "Number of days in Trade": None,
    "Risk Reward Projected": None,
    "Risk Reward Actual": None,
    "outcome": {
        "Result": None,  # Options: Winner Loser Draw'
        "amount": 0  # in pence
    },
    COMMENT_FIELD: EMPTY

}

tradings_journal = []


def print_if_debug_enabled(message: str):
    if debug_mode:
        print(message)


def get_next_trade():
    return 0


def save_trading_journal_to_file():
    with open(PATH, 'w', encoding=ENCODING) as journal_file:
        journal_file.writelines(["%s\n" % item for item in tradings_journal])


def load_trading_journal_from_file():
    global tradings_journal
    tradings_journal = []

    with open(PATH, 'r', encoding=ENCODING) as journal_file:
        results = journal_file.readlines()
        for result in results:
            tradings_journal.append(
                json.loads(json.dumps((ast.literal_eval(result)))))  # it loads dict as string and convert to dict


# example: "45458668	1999.01.01 16:16:16	balance	Card payment 750.00"
def add_balance_change(balance_line: str, comment: str = EMPTY):
    entry = journal_entry.copy()
    line = balance_line.split('\t')

    message_with_amount = line[3].split(' ')

    data = {}
    data[TRANSATION_ID] = line[0]
    data['transaction date'] = line[1]
    data['message'] = " ".join(message_with_amount[0:len(message_with_amount)])
    data['amount'] = line[4]

    entry.update({
        'id': len(tradings_journal) + 1,
        TYPE: line[2],
        'data': data,
        COMMENT_FIELD: comment
    })
    tradings_journal.append(entry)


# 45563113	2021.02.14 23:02:47	buy	0.10	usoil(Ł)	60.298	60.474	61.608	2021.02.17 14:08:46	60.474	0.00	0.00	0.00	1.76
def calculate_total_days_in_trade(start_date, end_date):
    start = start_date.split(SPACE)[0].split(DOT)
    end = end_date.split(SPACE)[0].split(DOT)
    start_dt = datetime.datetime(int(start[0]), int(start[1]), int(start[2]))
    end_dt = datetime.datetime(int(end[0]), int(end[1]), int(end[2]))
    return (end_dt.date() - start_dt.date()).days


def is_duplicate(trade_number: str):
    for entry in tradings_journal:
        if entry[DATA][TRANSATION_ID] == trade_number:
            return True
    return False


def add_trade(strategy_name: str, exit_reason: str, rrp: str, trade_line: str,
              comment: str = EMPTY):
    entry = journal_entry.copy()
    line = trade_line.split('\t')

    message_with_amount = line[3].split(SPACE)

    if is_duplicate(line[0]):
        print(f'WARNING! {line[0]} is already in journal! This line {trade_line} is skipped.')
        return

    result = None
    amount = float(line[len(line) - 1])
    if amount > 0:
        result = WIN
    else:
        result = LOSE

    data = trade_data.copy()
    data.update({
        "status": STATUS_CLOSE,  # planned, open, close
        TRANSATION_ID: line[0],  # ticket number
        STRATEGY_NAME: strategy_name,
        "Market": line[4],
        "Long/Short": line[2],
        "entry": {
            "points": line[5],
            "datetime": line[1],
            "target": line[7],
            "stop": line[6],
            "stake": line[3]
        },
        "exit": {
            "datetime": line[8],
            "Exit Reason": exit_reason,
            "Exit Price": line[9],
            "Exit Points": line[9],

        },
        "Number of days in Trade": calculate_total_days_in_trade(line[1], line[8]),
        "Risk Reward Projected": rrp,
        "Risk Reward Actual": 0,  # TODO implement it
        "outcome": {
            "result": result,
            AMOUNT: amount
        },
        COMMENT_FIELD: comment
    })

    entry.update({
        'id': len(tradings_journal) + 1,
        TYPE: line[2],
        'data': data
    })
    tradings_journal.append(entry)
    print_if_debug_enabled(str(entry))


def generate_stats():
    print(f'Events: {len(tradings_journal)}')
    count = 0
    wins = 0
    loses = 0
    biggest_win_amount = 0.0
    biggest_lost_amount = 0.0
    biggest_win_streak = 0
    biggest_drawdown_streak = 0
    current_streak_count = 0
    balance = 0
    streak = LOSE
    for event in tradings_journal:
        print_if_debug_enabled(streak)
        print_if_debug_enabled(current_streak_count)
        if event[TYPE] == 'buy' or event[TYPE] == 'sell':
            count += 1
            if event['data']['outcome']['result'] == WIN:
                if streak == WIN:
                    current_streak_count = current_streak_count + 1
                else:
                    if current_streak_count > biggest_drawdown_streak:
                        biggest_drawdown_streak = current_streak_count
                        current_streak_count = 0
                        streak = WIN
                wins += 1
                print_if_debug_enabled(f'after {streak}')

                if float(event['data']['outcome'][AMOUNT]) > biggest_win_amount:
                    biggest_win_amount = float(event['data']['outcome'][AMOUNT])
            if event['data']['outcome']['result'] == LOSE:
                if streak == LOSE:
                    current_streak_count = current_streak_count + 1
                else:
                    if current_streak_count > biggest_win_streak:
                        biggest_win_streak = current_streak_count
                        current_streak_count = 0
                        streak = LOSE
                loses += 1

                print_if_debug_enabled(f'after {streak}')
                if float(event['data']['outcome'][AMOUNT]) < biggest_lost_amount:
                    biggest_lost_amount = float(event['data']['outcome'][AMOUNT])
        if event[TYPE] == 'balance':
            balance = balance + float(event[DATA][AMOUNT])
        else:
            balance = balance + float(event[DATA]['outcome'][AMOUNT])

    print(f'Tradings: {count}')
    print(f'Wins: {wins} Loses: {loses} Winning Ratio: {int((wins / (wins + loses)) * 100)}%')
    print(f'Biggest Win £{biggest_win_amount}')
    print(f'Biggest Win streak {biggest_win_streak}')
    print(f'Biggest Lost £{biggest_lost_amount}')
    print(f'Biggest drawndown streak {biggest_drawdown_streak}')
    print(f'Trading balance: {balance}')


if __name__ == '__main__':
    load_trading_journal_from_file()
    # add_balance_change("line") #BALANCE EXAMPLE
    # add_trade('gambling', MANUAL_EXIT, '1.5',"line" ) # TRADE EXAMPLE
    save_trading_journal_to_file()
    generate_stats()

# ADD AUTOBACKUP OF JOURNAL
"""
Gross Profit: 	0.00 	
Gross Loss: 	0.00 	
Total Net Profit: 	51.72
Absolute Drawdown: 	0.00 	
Maximal Drawdown: 	0.00 (0.00%)
Relative Drawdown: 	0.00% (0.00)
Total Trades: 	6
Short Positions (won %): 	3 (100.00%) 	
Long Positions (won %): 	3 (100.00%)
Profit Trades (% of total): 	6 (100.00%) 	
Loss trades (% of total): 	0 (0.00%)
Largest 	profit trade: 	18.72
Average 	profit trade: 	8.62
Maximum 	consecutive wins ($): 	6 (51.72) 	
consecutive losses ($): 	0 (0.00)
Maximal 	consecutive profit (count): 	51.72 (6) 	
consecutive loss (count): 	0.00 (0)
Average 	consecutive wins: 	6 	
consecutive losses: 	0
Do which day I am good at tradings Split by day.
"""
