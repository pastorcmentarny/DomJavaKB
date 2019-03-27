import random

tea_type = ['绿', '黑', '普洱', '茉莉花', '红', '甘菊', '乌龙']
# 茉莉花 - Mòlìhuā, 甘菊 - chamomile, 乌龙 -  oolong

coffee_type = ['黑', '加奶咖啡', '拿铁', '卡布奇诺', '浓']
# 卡布奇诺 - cappuccino,
prefix = '喝了'


def get_random_drink_from(type: list):
    return type[random.randint(0, len(type) - 1)]


def generate_random_tea() -> str:
    return prefix + get_random_drink_from(tea_type) + '茶'


def generate_random_coffee() -> str:
    return prefix + get_random_drink_from(coffee_type) + '咖啡'


def generate_other_drink():
    return prefix + '气泡矿泉水'


def generate_random_non_alkocholic_drink() -> str:
    options = [generate_random_tea, generate_random_coffee, generate_other_drink]
    randint = random.randint(0, len(options) - 1)
    return options[randint]() + '。\n'
