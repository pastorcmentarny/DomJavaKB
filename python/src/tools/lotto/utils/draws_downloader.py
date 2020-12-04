"""
* Author Dominik Symonowicz
* WWW:	https://dominiksymonowicz.com/welcome
* IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
* Github:	https://github.com/pastorcmentarny
* Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
* LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
"""

import csv

import requests

WRITABLE = 'w'


def get_draws_for(url, path):

    print('get draws from: ' + url + "\nand store them here: " + path)
    response = requests.get(url)
    try:
        response.raise_for_status()  # without try it will exit program
    except Exception as whoops:
        print('There was a problem: %s' % (whoops))

    print('download complete with response ' + str(response.status_code))
    draw_history_file = open(path, WRITABLE)

    # save file
    draw_history_file.write(response.text)
    draw_history_file.close()
    draw_history_file = open(path)

    # load data
    euro_hotpics_history_csv = csv.reader(draw_history_file)
    data = list(euro_hotpics_history_csv)
    return data[1:len(data)]


def update_all_draws(recent_draws_list, all_draws_file_path, debug_mode: bool = False):
    print('updating all draws if needed')
    last_column = len(recent_draws_list[0]) - 1
    if debug_mode:
        print(f' Last Column: {last_column}')

    all_draws_file = open(all_draws_file_path)
    all_draws_list = list(csv.reader(all_draws_file))

    last_draw = int(all_draws_list[0][last_column])
    draw_to_add = []
    current_draw = int(recent_draws_list[0][last_column])
    counter = 0
    while last_draw != current_draw:
        draw_to_add.append(recent_draws_list[counter])
        counter += 1
        current_draw = int(recent_draws_list[counter][last_column])

    print(f'Adding {draw_to_add} draws to all draws list ')
    for a_draw in draw_to_add:
        print(a_draw)

    all_draws_file = open(all_draws_file_path, WRITABLE)
    all_draws_file = update_file_for(all_draws_file, draw_to_add)
    all_draws_file = update_file_for(all_draws_file, all_draws_list)
    all_draws_file.close()


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


def update_all_draws_v2(recent_draws_list, all_draws_file_path):
    print('updating all draws if needed')
    last_column = len(recent_draws_list[0]) - 1
    print(last_column)
    all_draws_file = open(all_draws_file_path)
    all_draws_list = list(csv.reader(all_draws_file))

    last_draw = int(all_draws_list[0][0])
    draw_to_add = []
    current_draw = int(recent_draws_list[0][9])
    counter = 0
    while last_draw != current_draw:
        draw_to_add.append(convert_to_draw_row(recent_draws_list[counter]))
        counter += 1
        current_draw = int(recent_draws_list[counter][9])

    print(draw_to_add)
    all_draws_file = open(all_draws_file_path, WRITABLE)
    all_draws_file = update_file_for(all_draws_file, draw_to_add)
    all_draws_file = update_file_for(all_draws_file, all_draws_list)
    all_draws_file.close()


def update_file_for(file, list):
    for draw in list:
        file.write(','.join(draw))
        file.write('\n')
    return file


def update_all_draws_for_set_for_life(recent_draws_list, all_draws_file_path):
    print('updating all draws if needed')
    last_column = len(recent_draws_list[0]) - 1
    print(last_column)
    all_draws_file = open(all_draws_file_path)
    all_draws_list = list(csv.reader(all_draws_file))

    last_draw = int(all_draws_list[0][last_column])
    draw_to_add = []
    current_draw = int(recent_draws_list[0][last_column])
    counter = 0
    while last_draw != current_draw:
        draw_to_add.append(recent_draws_list[counter])
        counter += 1
        current_draw = int(recent_draws_list[counter][last_column])

    print(draw_to_add)
    all_draws_file = open(all_draws_file_path, WRITABLE)
    all_draws_file = update_file_for(all_draws_file, draw_to_add)
    all_draws_file = update_file_for(all_draws_file, all_draws_list)
    all_draws_file.close()


def update_all_results_for_all_games():
    pass


if __name__ == '__main__':
    update_all_results_for_all_games()