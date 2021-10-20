package dms.coffirgar.transportmanager.controllers;

import dms.coffirgar.transportmanager.services.TubeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/all-stations")
    public String displayAllStationsInformation(Model model) {

        model.addAttribute("option", tubeService.getAllStations());
        return "stations";
    }


}



