# SETTINGS
MAX_LOST_MULTIPLIER = 2.5
TARGET_MULTIPLIER = 1.1
MAX_PROFIT_MULTIPLIER = 3
MAX_WEEKLY_PROFIT_MULTIPLIER = 5.6  # (1.1% per day 5 days a week)

MONTHLY_STOP_LOST = 250

balance_today = 0  # set to zero before commit code
balance_monday = 0  # set to zero before commit code


def as_money(money: int):
    return f"{money / 100}"


def max_lost_allowance():
    return "%.2f" % (balance_today / 10000 * MAX_LOST_MULTIPLIER)  # 2.5 is a modifier that I may change


def daily_profit_cap():
    target = "%.2f" % (balance_today / 10000 * TARGET_MULTIPLIER)
    max_profit = "%.2f" % (balance_today / 10000 * MAX_PROFIT_MULTIPLIER)
    min_weekly_profit = "%.2f" % (balance_monday / 10000 * TARGET_MULTIPLIER)
    max_weekly_profit = "%.2f" % (balance_monday / 10000 * MAX_WEEKLY_PROFIT_MULTIPLIER)
    print(f'You aim is to get profit of £{target} and dont play more if you reach £{max_profit}.'
          f' Your weekly profit should be between £{min_weekly_profit} abd £{max_weekly_profit}.')


def calculate_limits():
    print(
        f'Your max total stop lose must be £{max_lost_allowance()} and your monthly lost allowance is £{MONTHLY_STOP_LOST}.')


def in_year_your_target_info():
    future_balance = balance_today

    for i in range(1, 250):
        future_balance = future_balance + future_balance / 100
    print(f'In year if you stick to 1% gain per day it should be: £{"%.2f" % (future_balance / 100)}')


if __name__ == '__main__':
    print(f'With your balance £{as_money(balance_today)}.')
    daily_profit_cap()
    calculate_limits()
    in_year_your_target_info()
