import csv

from src.tools.lotto import config

thunderball_history_path = config.path['base'] + 'thunderball-all-draws.csv'
thunderball_draw_history_file = open(thunderball_history_path)


def main():
    # load data
    print(thunderball_history_path)
    thunderball_history_csv = csv.reader(thunderball_draw_history_file)
    data = list(thunderball_history_csv)

    numbers = {}

    for line in data[1: len(data)]:
        numbers[line[1]] = numbers.get(line[1], 0) + 1
        numbers[line[2]] = numbers.get(line[2], 0) + 1
        numbers[line[3]] = numbers.get(line[3], 0) + 1
        numbers[line[4]] = numbers.get(line[4], 0) + 1
        numbers[line[5]] = numbers.get(line[5], 0) + 1

    numbers = [(key, numbers[key]) for key in sorted(numbers, key=numbers.get, reverse=True)]
    for key, value in numbers:
        print(str(key) + ': ' + str(value))


if __name__ == '__main__':
    main()
