package dms.pastor.game.dcs.units.enemies;

import dms.pastor.game.dcs.spells.IceBoltSpell;
import dms.pastor.game.dcs.spells.VampireDrainSpell;
import dms.pastor.game.dcs.units.Unit;

import static dms.pastor.game.dcs.conditions.ConditionEntry.createPersistentCondition;
import static dms.pastor.game.dcs.conditions.ConditionType.MINDLESS;

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
        super();
        setName("Vampire");
        setSp(48);
        getConditions().add(createPersistentCondition(MINDLESS));

    }

    @Override
    public void turn(Unit enemy) {

        VampireDrainSpell vds = new VampireDrainSpell();

        System.out.println(getName() + " trying to drain energy from " + enemy.getName());
        vds.castSpell(this, enemy);

        while (vds.hasEnoughElementsToCovertToSpell(getElements()) && (getMaxHp() - getHp() > 5)) {
            vds.castSpell(this, enemy);
            getElements().useElements(vds.getElements());
        }

        IceBoltSpell iceBoltSpell = new IceBoltSpell();
        iceBoltSpell.castSpellIfHasEnoughElements(this, enemy);

    }
}
