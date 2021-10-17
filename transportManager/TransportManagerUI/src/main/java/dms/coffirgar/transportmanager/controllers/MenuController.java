package dms.coffirgar.transportmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MenuController {
    @GetMapping("/")
    public String greeting(@RequestParam(name="option", required=false, defaultValue="1") String option, Model model) {
        model.addAttribute("option", option);
        return "menu";
    }

}



