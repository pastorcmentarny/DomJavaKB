package dms.pastor.game.dcs.units.enemies;

import dms.pastor.game.dcs.spells.FireBall;
import dms.pastor.game.dcs.spells.HealSpell;
import dms.pastor.game.dcs.spells.MagicStone;
import dms.pastor.game.dcs.spells.MeteorStrike;
import dms.pastor.game.dcs.spells.Spell;
import dms.pastor.game.dcs.units.Unit;
import dms.pastor.game.dcs.units.enemies.actions.CureAction;
import dms.pastor.game.dcs.utils.random.InGameRandomiserUtils;
import dms.pastor.game.dcs.utils.random.RandomiserUtils;

import static dms.pastor.game.dcs.ElementsType.EARTH;
import static dms.pastor.game.dcs.ElementsType.FIRE;

/**
 * Author Dominik Symonowicz
 * Created 2015-08-02
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class Troll extends Unit {

    private RandomiserUtils randoms = new InGameRandomiserUtils();

    public Troll() {
        super();
        setName("Troll");
    }

    @Override
    public void turn(Unit enemy) {

        if (enemy.getHp() > 2 && enemy.getHp() < 10) {
            while (getElements().getLife() >= 3) {
                System.out.println(getName() + " casting heal!");
                HealSpell spell = new HealSpell();
                spell.castSpell(this, enemy);
                getElements().setLife(getElements().getLife() - 3);
            }
        }

        new CureAction().perform(this, this);

        Spell spell = new MeteorStrike();
        while (spell.hasEnoughElementsToCovertToSpell(getElements())) {
            System.out.println(getName() + " will cast " + spell.getName());
            spell.castSpell(this, enemy);
            getElements().useElements(spell.getElements());
        }

        spell = new FireBall();
        while (spell.hasEnoughElementsToCovertToSpell(getElements())) {
            System.out.println(getName() + " will cast " + spell.getName());
            spell.castSpell(this, enemy);
            getElements().useElements(spell.getElements());
        }

        spell = new MagicStone();
        spell.castSpell(this, enemy);
        while (spell.hasEnoughElementsToCovertToSpell(getElements())) {
            System.out.println(getName() + " will cast double magic stone!");

            spell.castSpell(this, enemy);
            spell.castSpell(this, enemy);
            while (randoms.isWillHappenWithProbabilityOf(50)) {
                System.out.println("Lucky extra magic stone");
                spell.castSpell(this, enemy);
            }
            getElements().useElements(spell.getElements());
        }

        System.out.println(getName() + " regenerate 1 hp ");
        addHP(1);
        getElements().addElement(EARTH);
        getElements().addElement(FIRE);
    }

}
