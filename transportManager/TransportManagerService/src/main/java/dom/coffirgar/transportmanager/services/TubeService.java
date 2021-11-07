package dom.coffirgar.transportmanager.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import dom.coffirgar.transportmanager.domain.Response;
import dom.coffirgar.transportmanager.domain.stations.Station;
import dom.coffirgar.transportmanager.mappers.ToResponseConverter;
import dom.coffirgar.transportmanager.mappers.ToStationConverter;
import org.springframework.stereotype.Service;

@Service
public class TubeService {
    public final TubeGateway tubeGateway;
    public final ToStationConverter toStationConverter;
    public final ToResponseConverter responseConverter;

    public TubeService(TubeGateway tubeGateway, ToStationConverter toStationConverter, ToResponseConverter responseConverter) {
        this.tubeGateway = tubeGateway;
        this.toStationConverter = toStationConverter;
        this.responseConverter = responseConverter;
    }

    public Response setToPassedIfNotVisitedYet(String stationName) {
        return tubeGateway.getStation(stationName);
    }

}
