package dms.pastor.prototypes.ui.controllers;

import dms.pastor.prototypes.ui.services.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class WorldMapController {
    @Autowired
    private PlayerService playerService;

    @GetMapping("/map/world")
    public String index(Model model) {
        model.addAttribute(playerService.getPlayer());
        return "/game/map/world";
    }
}
