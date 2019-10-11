package dms.pastor.prototype.dcs;

import dms.pastor.domain.exception.SomethingWentTerribleWrongError;
import dms.pastor.prototype.dcs.game.Campaign;
import dms.pastor.prototype.dcs.units.Player;
import dms.pastor.prototype.dcs.utils.FakeInputReader;
import dms.pastor.prototype.dcs.utils.UserKeyboardReader;
import dms.pastor.utils.ValidatorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class AppLauncher {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppLauncher.class);

    AppLauncher() {
    }

    public static void main(String[] args) {
        ValidatorUtils.validateIfObjectValueIsNotNull(args);
        LOGGER.debug("Starting application");
        Player player;
        switch (args.length) {
            case 0:
                player = new Player("1UP", new UserKeyboardReader());
                break;
            case 2:
                LOGGER.warn("Running Player simulation...");
                player = new Player("Demo Player", new FakeInputReader());
                break;
            default:
                throw new SomethingWentTerribleWrongError();
        }
        new AppLauncher().newGame(player, new Campaign());
    }

    void newGame(Player player, Campaign campaign) {
        campaign.campaign(player);
        LOGGER.debug("End of life. Happy afterlife to you!");
    }
}
