package dms.pastor.prototypes.dcs.units.enemies;

import dms.pastor.prototypes.dcs.conditions.ConditionEntry;
import dms.pastor.prototypes.dcs.conditions.ConditionType;
import dms.pastor.prototypes.dcs.spells.IceBoltSpell;
import dms.pastor.prototypes.dcs.spells.VampireDrainSpell;
import dms.pastor.prototypes.dcs.units.Unit;

import static dms.pastor.prototypes.dcs.Config.DEFAULT_HEALTH_POINTS;

/**
 * Author Dominik Symonowicz
 * Created 2015-08-02
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Vampire extends Unit {

    public Vampire() {
        setName("Vampire");
        setSp(2 * DEFAULT_HEALTH_POINTS);
        getConditions().add(ConditionEntry.createPersistentCondition(ConditionType.MINDLESS));

    }

    @Override
    public void turn(Unit enemy) {

        VampireDrainSpell vds = new VampireDrainSpell();

        System.out.println(getName() + " trying to drain energy from " + enemy.getName());
        vds.castSpell(this, enemy);

        while (vds.hasEnoughElementsToCovertToSpell(getElements()) && (getHealth().getMaxHp() - getHealth().getHp() > 5)) {
            vds.castSpell(this, enemy);
            getElements().useElements(vds.getElements());
        }

        IceBoltSpell iceBoltSpell = new IceBoltSpell();
        iceBoltSpell.castSpellIfHasEnoughElements(this, enemy);

    }
}
