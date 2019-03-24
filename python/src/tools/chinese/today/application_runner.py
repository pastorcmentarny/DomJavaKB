#!/usr/bin/env python
# -*- coding: utf-8 -*-

import generator
import config

# SETTINGS:
weather_rating = config.rating['so-so']
weather_description_1 = config.weather['cloudy']
weather_description_2 = '' + config.weather['windy']
upper_wear_color_1 = config.color['black']
upper_wear_type_1 = config.wear['t-shirt']
upper_wear_color_2 = config.color['grey']
upper_wear_type_2 = config.wear['jeans']
steps = 11080
time = '8.00'
run_distance = 0  # meters
run_time = 0  # seconds
#//FIXME need fix it: meal = [config.dish['sweet and sour pork']] #, config.food['fries']] # set to meal = []  to generate random meal sentence
meal = []
yesterday_diary = False
with_random_sentences = False
entry = 377
# END OF SETTINGS

generator.generate_info_about_today(weather_rating,
                                    weather_description_1,
                                    weather_description_2,
                                    steps,
                                    upper_wear_color_1,
                                    upper_wear_type_1,
                                    upper_wear_color_2,
                                    upper_wear_type_2,
                                    time,
                                    meal,
                                    yesterday_diary,
                                    run_distance,
                                    run_time,
                                    with_random_sentences,
                                    entry
                                    )
