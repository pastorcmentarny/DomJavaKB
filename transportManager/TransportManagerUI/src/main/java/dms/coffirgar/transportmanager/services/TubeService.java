package dms.coffirgar.transportmanager.services;

import dms.coffirgar.transportmanager.clients.TubeClient;
import dms.coffirgar.transportmanager.converters.ToDataResponse;
import dms.coffirgar.transportmanager.converters.ToResponseConverter;
import dms.coffirgar.transportmanager.converters.ToStationConverter;
import dms.coffirgar.transportmanager.domain.DataResponse;
import dms.coffirgar.transportmanager.domain.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TubeService {
    private final TubeClient tubeClient;
    private final ToStationConverter converter;
    private final ToResponseConverter responseConverter;
    private final ToDataResponse dataResponseConverter;

    @Autowired
    public TubeService(TubeClient tubeClient, ToStationConverter converter, ToResponseConverter responseConverter, ToDataResponse dataResponseConverter) {
        this.tubeClient = tubeClient;
        this.converter = converter;
        this.responseConverter = responseConverter;
        this.dataResponseConverter = dataResponseConverter;
    }

    public String getAllStations() {
        return tubeClient.getAllStations();
    }

    public String[] getAllStationsNames() {
        return tubeClient.getAllStationsNames();
    }

    public Response getStationFor(String stationName) {
        final String stationAsString = tubeClient.getStationFor(stationName);
        return responseConverter.convert(stationAsString);
    }

    public Response setPassedFor(String stationName) {
        final String stationAsString = tubeClient.setPassedForStation(stationName);
        return responseConverter.convert(stationAsString);
    }

    public Response setVisitedFor(String stationName) {
        final String stationAsString = tubeClient.setVisitedForStation(stationName);
        return responseConverter.convert(stationAsString);

    }

    public DataResponse getStatistics() {
        final String statistic = tubeClient.getStatistic();
        return dataResponseConverter.convert(statistic);
    }

}
