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


# TODO replace with proper implementations
def convert_to_none_if_none_or_null(value: str):
    if value == "none" or value == "null":
        return None
    return value


def convert_line_to_dict(line: str) -> dict:
    line_columns = line.split(SEPARATOR)
    return {
        NAME: line_columns[0],
        STATUS: line_columns[1],
        PASSED_DATE: convert_to_none_if_none_or_null(line_columns[2]),
        VISITED_DATE: convert_to_none_if_none_or_null(line_columns[3]),
        VISITED_THIS_YEAR_DATE: convert_to_none_if_none_or_null(line_columns[4]),
    }


def convert_dict_to_line(station: dict) -> str:
    return f'{station[NAME]}{SEPARATOR}{station[STATUS]}{SEPARATOR}{station[PASSED_DATE]}{SEPARATOR}{station[VISITED_DATE]}{SEPARATOR}{station[VISITED_THIS_YEAR_DATE]}'


def load_data(path: str) -> list:
    file = open(path, READ, newline=EMPTY)
    database = file.readlines()
    database = [line.replace("\r\n", EMPTY) for line in database]
    database = [convert_line_to_dict(line) for line in database]
    return database


def save_data(stations: list, path: str):
    stations = [convert_dict_to_line(station) for station in stations]
    with open(path, WRITE_READ_MODE, encoding=ENCODING) as path_file:
        path_file.write('\n'.join(stations))
