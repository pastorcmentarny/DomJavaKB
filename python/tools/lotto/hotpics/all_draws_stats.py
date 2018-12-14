import csv
import os

print(os.getcwd())
base_dir = '../../../../data/lotto/'
lotto_hotpicks_history_path = base_dir + 'lotto-hotpicks-all-draws.csv'
lotto_hotpics_draw_history_file = open(lotto_hotpicks_history_path)

# load data
euro_hotpics_history_csv = csv.reader(lotto_hotpics_draw_history_file)
data = list(euro_hotpics_history_csv)

for line in data[1: len(data)]:
    print(line)

numbers = {}

for i in range(1, 60):
    numbers[str(i)] = 0

for line in data[1: len(data)]:
    numbers[line[1]] = numbers.get(line[1], 0) + 1
    numbers[line[2]] = numbers.get(line[2], 0) + 1
    numbers[line[3]] = numbers.get(line[3], 0) + 1
    numbers[line[4]] = numbers.get(line[4], 0) + 1
    numbers[line[5]] = numbers.get(line[5], 0) + 1
    numbers[line[6]] = numbers.get(line[6], 0) + 1

numbers = [(key, numbers[key]) for key in sorted(numbers, key=numbers.get, reverse=True)]
for key, value in numbers:
    print(str(key) + ': ' + str(value))
