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
        String fooResourceUrl
                = TM_SERVICE_URL;
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl + "/stations/tube/all", String.class);
        log.info(response.getStatusCode().toString());
        return response.getBody();

    }

    public String[] getAllStationsNames() {
        String fooResourceUrl
                = TM_SERVICE_URL;
        ResponseEntity<String[]> response
                = restTemplate.getForEntity(fooResourceUrl + "/stations/tubes/all-names", String[].class);
        log.info(response.getStatusCode().toString());
        return response.getBody();

    }
}