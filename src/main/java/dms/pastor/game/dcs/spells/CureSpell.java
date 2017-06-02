package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.conditions.ConditionType;
import dms.pastor.game.dcs.units.Unit;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-29
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class CureSpell extends Spell {
    public CureSpell() {
        super();
        name = "Draw an event";
        setElements(new Elements(0, 1, 0, 1, 2, 0));
    }

    @Override
    public boolean hasEnoughElementsToCovertToSpell(Elements elements) {
        return getElements().hasEnough(elements);
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        attacker.getCondition().removeByConditionName(ConditionType.POISONED);
        attacker.getCondition().removeByConditionName(ConditionType.WEAKNESS);
        attacker.getCondition().removeByConditionName(ConditionType.BLIND);
    }
}
