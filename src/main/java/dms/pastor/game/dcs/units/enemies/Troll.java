package dms.pastor.game.dcs.units.enemies;

import dms.pastor.game.dcs.spells.FireBallSpell;
import dms.pastor.game.dcs.spells.HealSpell;
import dms.pastor.game.dcs.spells.MagicStoneSpell;
import dms.pastor.game.dcs.spells.MeteorStrikeSpell;
import dms.pastor.game.dcs.spells.Spell;
import dms.pastor.game.dcs.units.Unit;
import dms.pastor.game.dcs.units.enemies.actions.CureAction;
import dms.pastor.game.dcs.utils.random.InGameRandomiseUtils;
import dms.pastor.game.dcs.utils.random.RandomiseUtils;

import static dms.pastor.game.dcs.ElementsType.EARTH;
import static dms.pastor.game.dcs.ElementsType.FIRE;

/**
 * Author Dominik Symonowicz
 * Created 2015-08-02
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Troll extends Unit {

    private RandomiseUtils randoms = new InGameRandomiseUtils();

    public Troll() {
        super();
        setName("Troll");
        setHp(50);
    }

    @Override
    public void turn(Unit enemy) {

        if (enemy.getHp() > 2 && enemy.getHp() < 10) {
            while (getElements().getAir() >= 3) {
                System.out.println(getName() + " casting heal!");
                HealSpell spell = new HealSpell();
                spell.castSpell(this, enemy);
                getElements().setAir(getElements().getAir() - 3);
            }
        }

        new CureAction().perform(this, this);

        Spell spell = new MeteorStrikeSpell();
        while (spell.hasEnoughElementsToCovertToSpell(getElements())) {
            System.out.println(getName() + " will cast " + spell.getName());
            spell.castSpell(this, enemy);
            getElements().useElements(spell.getElements());
        }

        spell = new FireBallSpell();
        spell.castSpellIfHasEnoughElements(this, enemy);

        spell = new MagicStoneSpell();
        spell.castSpell(this, enemy);
        while (spell.hasEnoughElementsToCovertToSpell(getElements())) {
            castMagicStone(enemy, spell);
            castMagicStone(enemy, spell);
            while (randoms.isWillHappenWithProbabilityOf(50)) {
                System.out.println("Lucky extra magic stone");
                spell.castSpell(this, enemy);
            }
        }

        System.out.println(getName() + " regenerate 1 hp ");
        addHP(1);
        getElements().addElement(EARTH);
        getElements().addElement(FIRE);
    }

    private void castMagicStone(Unit enemy, Spell spell) {
        System.out.println(getName() + " will cast double magic stone!");
        if(spell.hasEnoughElementsToCovertToSpell(getElements())){
            spell.castSpell(this, enemy);
            getElements().useElements(spell.getElements());
        }
    }

}
