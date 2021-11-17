package dms.coffirgar.transportmanager.controllers;

import dms.coffirgar.transportmanager.domain.Response;
import dms.coffirgar.transportmanager.domain.Station;
import dms.coffirgar.transportmanager.services.TubeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class MenuController {

    private final TubeService tubeService;

    public MenuController(TubeService tubeService) {
        this.tubeService = tubeService;
    }

    @GetMapping("/")
    public String greeting(@RequestParam(name = "option", required = false, defaultValue = "1") String option, Model model) {
        model.addAttribute("option", option);
        return "menu";
    }

    @GetMapping("/all-stations-name")
    public String displayAllStationsInformation(Model model) {
        model.addAttribute("stations", Arrays.asList(tubeService.getAllStationsNames()));
        return "stations-name";
    }

    @GetMapping(value = "/tube/station/{stationName}")
    public String displayStationsInformationFor(Model model,@PathVariable String stationName) {
        final Response response = tubeService.getStationFor(stationName);

        model.addAttribute("status", response.getResult());
        model.addAttribute("description", response.getDescription());
        model.addAttribute("station", response.getStation());
        return "station";
    }

    @GetMapping(value = "/tube/set-passed/{stationName}")
    public String setPassedFor(Model model,@PathVariable String stationName) {
        final Response response = tubeService.setPassedFor(stationName);
        model.addAttribute("status", response.getResult());
        model.addAttribute("description", response.getDescription());
        model.addAttribute("station", response.getStation());
        return "station";
    }


}



