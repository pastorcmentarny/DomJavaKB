package dom.coffirgar.transportmanager.services;

import dom.coffirgar.transportmanager.domain.Response;
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

    public Response setToPassedStatus(String stationName) {
        // get station
        final Response stationResponse = tubeGateway.getStation(stationName);
        if (stationResponse.isOK()) {
            updateToPassedIfNotPassedBefore(stationResponse);
            System.out.println(stationResponse);
        }
        return stationResponse;
    }

    private void updateToPassedIfNotPassedBefore(Response stationResponse) {
        if (stationResponse.getStation().isPassedAlready()) {
            stationResponse.toError("Already passed this station");
        } else {
            stationResponse.updateToPassed();
            tubeGateway.updateToPassed(stationResponse.getStation().getName());
        }
    }

}
