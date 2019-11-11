package dms.pastor.prototypes.map.controllers;

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
        model.addAttribute("direction", "");
        return "/game/map/world";
    }

    @GetMapping("/game/world/move/north")
    public String north(Model model) {
        model.addAttribute(playerService.getPlayer());
        model.addAttribute("direction", "north");
        return "/game/map/world";
    }

    @GetMapping("/game/world/move/west")
    public String west(Model model) {
        model.addAttribute(playerService.getPlayer());
        model.addAttribute("direction", "west");
        return "/game/map/world";
    }

    @GetMapping("/game/world/move/east")
    public String east(Model model) {
        model.addAttribute(playerService.getPlayer());
        model.addAttribute("direction", "east");
        return "/game/map/world";
    }

    @GetMapping("/game/world/move/south")
    public String south(Model model) {
        model.addAttribute(playerService.getPlayer());
        model.addAttribute("direction", "south");
        return "/game/map/world";
    }
}
