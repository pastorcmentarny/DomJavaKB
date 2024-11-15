package dms.pastor.prototypes.dcs.units.enemies;

import dms.pastor.prototypes.dcs.Config;
import dms.pastor.prototypes.dcs.spells.FireBallSpell;
import dms.pastor.prototypes.dcs.spells.HealSpell;
import dms.pastor.prototypes.dcs.spells.MagicStoneSpell;
import dms.pastor.prototypes.dcs.spells.Spell;
import dms.pastor.prototypes.dcs.units.Unit;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-25
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Dummy extends Unit {
    private final int initialHp = Config.DEFAULT_HEALTH_POINTS / 2;

    Dummy() {
        getHealth().setHp(initialHp);
    }

    public Dummy(String name) {
        setName(name);
        getHealth().setHp(initialHp);
    }

    @Override
    public void turn(Unit unit) {
        Spell spell;
        if (this.getHealth().getHp() > 2 && this.getHealth().getHp() < 5) {
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
        spell.castSpellIfHasEnoughElements(this, unit);

        spell = new MagicStoneSpell();
        spell.castSpellAsLongAsItHasEnoughElements(this, unit);

    }

}
