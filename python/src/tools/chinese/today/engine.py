#!/usr/bin/env python
# -*- coding: utf-8 -*-
import bs4
import chinese_number
import chinese_time
import chinese_utils
import config
import data_generator
import datetime
import pyperclip
import random
import requests

date = datetime.datetime.now()

dot = '。\n'
next_line = '\n'
monday = 0
tuesday = 1
wednesday = 2
friday = 4
saturday = 5
sunday = 6


def get_year_in_chinese():
    year_in_chinese = ''
    for i in list(str(date.year)):
        year_in_chinese += chinese_number.get_chinese_number(int(i))
    return year_in_chinese


year = get_year_in_chinese()


def get_distance_from_steps(steps_counter):
    return str(round(steps_counter / 1225, 2))


def generate_info_about_today(weather_rating,
                              weather_description_1, weather_description_2,
                              steps,
                              upper_wear_color_1, upper_wear_type_1,
                              upper_wear_color_2, upper_wear_type_2,
                              time, meal: list,
                              yesterday_diary,
                              run_distance: int = 0,
                              run_time: int = 0,
                              with_random_sentences: bool = True,
                              entry: int = 0,
                              is_a_for_online: bool = True
                              ):
    today_info = get_entry_number(entry)

    if yesterday_diary:
        today_info += '这是昨天的日记' + dot

    today_info += add_today_date()

    today_info += add_time_of_write(time)

    today_info += add_weather_sentence(weather_description_1, weather_description_2, weather_rating)

    today_info += add_wear(upper_wear_color_1, upper_wear_color_2, upper_wear_type_1, upper_wear_type_2)

    today_info += get_daily_activity_for(weather_description_1, weather_description_2, meal, steps)

    today_info += '我在晚上' + data_generator.generate_random_non_alkocholic_drink()

    today_info += run_sentence(run_distance, run_time)

    today_info += "我在十一点去了睡觉" + dot  # go to sleep

    today_info += generate_random_sentence(with_random_sentences)

    if is_a_for_online:
        today_info += '\n\n谢谢你更正我所有的错' + dot

    print(today_info)
    pyperclip.copy(today_info)  # copy to clipboard


def add_wear(upper_wear_color_1, upper_wear_color_2, upper_wear_type_1, upper_wear_type_2):
    return '我穿' + upper_wear_color_1 + upper_wear_type_1 + '和' + upper_wear_color_2 + upper_wear_type_2 + dot


def get_temp_from_internet():
    response = requests.get('http://www.google.co.uk/search?q=rickmansworth+weather')
    temp = ''
    try:
        response.raise_for_status()  # without try it will exit program
        html_manager = bs4.BeautifulSoup(response.text, "html.parser")
        response = html_manager.select('.wob_t')
        temp = response[0].get_text()

    except Exception as whoops:
        print('There was a problem: %s' % whoops)
    return temp


def get_distance_from_run(run_distance):
    return str('{:.1f}'.format(run_distance / 1000))


def get_time_from_run(run_time):
    minut_in_seconds = 60
    minuts = run_time // minut_in_seconds
    seconds = run_time % minut_in_seconds
    return str(minuts) + '分' + str(seconds) + '秒'


def generate_meal(meals: list) -> str:
    return random.generate_sentence_from_multi_words(meals)


def add_meal_sentence(meal: list) -> str:
    if len(meal) == 0:
        return get_random_meal()
    else:
        return generate_meal(meal)


def add_time_of_write(time) -> str:
    sentence = '时间是'
    if time == '':
        sentence += str(date.hour) + ':'
        if date.minute < 10:
            sentence += '0' + str(date.minute)
        else:
            sentence += str(date.minute)
    else:
        sentence = ''
    return sentence + dot


def add_today_date() -> str:
    chinese_month = chinese_number.get_chinese_number(date.month)
    chinese_day = chinese_number.get_chinese_number(date.day)
    chinese_day_of_the_week = chinese_number.get_chinese_number(date.weekday() + 1)
    return '今天是' + year + '年' + chinese_month + '月' + chinese_day + '日,星期' + chinese_day_of_the_week + dot


def add_weather_sentence(weather_description_1, weather_description_2, weather_rating):
    weather = '伦敦的天气' + weather_rating + '.这是' + weather_description_1
    if weather_description_2 is not '':
        weather += '和' + weather_description_2
    return weather + dot + '今天气温是' + get_temp_from_internet() + dot


def generate_random_sentence(with_random_sentence):
    today_info = next_line
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


def get_entry_number(entry: int) -> str:
    if entry != 0:
        return "Dom's entry: " + chinese_number.get_chinese_number_for(entry) + dot
    else:
        return ''


def get_random_meal():
    meal = "我吃了"
    meal += config.main_food[random.randint(0, len(config.main_food) - 1)]
    meal += config.type_food[random.randint(0, len(config.type_food) - 1)]
    return meal + dot


def thursday() -> int:
    return 4


def friday() -> int:
    return 5


def generate_weekend_activity():
    return chinese_utils.get_random_value_from(config.weekend_activity)


def get_daily_activity_for(weather_description_1, weather_description_2, meal, steps):
    day_of_the_week = date.weekday()

    day = ''
    hour = 0
    minute = 0
    breakfast = ''
    go_to_work = ''
    sleep_time = [0, 0]

    if day_of_the_week in range(monday, thursday()):
        hour = 6
        minute = 15
        breakfast = "我没有吃了早饭但是我喝了咖啡"
    elif day_of_the_week == friday:
        hour = 7
        minute = 30
        breakfast = "我没有吃早饭了"
    elif day_of_the_week == saturday or day_of_the_week == sunday:
        hour = 8
        minute = 45
        breakfast = "我在早饭吃了" + config.breakfast['british']

    day += "我早上" + chinese_time.get_time_in_chinese_for(hour, minute) + "起床" + dot  # woke up time
    day += breakfast + dot

    if day_of_the_week in range(monday, friday()):
        day += generate_lunch_walk(weather_description_1, weather_description_2) + dot
        day += data_generator.generate_random_lunch_break_activity()
        day += data_generator.generate__full_meal()
        day += "我在工作忙了" + dot  # day at work
        day += '我六点五分回到家' + dot  # back to home
    else:
        day += generate_weekend_activity() + dot

    # evening activity
    day += add_meal_sentence(meal)
    day += '我走了' + str(steps) + '步相当于' + get_distance_from_steps(steps) + '公里左右' + dot

    # dinner
    return day


def generate_lunch_walk(weather_description_1, weather_description_2) -> str:
    if weather_description_1 == '雨' or weather_description_2 == '雨':
        return "因为正在下雨，我没有在午休时散步"  # I didn't go for a walk at lunch break as it was raining.
    else:
        walk = get_distance_from_run(random.randint(1000, 4501))
        return "我午休时走了" + walk + "公里"


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
