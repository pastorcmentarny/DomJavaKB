#!/usr/bin/env python
# -*- coding: utf-8 -*-

import generator
import config

# SETTINGS:
weather_rating = config.rating['good']
weather_description_1 = config.weather['cloudy']
weather_description_2 = ''  # + config.weather['windy']
upper_wear_color = config.color['green']
upper_wear_type = config.wear['t-shirt']
lower_wear_color = config.color['grey']
lower_wear_type = config.wear['jeans']
steps = 11080
time = '8.30'
run_distance = 2500  # meters
run_time = 22*60+27  # seconds
#//FIXME need fix it: meal = [config.dish['sweet and sour pork']] #, config.food['fries']] # set to meal = []  to generate random meal sentence
meal = []
yesterday_diary = False
with_random_sentences = False
entry = 379
# END OF SETTINGS

generator.generate_info_about_today(weather_rating,
                                    weather_description_1,
                                    weather_description_2,
                                    steps,
                                    upper_wear_color,
                                    upper_wear_type,
                                    lower_wear_color,
                                    lower_wear_type,
                                    time,
                                    meal,
                                    yesterday_diary,
                                    run_distance,
                                    run_time,
                                    with_random_sentences,
                                    entry
                                    )
