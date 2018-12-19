import csv

from src.tools.lotto import config

lotto_hotpicks_history_path = config.path['base'] + 'lotto-hotpicks-all-draws.csv'
lotto_hotpics_draw_history_file = open(lotto_hotpicks_history_path)


def main():
    # load data
    euro_hotpics_history_csv = csv.reader(lotto_hotpics_draw_history_file)
    data = list(euro_hotpics_history_csv)

    numbers = {}

    for line in data[1: len(data)]:
        for number in range(1,7):
            numbers[line[number]] = numbers.get(line[number], 0) + 1

    numbers = [(key, numbers[key]) for key in sorted(numbers, key=numbers.get, reverse=True)]
    for key, value in numbers:
        print(str(key) + ': ' + str(value))


if __name__ == '__main__':
    main()
