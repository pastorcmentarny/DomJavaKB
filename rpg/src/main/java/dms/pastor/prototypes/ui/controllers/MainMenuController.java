package dms.pastor.prototypes.ui.controllers;

import dms.pastor.prototypes.aberminegenerator.ui.web.WorldMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainMenuController {

    @Autowired
    private WorldMapService worldMapService;

    @GetMapping("/")
    public String index(Model model) {
        System.out.println(model);
        return "/index";
    }

    @GetMapping("/menu")
    public String menu(Model model) {
        System.out.println(model);
        return "/menu/main";
    }

    @GetMapping("/menu/about")
    public String about(Model model) {
        System.out.println(model);
        return "/menu/about";
    }

    @GetMapping("/generate")
    public String generate() {
        return "/game/map/world";
    }
}
