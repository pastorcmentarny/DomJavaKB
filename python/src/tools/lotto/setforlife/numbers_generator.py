from src.tools.lotto.tools import draws_manager
from src.tools.lotto.utils import lotto_utils
from src.tools.lotto.utils import output

all_draws_data = draws_manager.get_all_draws_for_set_for_life()


def generate_random_numbers_for_set_for_life():
    print('number counter')
    numbers = {}
    for i in range(1, lotto_utils.get_last(47)):
        numbers[str(i)] = 0

    for line in all_draws_data[1: len(all_draws_data)]:
        for i in range(1, lotto_utils.get_last(5)):
            numbers[line[i]] = numbers.get(line[i], 0) + 1

    output.display_numbers(numbers)


if __name__ == '__main__':
    generate_random_numbers_for_set_for_life()
