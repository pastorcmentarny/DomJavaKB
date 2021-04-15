package dms.pastor.rpg.game.spells;

import dms.pastor.rpg.game.Element;
import dms.pastor.rpg.game.characteristics.Stats;
import dms.pastor.domain.Result;
import dms.pastor.rpg.game.units.Hero;
import dms.pastor.rpg.game.units.Unit;

import java.util.Random;


public abstract class Spell extends Element {
    final Random random = new Random();
    int manaCost;
    boolean usedInBattle = false;
    boolean usedInWorld = false;


    public abstract Result cast(Hero hero);

    public abstract Result cast(Unit unit);

    public abstract Result cast(Hero hero, Unit[] units);

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    private boolean canCastSpell(Stats stats) {
        return stats.getHP() >= manaCost;
    }


    public boolean takeManaForSpell(Stats stats) {
        if (canCastSpell(stats)) {
            stats.useMP(manaCost);
            return true;
        } else {
            return false;
        }

    }
}
