#!/usr/bin/env python
# -*- coding: utf-8 -*-
import datetime
import random

from src.tools.chinese.today import chinese_number


def get_current_time_in_chinese() -> str:
    date = datetime.datetime.now()
    return get_time_in_chinese_for(date.hour, date.minute)


def get_time_in_chinese_for(hour: int, minute: int) -> str:
    time_in_chinese = chinese_number.get_chinese_number(hour) + "点"
    if minute == 0:
        time_in_chinese += ''
    if minute == 15:
        time_in_chinese += '一刻'
    elif minute == 30:
        time_in_chinese += '半'
    elif minute == 45:
        time_in_chinese += '三刻'
    else:
        time_in_chinese += chinese_number.get_chinese_number(minute)
    return time_in_chinese


def get_random_sleep_time():
    typical_sleep_time = [get_time_in_chinese_for(22, 30), get_time_in_chinese_for(22, 45),
                          get_time_in_chinese_for(23, 0), get_time_in_chinese_for(23, 15), '半夜']
    return typical_sleep_time[random.randint(0, len(typical_sleep_time) - 1)]
