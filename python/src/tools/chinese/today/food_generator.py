import random

from tools.chinese.today import application_utils, drink_generator

drink = {
    'orange juice': '橙汁',
    'tea': '茶',
    'coffee': '咖啡',
    'beer': '啤酒',
    'water': '水',
    'red wine': '红酒'
}

breakfast = {
    'coffee': drink['coffee'],
    'kefir': 'kefir',
    'british': '英国的早饭(香肠,烽火,拼字蛋,烤豆,番茄,蘑菇和炸土豆饼)',
    'sandwich': '三明治(火腿,起司,番茄,黄瓜和生菜)'
}

polish_dish = {
    'barszcz czerwony,': '红罗宋汤',
    'żurek': 'żurek',
    'barszcz biały': '白罗宋汤',
    'bigos': 'bigos',
    'grochówka': '豌豆汤',
    'galareta drobiowa': '鸡肉冻',
    'galareta wieprzowa,': '猪肉冻',
    'zupa warzywna': '',
    'karp, sandacz po polsku, węgorz i inne ryby słodkowodne,,': '',
    'kapuśniak': '',
    'zupa grzybowa': '蘑菇汤',
    'zupa ogórkowa': '黄瓜汤',
    'rosół': '肉汤',
    'kluski': '面条',
    'racuchy': '煎饼',
    'kaszanka': '黑布丁',
    'polskie pierogi': '波兰饺子'
}

dish = {
    'kung pao chicken': '宫保鸡丁',
    'mapo tofu': '麻婆豆腐)',
    'sweet and sour pork': '咕咾肉',
    'cheeseburger': '乳酪汉堡',
    'hamburger': '汉堡',
    'Fish & Chips': '鱼片',
    'Yorkshire Pudding': '约克郡布丁',
    'Sausage & Mash': '香肠和马什'
}

prefix_food = [
    '辣',  # spicy
    '糖醋',  # sweet & sour
    '四川',  # sichuan
    '湖南',  # húnán
    '广东',  # guǎngdōng
    '福建',  # fújiàn
    '黑胡椒',  # black pepper

]

main_food = [
    '牛肉',  # beef
    '鸡肉',  # 'chicken':
    '鱼',  # 'fish'
    '土豆',  # 'potato':
    '素',  # 'vegeterian':
    '香肠',  # sausage
    '菜'  # 'vegetable'
]

type_food = [
    '米饭',  # 'rice'
    '土豆',  # 'potato'
    '薯条',  # 'fries'
    '汤',  # 'soup'
    '面条'  # 'noodles'
]


def generate_full_meal():
    return application_utils.get_random_value_from(prefix_food) + application_utils.get_random_value_from(
        main_food) + application_utils.get_random_value_from(type_food) + '和喝' + drink_generator.generate_random_non_alkocholic_drink()


def get_random_meal():
    meal = "我吃了"
    meal += main_food[random.randint(0, size_for(main_food))]
    meal += type_food[random.randint(0, size_for(type_food))]
    return meal + '。\n'


def generate_meal(meals: list) -> str:
    return application_utils.generate_sentence_from_multi_words(meals)


def size_for(items) -> int:
    return len(items) - 1
