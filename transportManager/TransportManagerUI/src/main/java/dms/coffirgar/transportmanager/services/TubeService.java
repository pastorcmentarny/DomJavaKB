package dms.coffirgar.transportmanager.services;

import dms.coffirgar.transportmanager.clients.TubeClient;
import dms.coffirgar.transportmanager.converters.ToStationConverter;
import dms.coffirgar.transportmanager.domain.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TubeService {
    private final TubeClient tubeClient;
    private final ToStationConverter converter;

    @Autowired
    public TubeService(TubeClient tubeClient, ToStationConverter converter) {
        this.tubeClient = tubeClient;
        this.converter = converter;
    }

    public String getAllStations() {
        return tubeClient.getAllStations();
    }

    public String[] getAllStationsNames() {
        return tubeClient.getAllStationsNames();
    }

    public Station getStationFor(String stationName) {
        final String stationAsString = tubeClient.getStationFor(stationName);
        return converter.convert(stationAsString);
    }
}
