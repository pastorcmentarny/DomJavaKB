import random
from timeit import default_timer as timer

from src.tools.lotto import config
from src.tools.lotto.utils import draws_manager, output, lotto_utils

# ====== SETTINGS ========
open_lotto_website_in_webrowser = config.settings['open_page']
debug_mode = config.settings['debug_mode']
extra_excluded_numbers = []  # add other numbers if you want exlude them
# ====== -------- ========

recent_draws_data = draws_manager.get_recent_draws_for_euromillions()
numbers = []


def draw():
    for number in range(1, 51):
        if lotto_utils.is_not_excluded(number, recent_draws_data):
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
            print(
                f"""Draw {draws}.
    Numbers: {balls[0]},{balls[1]},{balls[2]},{balls[3]},{balls[4]}.
    Stars: {bonus[3]} and {bonus[7]}""")
            draws = draws + 1
            balls.clear()


if __name__ == '__main__':
    start_time = timer()
    print('Generating random draws...')
    draw()
    output.debug_mode_warning()
    end_time = timer()
    print('It took {} ms.'.format(int((end_time - start_time) * 1000)))
