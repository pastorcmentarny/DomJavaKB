package dms.pastor.game.dcs.events;

import dms.pastor.game.dcs.Config;
import dms.pastor.game.dcs.units.Unit;

/**
 * Author Dominik Symonowicz
 * Created 2015-08-08
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class ShieldRechargeEvent extends Event {

    @Override
    public String makeItHappen(Unit player1, Unit player2) {
        return startShieldRegeneration(getRandomUnit(player1, player2));
    }

    private String startShieldRegeneration(Unit player) {
        if (canHaveEvent(player) && player.isShielded()) {
            player.shieldRegen(Config.getRandomShieldRegenerationRate());
        }
        return player.getName() + "'s shield recharged by few sp ";
    }
}
