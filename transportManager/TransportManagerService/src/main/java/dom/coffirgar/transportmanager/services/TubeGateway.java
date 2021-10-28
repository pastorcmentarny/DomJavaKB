package dom.coffirgar.transportmanager.services;

import dom.coffirgar.transportmanager.domain.stations.Station;
import dom.coffirgar.transportmanager.mappers.ToStationConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

//TODO test with WebClient
@Slf4j
@Service
public class TubeGateway {
    private static final String TM_DB_URL = "http://192.168.0.15:18003";
    private RestTemplate restTemplate;
    private final ToStationConverter converter;

    @Autowired
    public TubeGateway(RestTemplate restTemplate, ToStationConverter converter) {
        this.restTemplate = restTemplate;
        this.converter = converter;
    }


    public String getAllStations() {

        ResponseEntity<String> response
                = restTemplate.getForEntity(TM_DB_URL + "/tube/stations/", String.class);
        log.info(response.getStatusCode().toString());
        return response.getBody();

    }

    public List<String> getAllStationsNames() {
        final var allStations = getAllStations();
        return converter.fromStationsAsJson(allStations).getStations().stream().map(Station::getName).collect(Collectors.toList());
    }

    public String getStation(String stationName) {
        log.info("Getting Station data from TubeGateway for " + stationName);

        ResponseEntity<String> response
                = restTemplate.getForEntity(TM_DB_URL + "/tube/station/" + stationName, String.class);
        log.info("Got response with status: " + response.getStatusCode());
        return response.getBody();

    }
}
