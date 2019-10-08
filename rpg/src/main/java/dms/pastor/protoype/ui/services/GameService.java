package dms.pastor.protoype.ui.services;

import dms.pastor.rpg.game.Game;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private Game game;

    public void newGame() {
        game = Game.getGame();
    }

    public String getPlayerInfo() {
        return game.getHero().displayShortInfo(false);
    }

}
