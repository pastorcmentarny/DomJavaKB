import csv
import time
from timeit import default_timer as timer

import requests

from src.tools.lotto import config
from src.tools.lotto.utils import output

LOTTO = 'lotto'
EUROMILLIONS = 'euromillions'
HOTPICKS = 'lotto hotpics'
EUROHOTPICKS = 'euromillions hotpics'
SET_FOR_LIFE = 'set-for-life'
THUNDERBALL = 'thunderball'
EMPTY = ""
NEW_LINE = '\n'
SPACE = " "
SPLITTER = ','
WRITABLE = 'w'

WAITING_TIME = 4 * 1000
euromillions_url = 'https://www.national-lottery.co.uk/results/euromillions/draw-history/csv'
euromillions_draws_path = lotto_hotpics_history_path = config.get_project_path('euro-draws.csv')
euromillions_all_draws_path = config.get_project_path('euro-all-draws.csv')

euromillions_hotpicks_url = 'https://www.national-lottery.co.uk/results/euromillions-hotpicks/draw-history/csv'
euromillions_hotpicks_draws_path = config.get_project_path('euro-hotpics-draws.csv')
euromillions_hotpicks_all_draws_path = config.get_project_path('euro-hotpicks-all-draws.csv')

lotto_hotpicks_url = 'https://www.national-lottery.co.uk/results/lotto-hotpicks/draw-history/csv'
lotto_and_hotpics_draws_path = config.get_project_path('lotto-hotpicks-draws.csv')
lotto_and_hotpics_draws_all_draws_path = config.get_project_path('lotto-hotpicks-all-draws.csv')

set_for_life_url = f'https://www.national-lottery.co.uk/results/{SET_FOR_LIFE}/draw-history/csv'
set_for_life_draws_path = config.get_project_path(f'{SET_FOR_LIFE}-draws.csv')
set_for_life_all_draws_path = config.get_project_path(f'{SET_FOR_LIFE}-all-draws.csv')

thunderball_url = 'https://www.national-lottery.co.uk/results/thunderball/draw-history/csv'
thunderball_draws_path = thunderball_history_path = config.get_project_path('thunderball-draws.csv')
thunderball_all_draws_path = config.get_project_path('thunderball-all-draws.csv')


def download(url: str, game: str):
    print(f'Downloading draws for {game} from:{url}')
    response = requests.get(url)

    try:
        response.raise_for_status()  # without try it will exit program
    except Exception as whoops:
        print('There was a problem: %s' % whoops)

    print('Download complete with response ' + str(response.status_code))

    return response.text


def save_recent_draws_for(name: str, path, data):
    print(f'Saving recent draws for {name} to {path}')
    draw_history_file = open(path, WRITABLE)
    draw_history_file.write(data)
    draw_history_file.close()
    output.debug_print(f'File saved.')


def load_recent_draws_for(name: str, path: str) -> list:
    print(f'Loading recent draws for {name} from {path}')
    recent_draws_path = open(path)
    recent_draws_as_csv = csv.reader(recent_draws_path)
    recent_draws_as_list = list(recent_draws_as_csv)
    output.debug_print(f'File loaded.')
    return recent_draws_as_list[1:len(recent_draws_as_list)]


def get_recent_draws_for_euromillions():
    return load_recent_draws_for(EUROMILLIONS, euromillions_all_draws_path)


def get_recent_draws_for_euromillions_hotpicks():
    return load_recent_draws_for(EUROHOTPICKS, euromillions_hotpicks_draws_path)


def load_all_draws_for(name: str, path: str) -> list:
    print(f'Loading all draws for {name} from {path}')
    recent_draws_path = open(path)
    recent_draws_as_csv = csv.reader(recent_draws_path)
    recent_draws_as_list = list(recent_draws_as_csv)
    output.debug_print(f'File loaded.')
    return recent_draws_as_list[0:len(recent_draws_as_list)]


def load_all_draws_for_euromillions():
    return load_all_draws_for(EUROMILLIONS, euromillions_all_draws_path)


def load_all_draws_for_euromillions_hotpics():
    return load_all_draws_for(EUROHOTPICKS, euromillions_hotpicks_all_draws_path)


def update_file_for(file_path, all_draws_list):
    for draw in all_draws_list:
        file_path.write(SPLITTER.join(draw).replace(SPACE, EMPTY))
        file_path.write(NEW_LINE)
    return file_path


def convert_to_draw_row(draw):
    #    26-May-2018,40,14,19,29,9,39,7,Arthur,2340
    #    2335,18,25,59,30,56,21,09-May-2018
    return [draw[9],
            draw[1],
            draw[2],
            draw[3],
            draw[4],
            draw[5],
            draw[6],
            draw[0]]


def update_all_draws_for_lotto_and_hotpics():
    print('Updating draws')
    recent_draws_list = load_recent_draws_for(HOTPICKS, lotto_and_hotpics_draws_path)
    print('updating all draws if needed')
    all_draws_list = load_all_draws_for(HOTPICKS, lotto_and_hotpics_draws_all_draws_path)

    last_draw = int(all_draws_list[0][0])
    draw_to_add = []
    current_draw = int(recent_draws_list[0][9])
    counter = 0
    while last_draw != current_draw:
        draw_to_add.append(convert_to_draw_row(recent_draws_list[counter]))
        counter += 1
        current_draw = int(recent_draws_list[counter][9])

    all_draws_file = open(lotto_and_hotpics_draws_all_draws_path, WRITABLE)
    all_draws_file = update_file_for(all_draws_file, draw_to_add)
    all_draws_file = update_file_for(all_draws_file, all_draws_list)
    all_draws_file.close()
    print('Draws data updated.')


def update_lotto_and_hotpics():
    lotto_and_hotpics = f'{LOTTO} and {HOTPICKS}'
    output.debug_print(f'Updating {lotto_and_hotpics} draws and all draws')
    data = download(lotto_hotpicks_url, lotto_and_hotpics)
    save_recent_draws_for(lotto_and_hotpics, lotto_and_hotpics_draws_path, data)
    update_all_draws_for_lotto_and_hotpics()
    output.debug_print(f"{lotto_and_hotpics}'s draws and all draws updated.")


def update_all_draws_for_set_for_life(recent_draws_list, all_draws_file_path):
    print(f'Updating all draws for {SET_FOR_LIFE} (if needed)')

    last_column = len(recent_draws_list[0]) - 1
    all_draws_file = open(all_draws_file_path)
    all_draws_list = list(csv.reader(all_draws_file))

    save_all_draws_to_file_for(all_draws_list, last_column, recent_draws_list, set_for_life_all_draws_path)

    output.debug_print(f'All draws for {SET_FOR_LIFE} updated')


def update_set_for_life():
    output.debug_print(f'Updating {SET_FOR_LIFE} draws and all draws')
    data = download(set_for_life_url, SET_FOR_LIFE)
    save_recent_draws_for(SET_FOR_LIFE, set_for_life_draws_path, data)
    recent_draws = load_recent_draws_for(SET_FOR_LIFE, set_for_life_draws_path)
    update_all_draws_for_set_for_life(recent_draws, set_for_life_all_draws_path)
    output.debug_print(f"{SET_FOR_LIFE}'s draws and all draws updated.")


def update_all_draws_for_thunderball():
    output.debug_print(f'Updating all draws for {THUNDERBALL}')
    recent_draws_list = load_recent_draws_for(THUNDERBALL, thunderball_draws_path)
    last_column = len(recent_draws_list[0]) - 1

    all_draws_list = load_all_draws_for(THUNDERBALL, thunderball_all_draws_path)

    save_all_draws_to_file_for(all_draws_list, last_column, recent_draws_list, thunderball_all_draws_path)
    output.debug_print(f'All draws was updated for {THUNDERBALL}')


def save_all_draws_to_file_for(all_draws_list, last_column, recent_draws_list, all_draws_path):
    last_draw = int(all_draws_list[0][last_column])
    draw_to_add = []
    current_draw = int(recent_draws_list[0][last_column])
    counter = 0
    while last_draw != current_draw:
        draw_to_add.append(recent_draws_list[counter])
        counter += 1
        current_draw = int(recent_draws_list[counter][last_column])
    print(f'draws to add {counter}')
    all_draws_file = open(all_draws_path, WRITABLE)
    all_draws_file = update_file_for(all_draws_file, draw_to_add)
    all_draws_file = update_file_for(all_draws_file, all_draws_list)
    all_draws_file.close()


def update_thunderball():
    output.debug_print(f'Updating {THUNDERBALL} draws and all draws')
    data = download(thunderball_url, THUNDERBALL)
    save_recent_draws_for(THUNDERBALL, thunderball_draws_path, data)
    update_all_draws_for_thunderball()
    output.debug_print(f"{THUNDERBALL}'s draws and all draws updated.")


def update_all_draws_for_euromillions():
    print(f'Updating all draws for {EUROMILLIONS} (if needed)')

    recent_draws_list = load_recent_draws_for(EUROMILLIONS, euromillions_draws_path)
    cleaned_data = []
    for draw in recent_draws_list:
        draw_line = [draw[9], draw[0], draw[1], draw[2], draw[3], draw[4], draw[5], draw[6], draw[7]]
        cleaned_data.append(draw_line)
    if config.settings['debug_mode']:
        print(f'first line: {recent_draws_list[0]}')
        print(f'no. of column in first line : {len(recent_draws_list[0])}')

    all_draws_file = open(euromillions_all_draws_path)
    all_draws_list = list(csv.reader(all_draws_file))
    last_draw = int(all_draws_list[0][0])
    draw_to_add = []
    current_draw = int(cleaned_data[0][0])
    counter = 0
    while last_draw != current_draw:
        draw_to_add.append(cleaned_data[counter])
        counter += 1
        current_draw = int(cleaned_data[counter][0])

    all_draws_file = open(euromillions_all_draws_path, WRITABLE)

    all_draws_file = update_file_for(all_draws_file, draw_to_add)
    all_draws_file = update_file_for(all_draws_file, all_draws_list)
    all_draws_file.close()


def update_euromillions():
    output.debug_print(f'Updating {EUROMILLIONS} draws and all draws')
    data = download(euromillions_url, EUROMILLIONS)
    save_recent_draws_for(EUROMILLIONS, euromillions_draws_path, data)
    update_all_draws_for_euromillions()
    output.debug_print(f"{EUROMILLIONS}'s draws and all draws updated.")


def update_all_draws_for_euromillions_hotpicks():
    print(f'Updating all draws for {EUROHOTPICKS} (if needed)')
    recent_draws_list = load_recent_draws_for(EUROHOTPICKS, euromillions_hotpicks_draws_path)
    cleaned_data = []

    for draw in recent_draws_list:
        draw_line = [draw[6], draw[0], draw[1], draw[2], draw[3], draw[4], draw[5]]
        cleaned_data.append(draw_line)

    if config.settings['debug_mode']:
        print(f'first line: {recent_draws_list[0]}')
        print(f'no. of column in first line : {len(recent_draws_list[0])}')

    all_draws_list = load_all_draws_for(EUROHOTPICKS, euromillions_hotpicks_all_draws_path)

    last_draw = int(all_draws_list[0][0])
    draw_to_add = []
    current_draw = int(cleaned_data[0][0])
    counter = 0
    while last_draw != current_draw:
        draw_to_add.append(cleaned_data[counter])
        counter += 1
        current_draw = int(cleaned_data[counter][0])

    all_draws_file = open(euromillions_hotpicks_all_draws_path, WRITABLE)

    all_draws_file = update_file_for(all_draws_file, draw_to_add)
    all_draws_file = update_file_for(all_draws_file, all_draws_list)
    all_draws_file.close()


def update_euromillions_hotpics():
    output.debug_print(f'Updating {EUROHOTPICKS} draws and all draws')
    data = download(euromillions_hotpicks_url, EUROHOTPICKS)
    save_recent_draws_for(EUROHOTPICKS, euromillions_hotpicks_draws_path, data)
    update_all_draws_for_euromillions_hotpicks()
    output.debug_print(f"{EUROHOTPICKS}'s draws and all draws updated.")


def update_all_draws():
    print('Updating draws for all games.')
    update_set_for_life()
    time.sleep(1)
    update_thunderball()
    time.sleep(1)
    update_lotto_and_hotpics()
    time.sleep(1)
    update_euromillions()
    time.sleep(1)
    update_euromillions_hotpics()
    print('Update completed.')


if __name__ == '__main__':
    start_time = timer()
    update_all_draws()
    end_time = timer()
    print('It took {} ms. (excluding waiting time between calls)'.format(
        int((end_time - start_time) * 1000) - WAITING_TIME))
    output.debug_mode_warning()
