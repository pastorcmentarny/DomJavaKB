package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.units.Unit;

import static dms.pastor.game.dcs.Config.BLOODLUST_TURNS;
import static dms.pastor.game.dcs.conditions.ConditionType.BLOODLUST;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-28
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class Bloodlust extends Spell {

    public Bloodlust() {
        super();
        name = "Bloodlust";
        setElements(new Elements(0, 0, 0, 4, 0, 0));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        System.out.println(attacker.getName() + " casting " + name + " spell");
        attacker.getConditions().add(BLOODLUST, BLOODLUST_TURNS);
    }
}
