package dms.pastor.game.dcs;

import dms.pastor.domain.exception.SomethingWentTerribleWrongError;
import dms.pastor.game.dcs.game.Campaign;
import dms.pastor.game.dcs.units.Player;
import dms.pastor.game.dcs.utils.FakeInputReader;
import dms.pastor.game.dcs.utils.UserKeyboardReader;
import dms.pastor.utils.ValidatorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppLauncher {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppLauncher.class);

    AppLauncher() {
    }

    public static void main(String[] args) {
        ValidatorUtils.validateIfNotNull(args);
        LOGGER.debug("Starting application");
        Player player;
        if (args.length == 0) {
            player = new Player("1UP", new UserKeyboardReader());
        } else if (args.length == 2) {
            LOGGER.warn("Running Player simulation...");
            player = new Player("Demo Player", new FakeInputReader());
        } else {
            throw new SomethingWentTerribleWrongError();
        }
        new AppLauncher().newGame(player, new Campaign());
    }

    void newGame(Player player, Campaign campaign) {
        campaign.campaign(player);
        LOGGER.debug("End of life. Happy afterlife to you!");

    }
}
