# I use this to test TDD in each language
# OEM
# AAABB-OEM-CCCCCCC-DDDDD
# A - first 3 digit represent day of the year (1-366)
# B - next 2 is a year (82-20) - offical version was different
# C - next 7 digit must start with zero and don't end with 7 and sum must be div by 7
# D - last 5 digit do not matter
# Bonus rule 366 is valid only for leap year
from src.utils import collection_utils


# move to
def is_leap_year_for_years_between_1982_2040(year: int):
    return year % 4 == 0


def is_key_valid(key: str) -> bool:
    if not key:
        print('no key or empty')
        return False
    section = key.split('-')
    sections = len(section)
    if sections != 4:
        if sections > 4:
            print('too many sections')
            return False
        else:
            print('too few sections')
            return False

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

    if day == 366 and not is_leap_year_for_years_between_1982_2040(year):
        print('invalid day for non leap year' + str(day) + ' ' + str(year))
        return False



    oem = section[1]
    if 'OEM' != oem:
        print('Should be OEM but was : {}'.format(oem))
        return False

    number = section[2]
    if not number.isnumeric():
        print('non numeric character in 3rd section (division by 7)')
        return False

    list_of_digits = collection_utils.split_string_to_list_of_single_digit(number)
    print(len(list_of_digits))

    if list_of_digits[0] != 0 or list_of_digits[6] == 7:
        print('first or last number is wrong '.format(list_of_digits))
        return False

    last_section = section[3]
    if len(last_section) > 5:
        print('too many characters in last section')
        return False
    elif len(last_section) < 5:
        print('not enough characters in last section')
        return False
    elif not last_section.isnumeric():
        print('non numeric character in last section')
        return False

    return True
