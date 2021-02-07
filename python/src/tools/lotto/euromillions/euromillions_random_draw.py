import random
from timeit import default_timer as timer

from src.tools.lotto.eurohotpics import two_numbers_generator
from src.tools.lotto.tools import draws_manager
from src.tools.lotto.utils import output, lotto_utils

recent_draw_data = draws_manager.get_recent_draws_for_euromillions()
numbers = []

print(recent_draw_data)


def select_random_stars_if_lazy():
    bonus = list(range(1, 13))
    random.shuffle(bonus)
    random.shuffle(bonus)
    selected_numbers = [bonus[3], bonus[7]]
    selected_numbers = sorted(selected_numbers)
    return f' : {selected_numbers[0]} and {selected_numbers[1]}'


def draw():
    for number in range(1, 51):
        if lotto_utils.is_number_not_drawn_last_2_games(number, recent_draw_data):
            numbers.append(number)
    random.shuffle(numbers)
    euro_hotpics_numbers = two_numbers_generator.generate_two_random_numbers()
    print(f'hotpicks: {str(euro_hotpics_numbers)}')
    numbers_to_play = []
    for euro_hotpics_number in euro_hotpics_numbers:
        numbers_to_play.append(int(euro_hotpics_number))
    count = 3
    for number in numbers:
        numbers_to_play.append(number)
        count += 1
        if count == 6:
            break
    numbers_to_play = list(set(numbers_to_play))
    while len(numbers_to_play) < 5:
        print('select another number as there is not enough numbers')
        numbers_to_play.append(numbers[random.randint(0, 50)])
        numbers_to_play = list(set(numbers_to_play))
    print(sorted(numbers_to_play))
    print(f'Run analytics to select stars or if you in lazy mode, pick these{select_random_stars_if_lazy()}.')


if __name__ == '__main__':
    start_time = timer()
    draw()
    output.debug_mode_warning()
    end_time = timer()
    print('It took {} ms.'.format(int((end_time - start_time) * 1000)))
