# I use this to test TDD in each language
# OEM
# AAABB-OEM-CCCCCCC-DDDDD
# A - first 3 digit represent day of the year (1-366)
# B - next 2 is a year (82-20) - offical version was different
# C - next 7 digit must start with zero and don't end with 7 and sum must be div by 7
# D - last 5 digit do not matter
# Bonus rule 366 is valid only for leap year
from src.utils import collection_utils


def is_leap_year(year: str):
    if (year % 4 != 0):
        return False
    elif (year % 100 != 0):
        return True
    else:
        return year % 400 == 0;


def is_key_valid(key: str) -> bool:
    if not key:
        print('no key or empty')
        return False
    section = key.split('-')

    dayyear = section[0]
    try:
        int(dayyear)
    except ValueError:
        print('day-year contains non numeric value')
        return False
    if len(dayyear) != 5:
        return False
    day = int(dayyear[0:3])

    if day > 366 or day < 1:
        print('day is wrong')
        return False

    year = int(dayyear[3:5])
    print(year)
    if not (year > 82 or year <= 20) and 100 > year >= 0:
        print('year is wrong {}'.format(year))
        return False

    oem = section[1]
    if 'OEM' != oem:
        print('Should be OEM but was : {}'.format(oem))
        return False

    number = section[2]

    list_of_digits = collection_utils.split_string_to_list_of_single_digit(number)
    print(len(list_of_digits))

    if list_of_digits[0] != 0 or list_of_digits[6] == 7:
        print('first or last number is wrong '.format(list_of_digits))
        return False

    return True
