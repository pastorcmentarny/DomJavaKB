#!/usr/bin/env python
# -*- coding: utf-8 -*-

import config
import engine

# it used to generate random note entry and for practice chinese

# SETTINGS:
weather_rating = config.rating['so-so']
weather_description_1 = config.weather['cloudy']
weather_description_2 = config.weather['windy']
upper_wear_color = config.color['black']
upper_wear_type = config.wear['t-shirt']
lower_wear_color = config.color['brown']
lower_wear_type = config.wear['jeans']
steps = 15800
time = ''  # ''15.15'
run_distance = 4100  # meters
run_time = 36 * 60 + 45  # seconds
meal = ''  # '[config.dish['cheeseburger'], config.dish['hamburger']]
yesterday_diary = True
with_random_sentences = True
is_a_for_online = True
health = config.health['good']
entry = 387
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
