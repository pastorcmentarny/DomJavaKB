#!/usr/bin/env python
# -*- coding: utf-8 -*-
import datetime
import pyperclip

from src.tools.chinese.today import activities, chinese_number, sentence, application_utils

EMPTY = ''

date = datetime.datetime.now()

dot = '。\n'
day = {
    'monday': 0,
    'tuesday': 1,
    'wednesday': 2,
    'thursday': 3,
    'friday': 4,
    'saturday': 5,
    'sunday': 6
}


def generate_info_about_today(diary: dict):
    diary_day = get_entry_number(diary['entry'])

    diary_day = add_if_is_for_yesterday(diary, diary_day)

    diary_day += sentence.add_today_date()

    diary_day += add_time_of_write(diary['time'])

    diary_day += sentence.add_weather_sentence(diary['weather_description_1'], diary['weather_description_2'],
                                               diary['weather_rating'])

    diary_day += activities.add_wake_up_time()
    diary_day += activities.run_sentence(diary)

    diary_day += activities.add_breakfast(diary)
    diary_day += activities.add_work_day(diary)
    diary_day += activities.add_random_evening_activity()
    diary_day += activities.add_dinner()
    diary_day += sentence.go_to_sleep()

    diary_day += sentence.steps(diary['steps'])
    diary_day += sentence.add_wear(diary['upper_wear_color'], diary['lower_wear_color'], diary['upper_wear_type'],
                                   diary['lower_wear_type'])
    diary_day += sentence.generate_random_sentence(diary['with_random_sentences'])

    diary_day = add_if_is_for_online(diary_day, diary['is_a_for_online'])

    print(diary_day)
    pyperclip.copy(diary_day)  # copy to clipboard
    application_utils.store_to_file(diary_day)


def add_if_is_for_yesterday(diary, diary_day):
    if diary['yesterday_diary']:
        diary_day += '这是昨天的日记' + dot
    return diary_day


def add_if_is_for_online(diary, is_a_for_online):
    if is_a_for_online:
        diary += '\n谢谢你更正我所有的错' + dot
    return diary


def add_time_of_write(diary_time: str) -> str:
    time_sentence = '时间是'
    if diary_time == EMPTY:
        time_sentence += str(date.hour) + ':'
        if date.minute < 10:
            time_sentence += '0' + str(date.minute)
        else:
            time_sentence += str(date.minute)
        return time_sentence + dot
    else:
        return time_sentence + diary_time + dot


def get_entry_number(entry: int) -> str:
    if entry != 0:
        return "Dom's entry: " + chinese_number.get_chinese_number_for(entry) + dot
    else:
        return EMPTY
