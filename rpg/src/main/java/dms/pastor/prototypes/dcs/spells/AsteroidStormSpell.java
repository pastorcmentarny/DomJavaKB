package dms.pastor.prototypes.dcs.spells;

import dms.pastor.prototypes.dcs.Elements;
import dms.pastor.prototypes.dcs.conditions.ElementType;
import dms.pastor.prototypes.dcs.units.Unit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dms.pastor.prototypes.dcs.Config.*;
import static dms.pastor.prototypes.dcs.utils.random.InGameRandomUtils.QUARTER;
import static dms.pastor.prototypes.dcs.utils.random.InGameRandomUtils.TWO_THIRD;

/**
 * Author Dominik Symonowicz
 * Created 2015-08-02
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class AsteroidStormSpell extends Spell {

    private static final Logger LOGGER = LoggerFactory.getLogger(AsteroidStormSpell.class);

    AsteroidStormSpell() {
        setName("Asteroid Storm");
        setElements(new Elements(1, 4, 0, 0));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        castSpellMessage(attacker.getName(), getName(), defender.getName());
        int dmg = ASTEROID_STORM_MIN_DAMAGE + random.nextInt(ASTEROID_STORM_MAX_DAMAGE - ASTEROID_STORM_MIN_DAMAGE);
        int asteroids = ASTEROID_STORM_MIN_ASTEROIDS + random.nextInt(ASTEROID_STORM_MAX_ASTEROIDS - ASTEROID_STORM_MIN_ASTEROIDS);
        LOGGER.debug(asteroids + " asteroid(s) will do " + dmg + " dmg each that will hit.");
        for (int i = 1; i <= asteroids; i++) {
            if (randomUtils.isWillHappenWithProbabilityOf(QUARTER)) {
                if (randomUtils.isWillHappenWithProbabilityOf(TWO_THIRD)) {
                    System.out.println("Asteroid hits " + defender.getName() + "!");
                    if (defender.getConditions().isNotImmuneTo(ElementType.EARTH)) {
                        attacker.doesDamageTo(defender, dmg);
                    }
                } else {
                    System.out.println("Asteroid hits " + attacker.getName() + "!");
                    if (attacker.getConditions().isNotImmuneTo(ElementType.EARTH)) {
                        attacker.doesDamageTo(attacker, dmg);
                    }
                }
            } else {
                System.out.println("Asteroid missed.");
            }
        }
    }
}
