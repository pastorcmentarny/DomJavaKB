import db_config
import storage_service


def get_station_data_for_(station_name: str) -> dict:
    stations = storage_service.load_data(db_config.get_path())
    for station_item in stations:
        if station_item["name"] == station_name:
            return station_item
    return {}


def update_station_info(updated_station_data) -> bool:
    stations = storage_service.load_data(db_config.get_path())
    for station_item in stations:
        if station_item["name"] == updated_station_data["name"]:
            idx = stations.index(station_item)
            stations[idx] = updated_station_data
            storage_service.save_data(stations, db_config.get_path())
            return True
    return False


def update_station_to_passed(station_name, date):
    stations = storage_service.load_data(db_config.get_path())
    for station_item in stations:
        if station_item["name"] == station_name:
            idx = stations.index(station_item)
            stations[idx]["passedDate"] = date
            storage_service.save_data(stations, db_config.get_path())
            return True
    return False


# TODO MOVE TO TEST
if __name__ == '__main__':
    station = {
        "name": "Goldhawk Road",
        "status": "V",
        "passedDate": "2022-22-22",
        "visitedDate": "2022-22-22",
        "visitedThisYearDate": "2022-22-22"
    }
    update_station_info(station)
