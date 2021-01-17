"""
A quick tool to swap column in data
default settings are:
game_data = ''
column_from = -1
column_to = -1
you need replace them with actual data

"""
import csv
import os.path

from src.kb.exceptions import GobshiteException
# SETTINGS
from src.tools.lotto.utils import output, lotto_utils

game_data_path = 'b:/swap.txt'
column_from = 0
column_to = 9

EMPTY = ""
NEW_LINE = '\n'
SPACE = " "
SPLITTER = ','


def load_data() -> list:
    print(f'Loading date from {game_data_path}')
    file_path = open(game_data_path)
    data_as_csv = csv.reader(file_path)
    draws_data = list(data_as_csv)
    output.debug_print(f'File loaded.')
    return draws_data


# FIX THIS
def save_data_to_file(swapped_data: list):
    print(f'Saving date to {game_data_path}')
    all_draws_file = open(game_data_path, 'w')
    all_draws_file = lotto_utils.update_file_for(all_draws_file, swapped_data)
    all_draws_file.close()
    output.debug_print(f'File saved.')


def update_file_for(lotto_file, all_draws_list):
    for draw in all_draws_list:
        lotto_file.write(SPLITTER.join(draw).replace(SPACE, EMPTY))
        lotto_file.write(NEW_LINE)
    return lotto_file


def swap():
    draws_data = load_data()
    swapped_data = []
    for draw in draws_data:
        swapped_draw = draw
        temp_column_data = column_to
        swapped_draw[column_to] = swapped_draw[column_from]
        swapped_draw[column_from] = temp_column_data
        swapped_data.append(swapped_draw)
        print(swapped_draw)
    save_data_to_file(swapped_data)


def validate():
    if game_data_path == '':
        raise GobshiteException('Path is empty!')
    if column_from == -1 or column_to == -1:
        raise GobshiteException('Column from or to are not set.')
    if not os.path.isfile(game_data_path):
        print("File exist")


if __name__ == '__main__':
    validate()
    swap()
