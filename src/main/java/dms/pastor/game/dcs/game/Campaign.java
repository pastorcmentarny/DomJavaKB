package dms.pastor.game.dcs.game;

import dms.pastor.game.dcs.units.Player;
import dms.pastor.game.dcs.units.Unit;
import dms.pastor.game.dcs.units.enemies.Enemies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Author Dominik Symonowicz
 * Created 2015-08-02
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Campaign {
    private static final Logger LOGGER = LoggerFactory.getLogger(Campaign.class);

    private final List<Unit> enemies = Enemies.getAllEnemies();

    public void campaign(Player player) {
        LOGGER.info("Starting campaign ..");
        Battle battle;
        for (int i = 0; i < enemies.size(); i++) {
            if (player.isDead()) {
                gameOver("You died before battle no." + (i + 1));
                return;
            }
            LOGGER.info("Battle no." + (i + 1));
            battle = new Battle(player, enemies.get(i));
            battle.isInFight();
            if (player.isAlive()) {
                LOGGER.info("You won");
                player.addHP(5);
                player.getElements().addRandomElements(5);
                player.recreateShield();
            } else {
                gameOver("You died at level:" + (i + 1));
                return;
            }
        }
        LOGGER.info("You completed a game! Well done!");
    }

    private void gameOver(String reason) {
        LOGGER.info("GAME OVER!\n" + reason);
    }

}
