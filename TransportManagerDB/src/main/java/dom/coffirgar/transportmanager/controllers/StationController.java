package dom.coffirgar.transportmanager.controllers;

import dom.coffirgar.transportmanager.services.StationsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class StationController {

    private final StationsService stationsService;

    public StationController(StationsService stationsService) {
        this.stationsService = stationsService;
    }


    @RequestMapping(value = "/stations/tube/all", method = RequestMethod.GET, produces = "application/json")
    public String getAllStations() {
        return "{}";
    }
}