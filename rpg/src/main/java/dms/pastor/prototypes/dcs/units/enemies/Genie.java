package dms.pastor.prototypes.dcs.units.enemies;

import dms.pastor.prototypes.dcs.Elements;
import dms.pastor.prototypes.dcs.conditions.ConditionEntry;
import dms.pastor.prototypes.dcs.conditions.ConditionType;
import dms.pastor.prototypes.dcs.conditions.ElementType;
import dms.pastor.prototypes.dcs.spells.FrozenSpell;
import dms.pastor.prototypes.dcs.spells.InfernoStrikeSpell;
import dms.pastor.prototypes.dcs.spells.LightingBoltSpell;
import dms.pastor.prototypes.dcs.units.Unit;
import dms.pastor.prototypes.dcs.utils.random.InGameRandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dms.pastor.prototypes.dcs.Config.INITIAL_SHIELD_POINTS;

/**
 * Author Dominik Symonowicz
 * Created 2017-06-30
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Genie extends Unit {
    private static final Logger LOGGER = LoggerFactory.getLogger(Genie.class);
    private static final int MAX_GRID_NUMBER = 1_000_000;


    public Genie() {
        setName("Genie from the grid :" + random.nextInt(MAX_GRID_NUMBER));
        setElements(new Elements(10));
        setSp(10 * INITIAL_SHIELD_POINTS);
        getConditions().add(ConditionEntry.createPersistentCondition(ConditionType.AIR_IMMUNE));
        getConditions().add(ConditionEntry.createPersistentCondition(ConditionType.WATER_SENSITIVE));
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
            if (randomUtils.isWillHappenWithProbabilityOf(InGameRandomUtils.ONE_THIRD)) {
                //TODO improve this rubbish log
                LOGGER.debug(getName() + " was lucky enough and will cast Frozen spell.");
                new FrozenSpell().castSpell(this, enemy);
            }
        }

        while (getElements().getFire() >= 2) {
            InfernoStrikeSpell infernoStrikeSpell = new InfernoStrikeSpell();
            infernoStrikeSpell.castSpell(this, enemy);
            getElements().useElement(ElementType.FIRE, 2);
        }

        getElements().addElement(ElementType.AIR, random.nextInt(3) + 1);
        castTripleLightingBoltSpellIfLucky(enemy);
    }

    private void castTripleLightingBoltSpellIfLucky(Unit enemy) {
        LightingBoltSpell lightingBoltSpell = new LightingBoltSpell();

        if (randomUtils.isWillHappenWithProbabilityOf(InGameRandomUtils.THREE_QUARTERS)) {
            System.out.println("Triple fire ball strikes " + enemy.getName());
            for (int i = 1; i <= 3; i++) {
                lightingBoltSpell.castSpell(this, enemy);
            }
        }
    }
}
