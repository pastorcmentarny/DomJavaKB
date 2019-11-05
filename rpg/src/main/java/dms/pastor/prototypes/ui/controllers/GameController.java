package dms.pastor.prototypes.ui.controllers;

import dms.pastor.prototypes.ui.services.GameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/game/new")
    public String index(Model model) {
        gameService.newGame();
        return "/game/intro";
    }
}
