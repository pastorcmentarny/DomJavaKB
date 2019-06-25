package dms.pastor.rpg.game.units.enemies.animals;

import dms.pastor.rpg.game.characteristics.Skills;
import dms.pastor.rpg.game.characteristics.Stats;
import dms.pastor.rpg.game.commons.Result;
import dms.pastor.rpg.game.items.Inventory;
import dms.pastor.rpg.game.items.UnicornsHorn;
import dms.pastor.rpg.game.spells.RainbowVomitSpell;
import dms.pastor.rpg.game.spells.Spell;
import dms.pastor.rpg.game.units.Hero;
import dms.pastor.rpg.game.units.Unit;
import dms.pastor.rpg.game.units.enemies.Enemy;

import java.util.Random;


public class Unicorn extends Enemy {

    public Unicorn(int level) {
        setName("Unicorn");
        setDescription("Another creation of goddess of pink nails .It is genetically modified horse that vomiting rainbow.");
        psycho = true;
        skills = new Skills(12, 1, 12, 20, 5, 8);
        setup();
        bonusPerLevelStats = Stats.generateDefaultBonusStats(psycho);
        bonusPerLevelStats.addToAllStats(lvl, psycho);
        plainStats = Stats.generateStatsFromSkills(skills);
        extraStats.addHPAndMaxHP(225);
        extraStats.addMaxDMG(5 * lvl);
        inventory = new Inventory(1);
        inventory.addItem(new UnicornsHorn());
    }


    private void castBattleSpell() {
        Spell spell = new RainbowVomitSpell(this);
        System.out.println(name + " casting " + spell.getDescription());
        Result result = spell.cast(Hero.getHero());
        System.out.println(result.getMessage());
    }

    @Override
    public void beforeBattle() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void beforeTurn() {
        super.beforeTurn();
        if (new Random().nextInt(100) > 85) { //should be 85
            castBattleSpell();
        }
    }

    @Override
    public void afterBattle() {
        //NOTHING
    }

    @Override
    public boolean avoidFightDiplomacy(Unit unit) {

        //TODO implement that one type of students can avoid fight with animals if his strength and psychokinesis is higher
        System.out.println("Horses ... even magic ones can't talk");
        return false;

    }

    @Override
    public void specialAttack(Unit unit) {
        //NOTHING
    }

}
