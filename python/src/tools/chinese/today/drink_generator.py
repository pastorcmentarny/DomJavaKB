import random

from src.tools.chinese.today import application_utils

drink = {
    'orange juice': '橙汁',
    'tea': '茶',
    'coffee': '咖啡',
    'beer': '啤酒',
    'water': '水',
    'red wine': '红酒'
}

tea_type = ['绿', '黑', '普洱', '茉莉花', '红', '甘菊', '乌龙']
# 茉莉花 - mòlìhuā, 甘菊 - chamomile, 乌龙 -  oolong

coffee_type = ['黑', '加奶咖啡', '拿铁', '卡布奇诺', '浓']
# 卡布奇诺 - cappuccino,
dot = '。\n'

prefix = '喝了'


def generate_random_tea() -> str:
    return prefix + application_utils.get_random_value_from(tea_type) + '茶'


def generate_random_coffee() -> str:
    return prefix + application_utils.get_random_value_from(coffee_type) + '咖啡'


def generate_other_drink():
    return prefix + '气泡矿泉水'


def generate_random_non_alkocholic_drink() -> str:
    options = [generate_random_tea, generate_random_coffee, generate_other_drink]
    randint = random.randint(0, len(options) - 1)
    return options[randint]() + dot
