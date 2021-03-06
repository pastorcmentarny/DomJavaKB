package dms.pastor.rpg.game.spells;

import dms.pastor.domain.Result;
import dms.pastor.rpg.game.units.Hero;
import dms.pastor.rpg.game.units.Unit;


public class HealSpell extends Spell {
    private final boolean inBattle;

    public HealSpell(boolean inBattle) {
        name = "Heal";
        description = "This spell heals you";
        this.inBattle = inBattle;
        manaCost = 25;
    }

    @Override
    public Result cast(Hero hero) {
        int healBy = hero.lvl * hero.skills.getPsychokinesis();
        if (inBattle) {
            hero.battleStats.addHealth(healBy);
        } else {
            hero.plainStats.addHealth(healBy);
        }
        return new Result(true, hero.getName() + " was healed by " + healBy + " hp.");
    }

    @Override
    public Result cast(Unit unit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Result cast(Hero hero, Unit[] units) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
