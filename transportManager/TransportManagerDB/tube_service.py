import logging

import db_config
import storage_service

STATION_NAME_KEY = 'name'

logger = logging.getLogger('app')


def get_station_data_for_(station_name: str) -> dict:
    logger.debug(f"Getting station data for : {station_name}")
    stations = storage_service.load_data(db_config.get_path())
    for station_item in stations:
        if station_item[STATION_NAME_KEY] == station_name:
            return station_item
    logger.warning(f"Sta data for : {station_name}")
    return {}


def update_station_info(updated_station_data) -> bool:
    logger.debug(f"Updating {updated_station_data[STATION_NAME_KEY]} data")
    stations = storage_service.load_data(db_config.get_path())
    for station_item in stations:
        if station_item[STATION_NAME_KEY] == updated_station_data[STATION_NAME_KEY]:
            idx = stations.index(station_item)
            stations[idx] = updated_station_data
            storage_service.save_data(stations, db_config.get_path())
            logger.debug(f"Station {updated_station_data[STATION_NAME_KEY]} updated.")
            return True
    logger.warning(f"Unable to update {updated_station_data[STATION_NAME_KEY]} because cannot be find. {updated_station_data}")
    return False


# TODO remove it
def update_station_to_passed(station_name, date) -> bool:
    stations = storage_service.load_data(db_config.get_path())
    for station_item in stations:
        if station_item[STATION_NAME_KEY] == station_name:
            idx = stations.index(station_item)
            stations[idx]["passedDate"] = date
            stations[idx]["status"] = "P"
            storage_service.save_data(stations, db_config.get_path())
            return True
    return False


# TODO MOVE TO TEST
if __name__ == '__main__':
    station = {
        STATION_NAME_KEY: "Goldhawk Road",
        "status": "V",
        "passedDate": "2022-22-22",
        "visitedDate": "2022-22-22",
        "visitedThisYearDate": "2022-22-22"
    }
    update_station_info(station)
