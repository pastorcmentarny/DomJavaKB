# TODO move to test. test station to cover all cases
stations = [
    "Caledonian Road & Barnsbury",
    "Kensington (Olympia)",
    "Walthamstow Queen's Road",
]

'''
CALEDONIAN_ROAD_AND_BARNSBURY("Caledonian Road & Barnsbury",OVERGROUND),
KENSINGTON__OLYMPIA_("Kensington (Olympia)",OVERGROUND),
WALTHAMSTOW_QUEENS_ROAD("Walthamstow Queen's Road",OVERGROUND),
'''


def generate_station_enum():
    for station in stations:
        print(station.replace(" & ", "_AND_").replace(' ', '_').replace("'", "").replace(" & ", "_AND_").replace('(',
                                                                                                                 '_').replace(
            ')', '_').upper() + '("' + station + '",OVERGROUND),')


if __name__ == '__main__':
    generate_station_enum()
