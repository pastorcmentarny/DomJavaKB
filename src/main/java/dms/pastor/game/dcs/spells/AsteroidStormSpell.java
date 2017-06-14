package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Config;
import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.units.Unit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

import static dms.pastor.game.dcs.Config.*;
import static dms.pastor.game.dcs.conditions.ElementType.EARTH;

/**
 * Author Dominik Symonowicz
 * Created 2015-08-02
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class AsteroidStormSpell extends Spell {
    private static final Logger LOGGER = LoggerFactory.getLogger(AsteroidStormSpell.class);
    private final Random random = new Random();

    public AsteroidStormSpell() {
        super();
        name = "Asteroid Storm";
        setElements(new Elements(1, 4, 0, 0));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        System.out.println(attacker.getName() + " casting .. " + name + " on " + defender.getName());
        int dmg = ASTEROID_STORM_MIN_DAMAGE + random.nextInt(ASTEROID_STORM_MAX_DAMAGE - ASTEROID_STORM_MIN_DAMAGE);
        int asteroids = ASTEROID_STORM_MIN_ASTEROIDS + random.nextInt(ASTEROID_STORM_MAX_ASTEROIDS - ASTEROID_STORM_MIN_ASTEROIDS);
        LOGGER.debug(asteroids + " asteroid(s) will do " + dmg + " dmg each that will hit.");
        for (int i = 1; i <= asteroids; i++) {
            int r = random.nextInt(100);
            if (r >= Config.ASTEROID_STORM_CHANCE_TO_HIT) {
                if (random.nextInt(100) > 66) {
                    System.out.println("Asteroid hits " + defender.getName() + "!");
                    if (defender.getConditions().isNotImmuneTo(EARTH)) {
                        attacker.doesDamageTo(defender, dmg);
                    }
                } else {
                    System.out.println("Asteroid hits " + attacker.getName() + "!");
                    if (attacker.getConditions().isNotImmuneTo(EARTH)) {
                        attacker.doesDamageTo(attacker, dmg);
                    }
                }
            } else {
                System.out.println("Asteroid missed.");
            }
        }
    }
}
