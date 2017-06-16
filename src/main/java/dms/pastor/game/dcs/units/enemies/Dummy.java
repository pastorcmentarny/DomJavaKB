package dms.pastor.game.dcs.units.enemies;

import dms.pastor.game.dcs.spells.FireBallSpell;
import dms.pastor.game.dcs.spells.HealSpell;
import dms.pastor.game.dcs.spells.MagicStoneSpell;
import dms.pastor.game.dcs.spells.Spell;
import dms.pastor.game.dcs.units.Unit;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-25
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Dummy extends Unit {

    public Dummy() {
        super();
        setHp(10);
    }

    public Dummy(String name) {
        super();
        setName(name);
        setHp(24);
    }

    @Override
    public void turn(Unit unit) {
        Spell spell;
        if (this.getHp() > 2 && this.getHp() < 5) {
            spell = new HealSpell();
            while (spell.hasEnoughElementsToCovertToSpell(getElements())) {
                System.out.println(getName() + " casting heal!");
                if (spell.hasEnoughElementsToCovertToSpell(getElements())) {
                    spell.castSpell(this, this);
                    getElements().useElements(spell.getElements());
                }
            }
        }

        spell = new FireBallSpell();
        if (spell.hasEnoughElementsToCovertToSpell(getElements())) {
            System.out.println(getName() + " casting fireball!");
            if (spell.hasEnoughElementsToCovertToSpell(getElements())) {
                spell.castSpell(this, unit);
                getElements().useElements(spell.getElements());
            }
        }

        spell = new MagicStoneSpell();
        while (spell.hasEnoughElementsToCovertToSpell(getElements())) {
            System.out.println(getName() + " will cast magic stone!");
            if (spell.hasEnoughElementsToCovertToSpell(getElements())) {
                spell.castSpell(this, unit);
                getElements().useElements(spell.getElements());
            }
        }
    }

}
