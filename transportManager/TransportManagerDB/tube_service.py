import db_config
import storage_service


def get_station_data_for_(station_name: str) -> dict:
    stations = storage_service.load_data(db_config.get_path())
    for station in stations:
        if station["name"] == station_name:
            return {"station": station}
    return {}
