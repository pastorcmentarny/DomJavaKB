import csv
import logging
import os

# this app is used to provide information for given numbers how many times you won. it will check for 3,4,5,5+ and 6 number
# validate numbers to ensure is 6 of them and they are unique
# split them into all possible 3s 4s 5s and 6 number combinations
# load all results
# scan for hit for each combination
# result
base_dir = '../../../../data/lotto/'
logging.basicConfig(level=logging.DEBUG, format=' %(asctime)s - %(levelname)s - %(message)s',
                    filename=base_dir + 'log.txt')

# numbers = ['2 ', '5 ', '14', '22', '44']
numbers = ['3 ', '20', '29', '32', '35', '43']


def main():
    logging.debug("checking if numbers you selected won in the past results")
    info()
    validate()

    lotto_hotpicks_history_path = base_dir + 'lotto-hotpicks-all-draws.csv'
    lotto_hotpics_draw_history_file = open(lotto_hotpicks_history_path)

    # load data
    euro_hotpics_history_csv = csv.reader(lotto_hotpics_draw_history_file)
    data = list(euro_hotpics_history_csv)

    print("6's : " + str(count_hits(data, 6)))
    print("5's : " + str(count_hits(data, 5)))
    print("4's : " + str(count_hits(data, 4)))
    print("3's : " + str(count_hits(data, 3)))
    print("2's : " + str(count_hits(data, 2)))
    print("1's : " + str(count_hits(data, 1)))

    print("If no result, ensure you format all results in " + lotto_hotpicks_history_path)


def info():
    print('Numbers' + str(numbers))
    print(os.getcwd())


def validate():
    if len(numbers) > len(set(numbers)):
        raise ValueError("Numbers are not equal")
    else:
        print("Validation done. Given numbers are unique.")


# improve it
def count_hits(data: list, must_hit: int):
    counter = 0
    for draw in data:
        hit = 0
        if numbers[0] in draw:
            hit += 1
        if numbers[1] in draw:
            hit += 1
        if numbers[2] in draw:
            hit += 1
        if numbers[3] in draw:
            hit += 1
        if numbers[4] in draw:
            hit += 1
        if hit >= must_hit:
            counter += 1
    return counter


if __name__ == '__main__':
    main()
