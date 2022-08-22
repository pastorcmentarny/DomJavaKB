import csv


def load_data(path) -> list:
    print(f'Loading date from {path}')
    file_path = open(path, encoding='utf-8')
    data_as_csv = csv.reader(file_path)
    draws_data = list(data_as_csv)
    return draws_data


# Woodgrange Park;;P;;2022-04-28;;none;;none;;N;;nothing

# Sandy;;none;;none;;none;;none;;X;;O;;nothing

NOTES = "notes"
VISITED_THIS_YEAR_DATE = "visitedThisYearDate"
VISITED_DATE = "visitedDate"
PASSED_DATE = "passedDate"
STATUS = "status"
NAME = "name"
WRITE_READ_MODE = 'w+'
SEPARATOR = ";;"
EMPTY = ''
READ = 'r'
ENCODING = 'UTF-8'


def set_to_none_if_empty(item):
    if item is None:
        return "none"
    else:
        return item


def convert_dict_to_line(station: dict) -> str:
    return f'{station[NAME]}{SEPARATOR}{station[STATUS]}{SEPARATOR}{set_to_none_if_empty((station[PASSED_DATE]))}{SEPARATOR}{set_to_none_if_empty(station[VISITED_DATE])}{SEPARATOR}{set_to_none_if_empty(station[VISITED_THIS_YEAR_DATE])}{SEPARATOR}{set_to_none_if_empty(station[NOTES])}'


def save_data(stations: list, path: str):
    print(len(stations))
    with open(path, WRITE_READ_MODE, encoding=ENCODING) as path_file:
        path_file.write('\n'.join(stations))


def update_overground_data_in_trains():
    overground_stations = load_data(r"B:\GitHub\TransportManager\db\overground.txt")
    train_stations = load_data(r"B:\GitHub\TransportManager\db\trains.txt")
    count = 0
    not_found = 0
    all_found = []
    train_stations_updated = []

    print('Before')
    print('-' * 20)
    print(len(overground_stations))
    print(len(train_stations))
    print(len(train_stations_updated))
    print('-' * 20)
    for train_station in train_stations:
        found = False
        for overground_station in overground_stations:
            o_station = overground_station[0].split(';;')
            o_name = overground_station[0].split(';;')[0]
            if train_station[0].split(';;')[0] == o_name:
                station_line = f'{o_station[0]};;{o_station[2]};;{o_station[2]};;none;;none;;{o_station[1]};;O;;Part of All 112 Overground stations challenge'
                train_stations_updated.append(station_line)
                all_found.append(o_name)
                count = count + 1
                found = True
        if not found:
            train_stations_updated.append(train_station[0])

    print('after')
    print('-' * 20)
    print(f'count found: {count}')
    print(f'not found: {not_found}')
    print(f'Overground size: {len(overground_stations)}')
    print(f'Train size: {len(train_stations)}')
    print(f'Updated train size: {print(len(train_stations_updated))}')
    print('-' * 20)
    save_data(train_stations_updated, f"B:\\GitHub\\TransportManager\\db\\updated_train.txt")


if __name__ == '__main__':
    update_overground_data_in_trains()
