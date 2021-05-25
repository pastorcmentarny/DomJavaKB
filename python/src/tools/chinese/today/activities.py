import random
from datetime import datetime

from src.tools.chinese.today import application_utils, chinese_time, config, file_loader, food_generator, sentence

EMPTY = ''

config_file = file_loader.config()
dot = config_file['dot']

dow = {
    'monday': 0,
    'tuesday': 1,
    'wednesday': 2,
    'thursday': 3,
    'friday': 4,
    'saturday': 5,
    'sunday': 6
}

date = datetime.now()


# need to change it
def thursday() -> int:
    return 4


# need to change it
def friday() -> int:
    return 5


def generate_random_lunch_break_activity() -> str:
    lunch_activity = ["因为正在下雨，我没有在午休时散步", "我午休时走了3公里", "我感觉不舒服，所以我在午休期间待在办公室"]
    return lunch_activity[random.randint(0, len(lunch_activity) - 1)] + dot


def generate_lunch_walk() -> str:
    if config_file['weather_description_1'] == '雨' or config_file['weather_description_2'] == '雨':
        return "因为正在下雨，我没有在午休时散步"  # I didn't go for a walk at lunch break as it was raining.
    else:
        walk = get_distance_from_run(random.randint(1000, 4501))
        return "我午休时走了" + walk + "公里"


def generate_weekend_activity():
    return application_utils.get_random_value_from(config.weekend_activity)


def get_distance_from_run(run_distance):
    return str('{:.1f}'.format(run_distance / 1000))


def get_weekend_routine():
    pass


def get_daily_routine():
    day_of_the_week = date.weekday()
    if day_of_the_week > friday():
        return get_workday_routine()
    else:
        return get_weekend_routine()


def get_workday_routine():
    # wake up 6.00-6.30
    # friday 7.45
    if date.weekday() == friday():
        "我没有吃了早饭但是我喝了咖啡"


# add KETO
def get_daily_activity_for(daily_date, meal):
    day = EMPTY
    day_of_the_week = daily_date.weekday()
    hour = 0
    minute = 0
    breakfast = EMPTY
    if day_of_the_week in range(dow['monday'], thursday()):
        hour = 6
        minute = 15
        breakfast = "我没有吃了早饭但是我喝了咖啡"
    elif day_of_the_week == friday:
        hour = 7
        minute = 30
        breakfast = "我没有吃早饭了"
    elif day_of_the_week == dow['saturday'] or day_of_the_week == dow['sunday']:
        hour = 8
        minute = 45
        breakfast = "我在早饭吃了" + food_generator.breakfast['british']

    day += "我早上" + chinese_time.get_time_in_chinese_for(hour, minute) + "起床" + dot  # woke up time
    day += breakfast + dot

    if day_of_the_week in range(dow['monday'], friday()):
        day += generate_random_lunch_break_activity()
        day += food_generator.generate_full_meal()
        day += "我在工作忙了" + dot  # day at work
        day += '我六点五分回到家' + dot  # back to home
    else:
        day += generate_weekend_activity() + dot

    # evening activity
    day += add_meal_sentence(meal)

    # dinner
    return day


def add_meal_sentence(meal: list) -> str:
    if len(meal) == 0:
        return food_generator.get_random_meal()
    else:
        return food_generator.generate_meal(meal)


def run_sentence(diary: dict):
    run_distance = diary['run_distance']
    run_time = diary['run_time']
    if run_distance > 0 and run_time > 0:
        return '我在早上去了慢跑。我跑了' + get_distance_from_run(
            run_distance) + '公里。跑了这个距离花了我' + application_utils.get_time_from_run(run_time) + dot
    else:
        return EMPTY


def add_breakfast(diary: dict):
    if diary['diet']:
        return "我没有吃了早饭但是我喝了咖啡" + dot
    breakfast_options = ['coffee', 'kefir', 'british', 'sandwich']
    return food_generator.breakfast[breakfast_options[random.randint(0, len(breakfast_options) - 1)]]


def add_work_day(diary: dict):
    work_day_diary = ''
    if datetime.now().weekday():
        if diary['wfh']:
            work_day_diary += '我在家工作.'
            if bool(random.getrandbits(1)):
                work_day_diary += '我没有乘坐地铁。'
        else:
            work_day_diary += '我在办公室上班.'
            if diary['travel'] == '':
                work_day_diary += '这次旅行很顺利。'  # 'The travel was uneventful.'
            else:
                work_day_diary += '火车已' + sentence.get_travel_experience_for(diary['travel']) + dot + sentence.get_random_train_problem() + dot
        return work_day_diary
    else:
        return "我今天不上班，因为这是一个周末。"
