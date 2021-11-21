from pathlib import Path

path = Path(r'C:\table-1410-passenger-entries-and-exits-and-interchanges-by-station.csv')


def extract_station_names(path):
    timetable = []
    file = open(path, 'r', newline='')
    content = file.readlines()
    for line in content:
        timetable.append(line.split(",")[0].rstrip())
    return timetable


if __name__ == '__main__':
    for station in extract_station_names(path):
        print(station)
