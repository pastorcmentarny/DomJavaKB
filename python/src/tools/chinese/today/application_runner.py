import generator

# SETTINGS:
weather_rating = generator.rating_options['not good']
weather_description_1 = generator.weather_option['rain']
weather_description_2 = generator.weather_option['windy']
upper_wear_color_1 = generator.color_options['black']
upper_wear_type_1 = generator.wear_option['t-shirt']
upper_wear_color_2 = generator.color_options['blue']
upper_wear_type_2 = generator.wear_option['jeans']
steps = 14230
time = '7.00'
run_distance = 0  # meters
run_time = 0  # seconds
meal = [generator.food_option['beef'], generator.food_option['potato']]
yesterday_diary = True
with_random_sentences = False
entry = 372
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
