import db_config
import storage_service


def get_station_data_for_(station_name: str) -> dict:
    stations = storage_service.load_data(db_config.get_path())
    for station in stations:
        if station["name"] == station_name:
            return station
    return {}


def update_station_info(data) -> bool:
    stations = storage_service.load_data(db_config.get_path())
    for station in stations:
        if station["name"] == data["name"]:
            idx = stations.index(station)
            stations[idx] = data
            storage_service.save_data(stations,db_config.get_path())
            return True
    return False


# Temporary test
if __name__ == '__main__':
    station = {
        "name": "Goldhawk Road",
        "status": "V",
        "passedDate": "2022-22-22",
        "visitedDate": "2022-22-22",
        "visitedThisYearDate": "2022-22-22"
    }
    update_station_info(station)
