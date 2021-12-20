package dom.coffirgar.transportmanager.controllers;

import dom.coffirgar.transportmanager.services.LinesService;
import dom.coffirgar.transportmanager.services.TubeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static dom.coffirgar.transportmanager.configurations.Constants.APPLICATION_JSON;

@Slf4j
@RestController
public class TubeLinesController {
    private final LinesService linesService;

    @Autowired
    public TubeLinesController(LinesService linesService) {
        this.linesService = linesService;
    }

    @GetMapping(value = "/tube/all-lines", produces = APPLICATION_JSON)
    public List<String> getAllLinesNames() {
        log.info("Getting all lines names");
        return linesService.getAllTubeLinesName();
    }

}
