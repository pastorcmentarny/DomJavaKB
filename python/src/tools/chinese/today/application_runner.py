#!/usr/bin/env python
# -*- coding: utf-8 -*-

import config
import engine

# it used to generate random note entry and for practice chinese

# SETTINGS:
weather_rating = config.rating['excellent']
weather_description_1 = config.weather['sunny']
weather_description_2 = ''  # config.weather['cold']
upper_wear_color = config.color['grey']
upper_wear_type = config.wear['t-shirt']
lower_wear_color = config.color['black']
lower_wear_type = config.wear['jeans']
steps = 11200
time = ''  # ''15.15'
run_distance = 5010  # meters
run_time = 43 * 60 + 22  # seconds
meal = '' # '[config.dish['cheeseburger'], config.dish['hamburger']]
yesterday_diary = True
with_random_sentences = True
is_a_for_online = True
health = config.health['good']
entry = 382
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
