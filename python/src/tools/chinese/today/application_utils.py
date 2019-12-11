import datetime
import random

import bs4
import chinese_number
import config
import requests

date = datetime.datetime.now()


def get_random_value_from(value: list):
    return value[random.randint(0, len(value) - 1)]


def generate_sentence_from_multi_words(words: list) -> str:
    if len(words) == 1:
        return words[0]
    elif len(words) == 2:
        return words[0] + '和' + words[1]
    else:
        sentence = ''
        length = len(words)
        for idx, word in enumerate(words):
            if idx + 1 == length:
                sentence += '和' + word
            else:
                sentence += word


def get_distance_from_steps(steps_counter):
    return str(round(steps_counter / 1225, 2))


def get_distance_from_run(run_distance):
    return str('{:.1f}'.format(run_distance / 1000))


def get_temp_from_internet():
    response = requests.get('https://www.bing.com/search?q=weather+rickmansworth')
    temp = ''
    try:
        response.raise_for_status()  # without try it will exit program
        html_manager = bs4.BeautifulSoup(response.text, "html.parser")
        response = html_manager.select('.wtr_currTemp')
        temp = response[0].get_text()
        sep = '°C'
        temp = temp.split(sep, 1)[0] + sep

    except Exception as whoops:
        print('Unable to get weather temperature due to : %s' % whoops)
    return temp


def get_time_from_run(run_time):
    minut_in_seconds = 60
    minuts = run_time // minut_in_seconds
    seconds = run_time % minut_in_seconds
    return str(minuts) + '分' + str(seconds) + '秒'


def get_last_element():
    return len(config.sentences) - 1


def get_year_in_chinese():
    year_in_chinese = ''
    for i in list(str(date.year)):
        year_in_chinese += chinese_number.get_chinese_number(int(i))
    return year_in_chinese