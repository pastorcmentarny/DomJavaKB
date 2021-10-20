package dms.coffirgar.transportmanager.services;

import dms.coffirgar.transportmanager.clients.TubeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TubeService {
    private final TubeClient tubeClient;

    @Autowired
    public TubeService(TubeClient tubeClient) {
        this.tubeClient = tubeClient;
    }

    public String getAllStations() {
        return tubeClient.getAllStations();
    }
}
