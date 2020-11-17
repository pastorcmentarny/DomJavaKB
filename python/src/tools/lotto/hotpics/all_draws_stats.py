import csv

from src.tools.lotto import config

lotto_hotpicks_history_path = config.get_project_path('lotto-hotpicks-all-draws.csv')
lotto_hotpics_draw_history_file = open(lotto_hotpicks_history_path)


def get_number_plays_in_all_known_draws():
    euro_hotpics_history_csv = csv.reader(lotto_hotpics_draw_history_file)
    data = list(euro_hotpics_history_csv)

    # display numbers count
    numbers = {}

    for line in data[1: len(data)]:
        for number in range(1, 7):
            line_number = line[number].strip()
            numbers[line_number] = numbers.get(line_number, 0) + 1

    return numbers


def display_numbers(numbers: dict):
    numbers = [(key, numbers[key]
                ) for key in sorted(numbers, key=numbers.get, reverse=True)]
    for key, value in numbers:
        print(str(key) + ': ' + str(value))


if __name__ == '__main__':
    display_numbers(get_number_plays_in_all_known_draws())
