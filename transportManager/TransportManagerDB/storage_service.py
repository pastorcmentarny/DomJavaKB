SEPARATOR = ";;"
EMPTY = ''

READ = 'r'

ENCODING = 'utf-8'


# TODO replace with proper implementations
def convert_to_null_if_none(value: str):
    if value == "none":
        return None
    return value


def convert_line_to_dict(line: str) -> dict:
    line_columns = line.split(SEPARATOR)
    return {
        "name": line_columns[0],
        "status": line_columns[1],
        "passedDate": convert_to_null_if_none(line_columns[2]),
        "visitedDate": convert_to_null_if_none(line_columns[3]),
        "visitedThisYearDate": convert_to_null_if_none(line_columns[4]),
    }


def convert_dict_to_line(station: dict) -> str:
    return f'{station["name"]}{SEPARATOR}{station["status"]}{SEPARATOR}{station["passedDate"]}{SEPARATOR}{station["visitedDate"]}{SEPARATOR}{station["thisYearVisitedDate;"]}'


def load_data(path: str) -> list:
    file = open(path, READ, newline=EMPTY)
    database = file.readlines()
    database = [line.replace("\r\n", EMPTY) for line in database]
    database = [convert_line_to_dict(line) for line in database]
    return database


def save_data(stations: list, path: str):
    stations = [convert_line_to_dict(station) for station in stations]
    with open(path, 'w+', encoding=ENCODING) as path_file:
        path_file.write('\n'.join(stations))



# prototype test
if __name__ == '__main__':
    x = convert_line_to_dict("St. James's Park;;V;;2017-02-02;;2018-06-01;;2021-10-03")
    print(convert_dict_to_line(x))


