package dom.coffirgar.transportmanager.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//TODO test with WebClient
@Slf4j
@Service
public class TubeGateway {
    private RestTemplate restTemplate;

    @Autowired
    public TubeGateway(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public String getAllStations() {
        String fooResourceUrl
                = "http://192.168.0.15:18003";
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl + "/tube/stations/", String.class);
        log.info(response.getStatusCode().toString());
        return response.getBody();

    }

}
