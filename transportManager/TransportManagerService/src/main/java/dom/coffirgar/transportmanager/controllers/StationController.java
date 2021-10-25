package dom.coffirgar.transportmanager.controllers;

import dom.coffirgar.transportmanager.services.StationsService;
import dom.coffirgar.transportmanager.services.TubeGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
public class StationController {

    private final StationsService stationsService;
    private final TubeGateway tubeGateway;

    @Autowired
    public StationController(StationsService stationsService, TubeGateway tubeGateway) {
        this.stationsService = stationsService;
        this.tubeGateway = tubeGateway;
    }


    @RequestMapping(value = "/stations/tube/all", method = RequestMethod.GET, produces = "application/json")
    public String getAllStations() {
        log.info("Getting all tube to stations");
        return tubeGateway.getAllStations();
    }

    @RequestMapping(value = "/stations/tubes/all-names", method = RequestMethod.GET, produces = "application/json")

    public List<String> getAllStationsNames() {
        return tubeGateway.getAllStationsNames();
    }

}