package dms.coffirgar.transportmanager.clients;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static dms.coffirgar.transportmanager.configurations.Constants.EMPTY;
import static dms.coffirgar.transportmanager.configurations.Constants.TM_SERVICE_URL;

@Slf4j
@Service
public class TubeClient {

    private RestTemplate restTemplate;

    @Autowired
    public TubeClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public String getAllStations() {
        log.info("Requesting all stations data");
        ResponseEntity<String> response
                = restTemplate.getForEntity(TM_SERVICE_URL + "/stations/tube/all", String.class);
        log.info("Response for all stations data was: %s".formatted(response.getStatusCode().toString()));
        return response.getBody();

    }

    public String[] getAllStationsNames() {
        log.info("Requesting all stations names");
        ResponseEntity<String[]> response
                = restTemplate.getForEntity(TM_SERVICE_URL + "/stations/tubes/all-names", String[].class);
        log.info("Response for all stations name was: %s".formatted(response.getStatusCode().toString()));
        return response.getBody();
    }

    public String getStationFor(String stationName) {
        log.info("Requesting station data for %s".formatted(stationName));
        final ResponseEntity<String> response = restTemplate.getForEntity(TM_SERVICE_URL + "/station/tube/" + stationName, String.class);
        log.info("Response for %s was %s".formatted(stationName, response.getStatusCode().toString()));
        return response.getBody();
    }

    public String setPassedForStation(String stationName) {
        log.info("Sending request to tube service to set " + stationName + " to passed");
        final ResponseEntity<String> response = restTemplate.getForEntity(TM_SERVICE_URL + "/station/tube/set-passed/" + stationName, String.class);
        log.info("Response for %s was %s".formatted(stationName, response.getStatusCode()));
        return response.getBody();
    }

    public String setVisitedForStation(String stationName) {
        log.info("Sending request to tube service to set " + stationName + " to visited");
        final ResponseEntity<String> response = restTemplate.getForEntity(TM_SERVICE_URL + "/station/tube/set-visited/" + stationName, String.class);
        log.info("Response for %s was %s".formatted(stationName, response.getStatusCode()));
        return response.getBody();
    }

    //TODO WIP
    public String getStatistic() {
        log.info("Sending request to get statistics for Tube");
        ResponseEntity<String> response
                = restTemplate.getForEntity(TM_SERVICE_URL + "/tube/statistics", String.class);
        log.info("Response for get all statistics for Tube was %s".formatted(response.getStatusCode()));
        return EMPTY;
    }

    public String[] getAllLines() {
        log.info("Requesting all lines names");
        try {
            ResponseEntity<String[]> response
                    = restTemplate.getForEntity(TM_SERVICE_URL + "/stations/tubes/all-lines", String[].class);
            log.info("Response for all stations lines was: %s".formatted(response.getStatusCode().toString()));
            return response.getBody();
        } catch (RuntimeException exception) {
            log.error("Unable to get all lines names due to :" + exception.getMessage());
            return new String[0];
        }
    }


}