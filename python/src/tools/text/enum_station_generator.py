# left this empty after use
stations = []


def convert_to_enum(station):
    return station.replace(" & ", "_AND_").replace(' ', '_').replace("'", "") \
               .replace(" & ", "_AND_").replace('(', '_').replace(')', '_') \
               .upper() + '("' + station + '",OVERGROUND),'


def generate_station_enum():
    for station in stations:
        print(convert_to_enum(station))


if __name__ == '__main__':
    generate_station_enum()
