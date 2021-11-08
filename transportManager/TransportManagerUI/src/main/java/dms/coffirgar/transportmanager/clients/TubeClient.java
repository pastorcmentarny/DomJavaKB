package dms.coffirgar.transportmanager.clients;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
        ResponseEntity<String> response
                = restTemplate.getForEntity(TM_SERVICE_URL + "/stations/tube/all", String.class);
        log.info(response.getStatusCode().toString());
        return response.getBody();

    }

    public String[] getAllStationsNames() {
        ResponseEntity<String[]> response
                = restTemplate.getForEntity(TM_SERVICE_URL + "/stations/tubes/all-names", String[].class);
        log.info(response.getStatusCode().toString());
        return response.getBody();
    }

    public String getStationFor(String stationName) {
        final ResponseEntity<String> response = restTemplate.getForEntity(TM_SERVICE_URL + "/station/tube/" + stationName, String.class);
        return response.getBody();
    }

    public String setPassedForStation(String stationName) {
        final ResponseEntity<String> response = restTemplate.getForEntity(TM_SERVICE_URL + "/station/tube/set-passed/" + stationName, String.class);
        return response.getBody();
    }
}