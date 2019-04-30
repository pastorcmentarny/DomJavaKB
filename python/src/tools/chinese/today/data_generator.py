import chinese_utils
import config
import random

tea_type = ['绿', '黑', '普洱', '茉莉花', '红', '甘菊', '乌龙']
# 茉莉花 - Mòlìhuā, 甘菊 - chamomile, 乌龙 -  oolong

coffee_type = ['黑', '加奶咖啡', '拿铁', '卡布奇诺', '浓']
# 卡布奇诺 - cappuccino,
prefix = '喝了'
dot = '。\n'


def generate_random_tea() -> str:
    return prefix + chinese_utils.get_random_value_from(tea_type) + '茶'


def generate_random_coffee() -> str:
    return prefix + chinese_utils.get_random_value_from(coffee_type) + '咖啡'


def generate_other_drink():
    return prefix + '气泡矿泉水'


def generate_random_non_alkocholic_drink() -> str:
    options = [generate_random_tea, generate_random_coffee, generate_other_drink]
    randint = random.randint(0, len(options) - 1)
    return options[randint]() + dot


def generate_random_lunch_break_activity() -> str:
    lunch_activity = ["因为正在下雨，我没有在午休时散步", "我午休时走了3公里", "我感觉不舒服，所以我在午休期间待在办公室"]
    return lunch_activity[random.randint(0, len(lunch_activity) - 1)] + dot


def generate__full_meal():
    return chinese_utils.get_random_value_from(config.prefix_food) + chinese_utils.get_random_value_from(
        config.main_food) + chinese_utils.get_random_value_from(config.type_food) + '和喝' + generate_random_non_alkocholic_drink()
