import random

from src.tools.lotto import config
from src.tools.lotto.tools import draws_manager
from src.tools.lotto.utils import output, lotto_utils
from src.tools.lotto.utils.lotto_decorators import execution_time

# ====== SETTINGS ========
open_lotto_website_in_webrowser = config.settings['open_page']
debug_mode = config.settings['debug_mode']
extra_excluded_numbers = []  # add other numbers if you want exclude them
# ====== -------- ========

recent_draws_data = draws_manager.get_recent_draws_for_euromillions()
numbers = []


@execution_time
def draw():
    for number in range(1, 51):
        if lotto_utils.is_number_not_drawn_last_2_games(number, recent_draws_data):
            numbers.append(number)
    random.shuffle(numbers)

    count = 1
    draws = 1
    balls = []
    for number in numbers:
        balls.append(number)
        count += 1
        if count == 6:
            count = 1
            print()
            bonus = list(range(1, 13))
            random.shuffle(bonus)
            random.shuffle(bonus)
            balls = sorted(balls)
            print(
                f"""Draw {draws}.
    Numbers: {balls[0]},{balls[1]},{balls[2]},{balls[3]},{balls[4]}.
    Stars: {bonus[3]} and {bonus[7]}""")
            draws = draws + 1
            balls.clear()


if __name__ == '__main__':
    print('Generating random draws...')
    draw()
    output.debug_mode_warning()
