import random


def get_random_value_from(type: list):
    return type[random.randint(0, len(type) - 1)]
