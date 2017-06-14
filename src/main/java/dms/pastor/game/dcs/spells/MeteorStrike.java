package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Config;
import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.conditions.ElementType;
import dms.pastor.game.dcs.units.Unit;

import java.util.Random;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-23
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class MeteorStrike extends Spell {
    private final Random random = new Random();

    public MeteorStrike() {
        super();
        name = "Meteor Strike";
        setElements(new Elements(0, 2, 3, 0, 0, 0));
    }


    @Override
    public void castSpell(Unit attacker, Unit defender) {
        System.out.println(attacker.getName() + " casting meteor strike.. " + defender.getName());
        for (int i = 1; i <= Config.METEOR_STRIKE_NO; i++) {
            int r = random.nextInt(100);
            if (r >= 50) {
                System.out.println("Meteor hit " + defender.getName());
                if (defender.getConditions().isNotImmuneTo(ElementType.FIRE)) {
                    attacker.doesDamage(Config.METEOR_STRIKE_DMG, defender);
                }
            } else if (r >= 5) {
                System.out.println("Meteor missed.");
            } else {
                System.out.println("Meteor accidentally hit " + attacker.getName());
                System.out.println("Meteor hit " + defender.getName());
                if (attacker.getConditions().isNotImmuneTo(ElementType.FIRE)) {
                    attacker.doesDamage(Config.METEOR_STRIKE_DMG, attacker);
                }
            }
        }
    }


}
