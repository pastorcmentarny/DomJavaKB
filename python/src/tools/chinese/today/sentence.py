import datetime
import random

from tools.chinese.today import application_utils, chinese_number, config, file_loader

dot = file_loader.config()['dot']
next_line = '\n'
date = datetime.datetime.now()
year = application_utils.get_year_in_chinese()


def add_today_date() -> str:
    chinese_month = chinese_number.get_chinese_number(date.month)
    chinese_day = chinese_number.get_chinese_number(date.day)
    chinese_day_of_the_week = chinese_number.get_day_of_the_week_number(date.weekday() + 1)
    return '今天是' + year + '年' + chinese_month + '月' + chinese_day + '日,星期' + chinese_day_of_the_week + dot


def add_weather_sentence(weather_description_1, weather_description_2, weather_rating):
    weather = '伦敦的天气' + weather_rating + '.这是' + weather_description_1
    if weather_description_2 is not '':
        weather += '和' + weather_description_2
    return weather + dot + '今天气温是' + application_utils.get_temp_from_internet() + dot


def add_wear(upper_wear_color_1, upper_wear_color_2, upper_wear_type_1, upper_wear_type_2):
    return '我穿' + upper_wear_color_1 + upper_wear_type_1 + '和' + upper_wear_color_2 + upper_wear_type_2 + dot


# TODO add random time to go to sleep between 22 and midnight
def go_to_sleep() -> str:
    return "我在十一点去了睡觉" + dot


def steps(steps: int) -> str:
    return '我走了' + str(steps) + '步相当于' + application_utils.get_distance_from_steps(steps) + '公里左右' + dot


def generate_random_sentence(with_random_sentence):
    today_info = next_line
    if with_random_sentence:
        for i in range(0, 3):
            today_info += config.sentences[random.randint(0, application_utils.get_last_element())] + next_line
    return today_info
