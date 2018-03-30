package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.units.Unit;

import static dms.pastor.game.dcs.conditions.ConditionType.*;

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
        attacker.getConditions().removeByConditionName(POISONED);
        attacker.getConditions().removeByConditionName(WEAKNESS);
        attacker.getConditions().removeByConditionName(BLIND);
    }
}
