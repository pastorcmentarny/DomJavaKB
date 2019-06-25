package dms.pastor.rpg.ui.controllers;

import dms.pastor.rpg.ui.services.GameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/game/new")
    public String index(Model model) {
        gameService.newGame();
        return "/game/intro";
    }
}
