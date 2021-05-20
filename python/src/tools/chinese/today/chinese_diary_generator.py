# -*- coding: utf-8 -*-
from src.tools.chinese.today import diary_generator, config, file_loader


def main():
    diary_file = file_loader.config()
    diary = {
        'weather_rating': config.rating[diary_file['weather_rating']],
        'weather_description_1': config.weather[diary_file['weather_description_1']],
        'weather_description_2': config.weather[diary_file['weather_description_2']],
        'upper_wear_color': config.color[diary_file['upper_wear_color']],
        'upper_wear_type': config.wear[diary_file['upper_wear_type']],
        'lower_wear_color': config.color[diary_file['lower_wear_color']],
        'lower_wear_type': config.wear[diary_file['lower_wear_type']],
        'steps': diary_file['steps'],
        'time': diary_file['time'], #   You can set manually"time": "10:00",
        'run_distance': diary_file['run_distance'],
        'run_time': diary_file['run_time'],
        'meal': diary_file['meal'],
        'yesterday_diary': diary_file['yesterday_diary'],
        'with_random_sentences': diary_file['with_random_sentences'],
        'is_a_for_online': diary_file['is_a_for_online'],
        'health': diary_file['health'],
        'entry': diary_file['entry']
    }
    diary_generator.generate_info_about_today(diary)


if __name__ == '__main__':
    main()
