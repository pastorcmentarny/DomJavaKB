import csv
import itertools
import logging
import time
from src.tools.lotto import config

all_draws_path = config.path["base"] + 'lotto-hotpicks-all-draws.csv'
# all_draws_path = base_dir + 'test.csv'
result = config.path["base"] + 'result_double.txt'
percentage_format = "%.2f"

all_draws_file = open(all_draws_path, 'r')
all_draws_csv = csv.reader(all_draws_file)
all_draws_data = list(all_draws_csv)
logging.basicConfig(level=logging.DEBUG, format=' %(asctime)s - %(levelname)s - %(message)s',
                    filename=config.path["base"] + 'log.txt')


class Doubles:
    def __init__(self, number1, number2):
        # sorted from smallest to highest
        self.number1 = number1
        self.number2 = number2
        self.count = 0

    def __repr__(self):
        return repr((self.number1, self.number2, self.count))

    def contains_number(self, number):
        return number == self.number1 or number == self.number2

    def contains_all_numbers(self, n1, n2):
        return self.contains_number(int(n1)) and self.contains_number(int(n2))

    def verify(self):
        return self.number1 != self.number2

    def add(self):
        self.count += 1

    def get_count(self):
        return self.count

    def sort_numbers(self):
        list = [self.number1, self.number2]
        list.sort(key=int)
        self.number1 = list[0]
        self.number2 = list[1]


def main():
    logging.debug("generate triples counter..")

    triples_list = generate_all_possible_triplets()

    start = time.time()

    all_sorted_combinations = generate_all_possible_triples_combination(start)

    total = int(len(list(all_sorted_combinations)) * len(triples_list))
    step = int(total / 12500)

    print("INFO. total" + str(total) + " progress should be display every " + str(step) + " elements.")

    count_all_triples_drawn(all_sorted_combinations, start, step, total, triples_list)

    triples_list = sorting_result(triples_list)

    stop = time.time()
    logging.info("It tooks " + str(stop - start) + " seconds.")
    saving_result_to_file(triples_list)

    logging.debug("done")


def generate_all_possible_triples_combination(start):
    logging.debug("generate all possible triples from all draws " + str(start))
    all_sorted_combinations = []
    for draw in all_draws_data:
        numbers = [draw[1], draw[2], draw[3], draw[4], draw[5], draw[6]]
        draw_combinations = itertools.combinations(numbers, 2)
        all_sorted_combinations.extend(draw_combinations)
    return all_sorted_combinations


def saving_result_to_file(triples_list):
    logging.debug("saving result to file")
    result_file = open(result, 'w')
    for triple in triples_list:
        result_file.write(
            str(triple.number1) + " " + str(triple.number2) + ": Count:" + str(
                triple.count) + '\n')
    result_file.close()


def sorting_result(triples_list):
    logging.debug("sorting result ...")
    triples_list = list(triples_list)
    triples_list = sorted(triples_list, reverse=True, key=lambda triple: triple.count)
    return triples_list


def count_all_triples_drawn(all_sorted_combinations, start, step, total, triples_list):
    logging.debug("start counting")
    counter = 0
    for sc in all_sorted_combinations:
        if counter % step == 0:
            progress = counter / total * 100
            print("it took " + str(int(time.time() - start)) + " seconds to processed " + str(
                counter) + " of total:" + str(total) + " Progress: " + str(percentage_format % progress))

        sorted_list = [sc[0], sc[1]]
        sorted_list = list(sorted_list)
        sorted_list.sort(key=int)
        for triple in triples_list:
            counter += 1
            if triple.contains_all_numbers(sorted_list[0], sorted_list[1]):
                triple.add()


def generate_all_possible_triplets():
    logging.debug("generate all possible triples")
    triples_list = set()
    all_triple_combinations = itertools.combinations(range(1, 60), 2)
    for triple_combination in all_triple_combinations:
        sorted_list = [triple_combination[0], triple_combination[1]]
        sorted_list.sort(key=int)
        triples_list.add(Doubles(sorted_list[0], sorted_list[1]))
    return triples_list


if __name__ == '__main__':
    main()
