package dms.pastor.rpg.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainMenuController {

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

}
