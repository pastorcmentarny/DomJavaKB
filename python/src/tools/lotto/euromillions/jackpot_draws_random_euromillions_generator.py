import random
from timeit import default_timer as timer

from src.tools.lotto import config
from src.tools.lotto.utils import draws_manager, output

# ====== SETTINGS ========
open_lotto_website_in_webrowser = config.settings['open_page']
debug_mode = config.settings['debug_mode']
extra_excluded_numbers = []  # add other numbers if you want exlude them
# ====== -------- ========

data = draws_manager.get_recent_draws_for_euromillions()
numbers = []


# all no played numbers , last draw
def is_not_excluded(a_number):
    excluded_numbers_list = []

    for a_draw in data[0:2]:
        excluded_numbers_list.append(a_draw[1])
        excluded_numbers_list.append(a_draw[2])
        excluded_numbers_list.append(a_draw[3])
        excluded_numbers_list.append(a_draw[4])
        excluded_numbers_list.append(a_draw[5])
    for ball in extra_excluded_numbers:
        excluded_numbers_list.append(ball)

    if a_number in excluded_numbers_list:
        return False
    return True


def draw():
    for i in range(1, 51):
        if is_not_excluded(i):
            numbers.append(i)
    random.shuffle(numbers)

    count = 1
    draws = 1
    balls = []
    for i in numbers:
        balls.append(i)
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
