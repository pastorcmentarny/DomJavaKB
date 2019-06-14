#!/usr/bin/env python
# -*- coding: utf-8 -*-

import config
import engine

# it used to generate random note entry and for practice chinese
#TODO check and fix settings
#TODO settings should be loaded from file
# SETTINGS:
weather_rating = config.rating['so-so']
weather_description_1 = config.weather['rain']
weather_description_2 = config.weather['windy']
upper_wear_color = config.color['green']
upper_wear_type = config.wear['t-shirt']
lower_wear_color = config.color['grey']
lower_wear_type = config.wear['jeans']
steps = 8700
time = ''  # ''15.15'
run_distance = 0  # meters
run_time = 0 # 36 * 60 + 45  # seconds
meal = ''
yesterday_diary = True
with_random_sentences = True
is_a_for_online = True
health = config.health['sleepy']
entry = 389 # add auto update file
# END OF SETTINGS

engine.generate_info_about_today(weather_rating,
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
                                 entry,
                                 is_a_for_online
                                 )
