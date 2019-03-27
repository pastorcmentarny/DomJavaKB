#!/usr/bin/env python
# -*- coding: utf-8 -*-
import datetime
import chinese_number

def get_current_time_in_chinese() -> str:
    date = datetime.datetime.now()
    return get_time_in_chinese_for(date.hour,date.minute)


def get_time_in_chinese_for(hour: int, minute: int) -> str:
    time_in_chinese = chinese_number.get_chinese_number(hour) +  ":"
    if(minute == 15):
        time_in_chinese += '一刻'
    elif(minute == 30):
        time_in_chinese += '半'
    elif(minute == 45):
        time_in_chinese += '三刻'
    else:
        time_in_chinese += chinese_number.get_chinese_number(minute)
    return time_in_chinese


def get_time_in_chinese(time):
    result = ''
    print(time)
    splited_time = time.split('.')
    result += chinese_number.get_chinese_number(int(splited_time[0]))
    return result
