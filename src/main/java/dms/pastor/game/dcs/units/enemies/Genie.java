package dms.pastor.game.dcs.units.enemies;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.spells.FrozenSpell;
import dms.pastor.game.dcs.spells.InfernoStrikeSpell;
import dms.pastor.game.dcs.spells.LightingBoltSpell;
import dms.pastor.game.dcs.units.Unit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

import static dms.pastor.game.dcs.conditions.ConditionEntry.createPersistentCondition;
import static dms.pastor.game.dcs.conditions.ConditionType.AIR_IMMUNE;
import static dms.pastor.game.dcs.conditions.ConditionType.WATER_SENSITIVE;
import static dms.pastor.game.dcs.conditions.ElementType.AIR;
import static dms.pastor.game.dcs.conditions.ElementType.FIRE;

/**
 * Author Dominik Symonowicz
 * Created 2017-06-30
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Genie extends Unit {
    private static final Logger LOGGER = LoggerFactory.getLogger(Genie.class);
    private static final int MAX_GRID_NUMBER = 1_000_000;
    private static final Random random = new Random();


    public Genie() {
        super();
        setName("Genie from the grid :" + random.nextInt(MAX_GRID_NUMBER));
        setElements(new Elements(10));
        setSp(225);
        getConditions().add(createPersistentCondition(AIR_IMMUNE));
        getConditions().add(createPersistentCondition(WATER_SENSITIVE));
    }

    @Override
    public void turn(Unit enemy) {

        if (getElements().getFire() > 0) {
            int dmg = getElements().getFire() * 5;
            doesDamageTo(this, dmg);
            System.out.println("Fire elements  cause " + dmg + " dmg to " + getName());
            if (isDead()) {
                return;
            }
            getElements().setFire(0);
        } else {
            final int chance = random.nextInt(100);
            if (33 > chance) {
                //TODO improve this rubbish log
                LOGGER.debug(getName() + " was lucky enough and get " + chance + " and will cast Frozen spell.");
                new FrozenSpell().castSpell(this, enemy);
            }
        }

        while (getElements().getFire() >= 2) {
            InfernoStrikeSpell infernoStrikeSpell = new InfernoStrikeSpell();
            infernoStrikeSpell.castSpell(this, enemy);
            getElements().useElement(FIRE, 2);
        }

        getElements().addElement(AIR, random.nextInt(3) + 1);
        castTripleLightingBoltSpellIfLucky(enemy);
    }

    private void castTripleLightingBoltSpellIfLucky(Unit enemy) {
        LightingBoltSpell lightingBoltSpell = new LightingBoltSpell();

        if (new Random().nextInt(100) > 80) {
            System.out.println("Triple fire ball strikes " + enemy.getName());
            for (int i = 1; i <= 3; i++) {
                lightingBoltSpell.castSpell(this, enemy);
            }
        }
    }
}
