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


# need to change it
def is_weekend(day_of_week: int = datetime.now().weekday()) -> bool:
    return day_of_week > 4  # 5 is a Friday and 6 is a Sunday


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


def add_wake_up_time():
    hour = 0
    minute = 0
    if is_weekend():
        hour = random.randint(6, 9)
        minute = random.randint(0, 59)
    else:
        hour = 6
        minute = random.randint(0, 22)

    return "我早上" + chinese_time.get_time_in_chinese_for(hour, minute) + "起床" + dot  # woke up time


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


def add_meal_sentence(meal=None) -> str:
    if meal is None:
        meal = []
    if bool(meal):
        return food_generator.generate_meal(meal)
    else:
        return food_generator.get_random_meal()


def run_sentence(diary: dict):
    run_distance = diary['run_distance']
    run_time = diary['run_time']
    if run_distance > 0 and run_time > 0:
        return '我在早上去了慢跑。我跑了' + get_distance_from_run(
            run_distance) + '公里。跑了这个距离花了我' + application_utils.get_time_from_run(run_time) + dot
    else:
        return f'我在早上没去了慢跑{dot}'


def add_breakfast(diary: dict):
    if diary['diet']:
        breakfast = ''
        if bool(random.getrandbits(1)):
            breakfast += '我正在间歇性禁食.'
        return f"{breakfast}我没有吃了早饭但是我喝了咖啡{dot}"
    breakfast_options = ['coffee', 'kefir', 'british', 'sandwich']
    return food_generator.breakfast[breakfast_options[random.randint(0, len(breakfast_options) - 1)]]


def add_random_reason_to_like_wfh():
    if random.randint(0, 100) > 90:
        return ''
    reason = '我喜欢在家工作，因为 '
    reasons = [
        '我不需要出差上班。 ',  # I don't need to travel to work.
        '我讨厌办公室的空调。',  # I hate air-conditioning at the office.
        '市中心的午餐太贵了。 ',  # Lunch is too expensive in the city centre.
        '在家里，我的办公桌看起来就像我想要的那样。',

    ]
    return f'{reason} {reasons[random.randint(0, len(reasons) - 1)]} {dot}'


busy_work = ['I had a lot of tasks to do',
             'I had a lot of meetings']

not_busy_work = ['I had a lot of boring meetings.',
                 "I didn't do anything meaningful."]

weekend_activities = ['我去树林里散步',
                      '我爬山',
                      '我去了一次风景优美的火车旅行',
                      '我骑自行车',
                      '我更新了我的待办事项清单',
                      '我从不同的国家做饭',
                      '我在网上和朋友聊天',
                      '我有一个放松的泡泡浴',
                      '我们玩了一个棋盘游戏',
                      '我读了一本书',
                      '我去散步了',
                      '我去远足了',
                      '我们去了餐厅',
                      '我和我儿子一起玩']


def add_work_day(diary: dict):
    work_day_diary = ''
    if not is_weekend(datetime.now().weekday()):
        if diary['wfh']:
            work_day_diary += '我在家工作.'
            if bool(random.getrandbits(1)):
                work_day_diary += '我没有乘坐地铁。'
            work_day_diary += add_random_reason_to_like_wfh()
        else:
            work_day_diary += '我在办公室上班.'
            if diary['travel'] == '':
                work_day_diary += '这次旅行很顺利。'  # 'The travel was uneventful.'
            else:
                work_day_diary += '火车已' + sentence.get_travel_experience_for(
                    diary['travel']) + dot + sentence.get_random_train_problem() + dot
        work_business_level = ['不', '', '很']
        level = work_business_level[random.randint(0, len(work_business_level) - 1)]
        work_day_diary = f'我工作{level}忙。'
        if level == '不':
            work_day_diary += not_busy_work[random.randint(0, len(not_busy_work) - 1)] + dot
        else:
            work_day_diary += busy_work[random.randint(0, len(busy_work) - 1)] + dot
        return work_day_diary
    else:
        return f"我今天不上班，因为这是一个周末。{weekend_activities[random.randint(0, len(weekend_activities) - 1)] + dot}"


def add_random_evening_activity() -> str:
    if random.randint(0, 100) > 80:
        return '我下午什么都没做。'
    reason = '在下午,'
    reasons = [
        '我从托儿所接我的儿子',  # I picked up my son from nursery.
        '我去散步了',  # I went for a walk.
        '我去买菜了',  # I went food shopping.
        '我打扫了办公室',  # I cleaned an office.
        '我玩了一个游戏',  # I played a game.
        '我准备了晚餐',  # I prepared dinner.
        '我和我的妻子和儿子一起玩棋盘游戏',  # I played Play board games with my wife and son.
        '我在酒吧里遇到了我的朋友喝啤酒',  # I met my friend in the pub for a beer.
        '我去骑滑板车了',  # I went on a scooter ride.
        '我洗了一个很长很长的热水澡',  # I had a long, hot bath.
        '我和儿子玩乐高',  # I played Lego with my son.
        '我和我的妻子谈论假期计划',  # I chat with my wife about holiday plans.
    ]
    return f'{reason} {reasons[random.randint(0, len(reasons) - 1)]} {dot}'


def add_dinner():
    return f'我在晚饭{add_meal_sentence()}'


if __name__ == '__main__':
    print(add_random_evening_activity())
