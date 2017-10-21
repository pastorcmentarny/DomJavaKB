package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.units.Unit;

import static dms.pastor.game.dcs.Config.METEOR_STRIKE_DMG;
import static dms.pastor.game.dcs.Config.METEOR_STRIKE_NO;
import static dms.pastor.game.dcs.conditions.ElementType.FIRE;
import static dms.pastor.game.dcs.utils.random.InGameRandomUtils.FIVE_PERCENT;
import static dms.pastor.game.dcs.utils.random.InGameRandomUtils.HALF;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-23
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class MeteorStrikeSpell extends Spell {

    public MeteorStrikeSpell() {
        name = "Meteor Strike";
        setElements(new Elements(0, 2, 3, 0));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        castSpellMessage(attacker.getName(), name, defender.getName());
        for (int i = 1; i <= METEOR_STRIKE_NO; i++) {
            if (randomUtils.isWillHappenWithProbabilityOf(HALF)) {
                System.out.println("Meteor hit " + defender.getName());
                if (defender.getConditions().isNotImmuneTo(FIRE)) {
                    attacker.doesDamageTo(defender, METEOR_STRIKE_DMG);
                }
            } else if (randomUtils.isWillHappenWithProbabilityOf(FIVE_PERCENT)) {
                System.out.println("Meteor missed.");
            } else {
                System.out.println("Meteor accidentally hit " + attacker.getName());
                System.out.println("Meteor hit " + defender.getName());
                if (attacker.getConditions().isNotImmuneTo(FIRE)) {
                    attacker.doesDamageTo(attacker, METEOR_STRIKE_DMG);
                }
            }
        }
    }

}
