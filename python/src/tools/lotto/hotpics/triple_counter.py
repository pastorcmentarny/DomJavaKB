import itertools
import time

from src.tools.lotto import config
from src.tools.lotto.utils import draws_manager

result = config.get_project_path('result.txt')
percentage_format = "%.2f"

all_draws_data = draws_manager.get_all_draws_for_lotto()


class Triples:
    def __init__(self, number1, number2, number3):
        # sorted from smallest to highest
        self.number1 = number1
        self.number2 = number2
        self.number3 = number3
        self.count = 0

    def __repr__(self):
        return repr((self.number1, self.number2, self.number3, self.count))

    def contains_number(self, number):
        return any(number == i for i in [self.number1, self.number2, self.number3])

    def contains_all_numbers(self, n1, n2, n3):
        return all(self.contains_number(int(i)) for i in [n1, n2, n3])

    def verify(self):
        return self.number1 != self.number2 != self.number3

    def add(self):
        self.count += 1

    def get_count(self):
        return self.count

    def sort_numbers(self):
        a_list = [self.number1, self.number2, self.number3]
        a_list.sort(key=int)
        self.number1 = a_list[0]
        self.number2 = a_list[1]
        self.number3 = a_list[2]


def generate_all_possible_triples_combination(start):
    print("generate all possible triples from all draws " + str(start))
    all_sorted_combinations = []
    for draw in all_draws_data:
        numbers = [draw[1], draw[2], draw[3], draw[4], draw[5], draw[6]]
        draw_combinations = itertools.combinations(numbers, 3)
        all_sorted_combinations.extend(draw_combinations)
    return all_sorted_combinations


def saving_result_to_file(triples_list):
    print("saving result to file")
    result_file = open(result, 'w')
    for triple in triples_list:
        result_file.write(
            str(triple.number1) + " " + str(triple.number2) + " " + str(triple.number3) + ": Count:" + str(
                triple.count) + '\n')
    result_file.close()


def sorting_result(triples_list):
    print("sorting result ...")
    triples_list = list(triples_list)
    triples_list = sorted(triples_list, reverse=True, key=lambda triple: triple.count)
    return triples_list


def count_all_triples_drawn(all_sorted_combinations, start, step, total, triples_list):
    print("start counting")
    counter = 0
    for sc in all_sorted_combinations:
        if counter % step == 0:
            progress = counter / total * 100
            print("it took " + str(int(time.time() - start)) + " seconds to processed " + str(
                counter) + " of total: " + str(total) + ". Progress: " + str(percentage_format % progress))

        sorted_list = [sc[0], sc[1], sc[2]]
        sorted_list = list(sorted_list)
        sorted_list.sort(key=int)
        for triple in triples_list:
            counter += 1
            if triple.contains_all_numbers(sorted_list[0], sorted_list[1], sorted_list[2]):
                triple.add()


def generate_all_possible_triplets():
    print("generate all possible triples")
    triples_list = set()
    all_triple_combinations = itertools.combinations(range(1, 60), 3)
    for triple_combination in all_triple_combinations:
        sorted_list = [triple_combination[0], triple_combination[1], triple_combination[2]]
        sorted_list.sort(key=int)
        triples_list.add(Triples(sorted_list[0], sorted_list[1], sorted_list[2]))
    return triples_list


def main():
    print("Generate triples counter..")

    triples_list = generate_all_possible_triplets()

    start = time.time()

    all_sorted_combinations = generate_all_possible_triples_combination(start)

    total = int(len(list(all_sorted_combinations)) * len(triples_list))
    step = int(total / 2500000)

    print("INFO. total: " + str(total) + " progress should be display every " + str(step) + " elements.")

    count_all_triples_drawn(all_sorted_combinations, start, step, total, triples_list)

    triples_list = sorting_result(triples_list)

    stop = time.time()
    print("It took " + str(stop - start) + " seconds.")
    saving_result_to_file(triples_list)


if __name__ == '__main__':
    main()
