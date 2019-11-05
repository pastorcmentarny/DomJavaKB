package dms.pastor.prototypes.dcs.spells;

import dms.pastor.prototypes.dcs.Elements;
import dms.pastor.prototypes.dcs.conditions.ConditionType;
import dms.pastor.prototypes.dcs.units.Unit;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-29
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class CureSpell extends Spell {

    public CureSpell() {
        setName("Draw an event");
        setElements(new Elements(0, 1, 0, 1));
    }

    @Override
    public boolean hasEnoughElementsToCovertToSpell(Elements elements) {
        return getElements().hasEnough(elements);
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        castSpellMessage(attacker.getName(), getName(), defender.getName());
        attacker.getConditions().removeByConditionName(ConditionType.POISONED);
        attacker.getConditions().removeByConditionName(ConditionType.WEAKNESS);
        attacker.getConditions().removeByConditionName(ConditionType.BLIND);
    }
}
