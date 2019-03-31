#!/usr/bin/env python
# -*- coding: utf-8 -*-
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

def get_chinese_number(num):
    numbers = ['零', '一', '二', '三', '四', '五', '六', '七', '八', '九', '十',
               '十一', '十二', '十三', '十四', '十五', '十六', '十七', '十八', '十九', '二十',
               '二十一', '二十二', '二十三', '二十四', '二十五', '二十六', '二十七', '二十八', '二十九', '三十',
               '三十一', '三十二', '三十三', '三十四', '三十五', '三十六', '三十七', '三十八', '三十九', '四十',
               '四十一', '四十二', '四十三', '四十四', '四十五', '四十六', '四十七', '四十八', '四十九', '五十',
               '五十一', '五十二', '五十三', '五十四', '五十五', '五十六', '五十七', '五十八', '五十九',
               ]
    return numbers[num]