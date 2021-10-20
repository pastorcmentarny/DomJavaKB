package dms.coffirgar.transportmanager.clients;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
                = "http://192.168.0.15:18002";
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl + "/stations/tube/all", String.class);
        log.info(response.getStatusCode().toString());
        return response.getBody();

    }

}