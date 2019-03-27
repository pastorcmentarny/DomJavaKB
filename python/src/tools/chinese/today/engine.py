#!/usr/bin/env python
# -*- coding: utf-8 -*-
import datetime
import random

import bs4
import pyperclip
import requests
import config
import data_generator

date = datetime.datetime.now()

dot = '。\n'
next_line = '\n'


def get_chinese_number(num):
    numbers = ['零', '一', '二', '三', '四', '五', '六', '七', '八', '九', '十',
               '十一', '十二', '十三', '十四', '十五', '十六', '十七', '十八', '十九', '二十',
               '二十一', '二十二', '二十三', '二十四', '二十五', '二十六', '二十七', '二十八', '二十九', '三十',
               '三十一'
               ]
    return numbers[num]


def get_distance_from_steps(steps_counter):
    return str(round(steps_counter / 1225, 2))


def get_temp_from_internet():
    response = requests.get('http://www.google.co.uk/search?q=rickmansworth+weather')
    temp = ''
    try:
        response.raise_for_status()  # without try it will exit program
        html_manager = bs4.BeautifulSoup(response.text, "html.parser")
        response = html_manager.select('.wob_t')
        temp = response[0].get_text()

    except Exception as whoops:
        print('There was a problem: %s' % (whoops))
    return temp


def get_time_in_chinese(time):
    result = ''
    print(time)
    splited_time = time.split('.')
    result += get_chinese_number(int(splited_time[0]))

    return result


'''
    print()  # I woke up/went to sleep at [time]
    print()  # For breakast/lunch/dinner I ate (meat + filling ) and drink (beer,tea,coffee,wine)
'''


def get_text_based_on_time(time, meal):
    day_info = ''
    if time > 17:
        day_info += ''
        # went to sleep at 我在凌晨一点一分睡觉。
        # back from work at
        # ate at dinner
    elif time > 12:
        day_info += ''
        # woke up
        # went to work at
        # ate at lunch
    else:
        day_info += ''
        # woke up
        # ate at breakfast
    return day_info


year = ''

for i in list(str(date.year)):
    year += get_chinese_number(int(i))


def get_distance_from_run(run_distance):
    return str('{:.1f}'.format(run_distance / 1000))


def get_time_from_run(run_time):
    minut_in_seconds = 60
    minuts = run_time // minut_in_seconds
    seconds = run_time % minut_in_seconds
    return str(minuts) + '分' + str(seconds) + '秒'


def generate_meal(meals: list):
    meals_setnece = ''
    for meal in meals:
        meals_setnece += config.main_food[meal]


def add_meal_sentence(meal):
    #  today_info += get_text_based_on_time(time,meal)
    if len(meal) == 0:
        return get_random_meal()
    else:
        return generate_meal(meal)



def generate_info_about_today(weather_rating,
                              weather_description_1, weather_description_2,
                              steps,
                              upper_wear_color_1, upper_wear_type_1,
                              upper_wear_color_2, upper_wear_type_2,
                              time, meal: list,
                              yesterday_diary,
                              run_distance,
                              run_time,
                              with_random_sentences: bool = True,
                              entry: int = 0,
                              is_a_for_online: bool = True
                              ):

    today_info = get_entry_number(entry)

    today_info = add_today_date(today_info)

    if yesterday_diary:
        today_info += '这是昨天的日记。'

    today_info = add_weather_sentence(today_info, weather_description_1, weather_description_2, weather_rating)

    today_info += add_meal_sentence(meal)

    today_info += '我穿' + upper_wear_color_1 + upper_wear_type_1 + '和' + upper_wear_color_2 + upper_wear_type_2 + dot

    today_info += '我走了' + str(steps) + '步相当于' + get_distance_from_steps(steps) + '公里左右' + dot

    today_info += run_sentence(run_distance, run_time)

    today_info += generate_random_sentence(with_random_sentences)

    today_info += '我在晚上' + data_generator.generate_random_non_alkocholic_drink()
    if is_a_for_online:
        today_info += '谢谢你更正我所有的错' + dot

    print(today_info)
    pyperclip.copy(today_info)  # copy to clipboard


def add_today_date(today_info):
    chinese_month = get_chinese_number(date.month)
    chinese_day = get_chinese_number(date.day)
    chinese_day_of_the_week = get_chinese_number(date.weekday() + 1)
    today_info += '今天是' + year + '年' + chinese_month + '月' + chinese_day + '日,星期' + chinese_day_of_the_week + dot
    return today_info


def add_weather_sentence(today_info, weather_description_1, weather_description_2, weather_rating):
    today_info += '伦敦的天气' + weather_rating + '.这是' + weather_description_1
    if weather_description_2 is not '':
        today_info += '和' + weather_description_2
    today_info += dot + '今天气温是' + get_temp_from_internet() + dot
    return today_info


def generate_random_sentence(with_random_sentence):
    today_info = ''
    if with_random_sentence:
        for i in range(0, 3):
            today_info += config.sentences[random.randint(0, get_last_element())] + next_line
    return today_info


def get_last_element():
    return len(config.sentences) - 1


def run_sentence(run_distance, run_time):
    if run_distance > 0 and run_time > 0:
        return '我在晚上去了慢跑。我跑了' + get_distance_from_run(run_distance) + '公里。跑了这个距离花了我' + get_time_from_run(run_time) + dot
    else:
        return ''


def get_chinese_number_for(entry):
    number = ''
    thousands = entry // 1000
    if thousands > 0:
        number += get_chinese_number(thousands) + '千'

    entry = entry % 1000
    hundreds = entry // 100

    if hundreds > 0:
        number += get_chinese_number(hundreds) + '百'

    entry = entry % 100
    tens = entry // 10

    if tens > 0:
        number += get_chinese_number(tens) + '十'

    ones = entry % 10

    if ones > 0:
        number += get_chinese_number(ones)

    return number


def get_entry_number(entry: int) -> str:
    if entry != 0:
        return "Dom's entry: " + get_chinese_number_for(entry) + dot
    else:
        return ''


def get_random_meal():
    meal = "我吃了"
    meal += config.main_food[random.randint(0, len(config.main_food) - 1)]
    meal += config.type_food[random.randint(0, len(config.type_food) - 1)]
    return meal + dot

'''
今天早上七点整起床。
我在早饭喝了咖啡。
我在七点半去了通过地铁上班。
我在午饭吃了意大利的三明治。
我在工作忙了。
我六点五分回到家
我在晚饭吃了蔬菜和蘑菇。
我在晚上去了慢跑。我做了2.1公里。
跑了这个距离花了我24分15秒。
我在十一点去了睡觉。
'''
def get_daily_activity_for(day: str):
    pass
    # woke up time
    # go to work
    # lunch


def generate_lunch_walk(weather_description_1, weather_description_2) -> str:
    if weather_description_1 == '雨' or weather_description_2 == '雨':
        return "因为正在下雨，我没有在午休时散步。"  # I didn't go for a walk at lunch break as it was raining.
    else:
        walk = get_distance_from_run(random.randint(1000,4501))
        return "我午休时走了" + walk + "公里。"
'''
lunch break options
因为正在下雨，我没有在午休时散步。
我午休时走了3公里。
我感觉不舒服，所以我在午休期间待在办公室。

I didn't go for a walk at lunch break as it was raining.
I walked 3 km at lunch break.
I don't feel very well, so I stay in the office during lunch break.
'''
