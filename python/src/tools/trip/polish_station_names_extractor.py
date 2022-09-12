from pathlib import Path

path = Path(r'B:\GitHub\TransportManager\db\polish-stations.txt')
dest_path = Path(r'B:\GitHub\TransportManager\db\polish-stations.txt')
EMPTY = ""
NEW_LINE = '\n'
SPACE = " "


def extract_station_names(path):
    station_list = []
    file = open(path, 'r', newline='', encoding="utf8")
    content = file.readlines()
    file.close()
    print(len(content))
    for line in content:
        station_list.append(line.rstrip() + ';;none;;none;;none;;none;;none;;X;;O;;N;;nothing')
    print(len(station_list))
    station_list = list(set(station_list))
    print(len(station_list))
    station_list = sorted(station_list)
    file = open(path, 'w', newline='', encoding="utf8")
    for station in station_list:
        file.write(station)
        file.write(NEW_LINE)
    file.close()
    return station_list


if __name__ == '__main__':
    for station in extract_station_names(path):
        print(station)
