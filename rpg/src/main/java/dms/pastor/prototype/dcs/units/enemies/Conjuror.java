package dms.pastor.prototype.dcs.units.enemies;

import dms.pastor.prototype.dcs.Elements;
import dms.pastor.prototype.dcs.conditions.ConditionEntry;
import dms.pastor.prototype.dcs.conditions.ConditionType;
import dms.pastor.prototype.dcs.spells.*;
import dms.pastor.prototype.dcs.units.Unit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dms.pastor.prototype.dcs.Config.DEFAULT_ELEMENT_NUMBER;
import static dms.pastor.prototype.dcs.Config.DEFAULT_HEALTH_POINTS;

/**
 * Author Dominik Symonowicz
 * Created 01/08/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Conjuror extends Unit {

    private static final int INITIAL_SP = 40;
    private static final Logger LOGGER = LoggerFactory.getLogger(Genie.class);
    private static final int INITIAL_HP = 40;

    public Conjuror() {
        setName("Conjuror");
        setElements(new Elements(3 * DEFAULT_ELEMENT_NUMBER));
        getHealth().setHp(INITIAL_HP);
        setSp(INITIAL_SP);
        maybeAddResistanceTo(ConditionType.AIR_RESISTANT);
        maybeAddResistanceTo(ConditionType.EARTH_RESISTANT);
        maybeAddResistanceTo(ConditionType.FIRE_RESISTANT);
        maybeAddResistanceTo(ConditionType.WATER_RESISTANT);
    }

    @Override
    public void turn(Unit enemy) {
        if (getSp() == 0) {
            new CreateShieldSpell().castSpellIfHasEnoughElements(this, this);
        }

        if (getSp() <= INITIAL_SP / 2) {
            new ShieldRecoverySpell().castSpellAsLongAsItHasEnoughElements(this, this);
        }

        Spell healSpell = new HealSpell();
        if (getHealth().getHp() < DEFAULT_HEALTH_POINTS && healSpell.hasEnoughElementsToCovertToSpell(getElements())) {
            healSpell.castSpellIfHasEnoughElements(this, enemy);
        }

        boolean spellCasted = true;
        while (spellCasted) {
            Spell spell = Spells.getRandomSpell();
            if (spell.hasEnoughElementsToCovertToSpell(getElements())) {
                spell.castSpell(this, enemy);
            } else {
                spellCasted = false;
            }
        }
        final String result = getElements().addRandomElements(random.nextInt(5));
        System.out.println(getName() + " got " + result);
    }

    private void maybeAddResistanceTo(ConditionType conditionType) {
        if (random.nextBoolean()) {
            LOGGER.debug(getName() + " will be " + ConditionType.getText(conditionType));
            getConditions().add(ConditionEntry.createPersistentCondition(conditionType));
        }
    }

}
