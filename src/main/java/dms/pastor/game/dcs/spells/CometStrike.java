package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Config;
import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.conditions.ConditionType;
import dms.pastor.game.dcs.units.Unit;

import java.util.Random;

/**
 * Author Dominik Symonowicz
 * Created 2015-08-02
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class CometStrike extends Spell {
    public CometStrike() {
        super();
        name = "Comet Spell";
        setElements(new Elements(0, 3, 0, 1, 0, 1));
    }


    @Override
    public void castSpell(Unit attacker, Unit defender) {
        System.out.println(attacker.getName() + " casting comet strike spell on.. " + defender.getName());
        attacker.doesDamage(Config.COMMENT_DAMAGE, defender);
        if (new Random().nextInt(100) > 66) {
            defender.getCondition().add(ConditionType.FROZEN, Config.FREEZING_TURNS);
        }
        if (new Random().nextInt(100) > 50) {
            defender.getCondition().add(ConditionType.POISONED, Config.FREEZING_TURNS);
        }
    }
}
