package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Config;
import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.conditions.ElementType;
import dms.pastor.game.dcs.units.Unit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * Author Dominik Symonowicz
 * Created 2015-08-02
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class AsteroidStormSpell extends Spell {
    private static final Logger LOGGER = LoggerFactory.getLogger(AsteroidStormSpell.class);
    private final Random random = new Random();

    public AsteroidStormSpell() {
        super();
        name = "Asteroid Storm";
        setElements(new Elements(1, 4, 0, 0, 0, 0));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        LOGGER.debug(attacker.getName() + " casting .. " + name + " on " + defender.getName());
        int dmg = Config.ASTEROID_STORM_MIN_DAMAGE + random.nextInt(Config.ASTEROID_STORM_MAX_DAMAGE - Config.ASTEROID_STORM_MIN_DAMAGE);
        int asteroids = Config.ASTEROID_STORM_MIN_ASTEROIDS + random.nextInt(Config.ASTEROID_STORM_MAX_ASTEROIDS - Config.ASTEROID_STORM_MIN_ASTEROIDS);
        for (int i = 1; i <= asteroids; i++) {
            int r = random.nextInt(100);
            if (r >= Config.ASTEROID_STORM_CHANCE_TO_HIT) {
                LOGGER.info("Asteroid hit " + defender.getName());
                if (defender.getCondition().isNotImmuneTo(ElementType.EARTH)) {
                    defender.doesDamage(dmg, attacker);
                }
            } else {
                LOGGER.info("Meteor missed.");
            }
        }
    }
}