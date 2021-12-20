package dom.coffirgar.transportmanager.controllers;

import dom.coffirgar.transportmanager.domain.Response;
import dom.coffirgar.transportmanager.services.StationsService;
import dom.coffirgar.transportmanager.services.TubeGateway;
import dom.coffirgar.transportmanager.services.TubeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static dom.coffirgar.transportmanager.configurations.Constants.APPLICATION_JSON;


@Slf4j
@RestController
public class StationController {

    private final StationsService stationsService;
    private final TubeGateway tubeGateway;
    private final TubeService tubeService;

    @Autowired
    public StationController(StationsService stationsService, TubeGateway tubeGateway, TubeService tubeService) {
        this.stationsService = stationsService;
        this.tubeGateway = tubeGateway;
        this.tubeService = tubeService;
    }


    @GetMapping(value = "/stations/tube/all", produces = APPLICATION_JSON)
    public String getAllStations() {
        log.info("Getting all tube to stations");
        return tubeGateway.getAllStations();
    }

    @GetMapping(value = "/station/tube/{stationName}", produces = APPLICATION_JSON)
    public Response getStationFor(@PathVariable String stationName) {
        log.info("Getting station for " + stationName);
        return tubeGateway.getStation(stationName);
    }

    @GetMapping(value = "/station/tube/set-passed/{stationName}", produces = APPLICATION_JSON)
    public Response updateStationToPassed(@PathVariable String stationName) {
        return tubeService.setToPassedStatus(stationName);
    }

    @GetMapping(value = "/station/tube/set-visited/{stationName}", produces = APPLICATION_JSON)
    public Response updateStationToVisited(@PathVariable String stationName) {
        return tubeService.setToVisitedStatus(stationName);
    }

    @GetMapping(value = "/stations/tubes/all-names", produces = APPLICATION_JSON)
    public List<String> getAllStationsNames() {
        return tubeGateway.getAllStationsNames();
    }

    @GetMapping(value = "/tube/update", produces = APPLICATION_JSON)
    public Response updateStation() {
        return tubeService.setToVisitedStatus("Upney");
    }

    @GetMapping(value = "/tube/statistics", produces = APPLICATION_JSON)
    public String statistics() {
        log.info("Getting statistics for Tube");
        return tubeService.getStatistics();
    }
}