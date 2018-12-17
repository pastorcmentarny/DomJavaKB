package dms.pastor.game.rpg.units.enemies.undead;

import dms.pastor.game.rpg.characteristics.Skills;
import dms.pastor.game.rpg.characteristics.Stats;
import dms.pastor.game.rpg.items.Book;
import dms.pastor.game.rpg.items.Inventory;
import dms.pastor.game.rpg.units.Hero;
import dms.pastor.game.rpg.units.Unit;
import dms.pastor.game.rpg.units.enemies.Enemy;

/**
 * @author Pastor
 * Created Feb 15, 2015 at 12:19:49 AM
 */
public class Vampire extends Enemy {

    public Vampire(int level) {
        name = "Vampire";
        description = "Each student morph into vampire in order survive  infinite amount of assigment and prepare to endless exams.";
        this.lvl = level;
        psycho = false;
        skills = new Skills(6, 4, 7, 15, 6, 2);
        setup();
        bonusPerLevelStats = Stats.generateDefaultBonusStats(psycho);
        //bonusStats.addToAllStats(lvl,psycho);
        plainStats = Stats.generateStatsFromSkills(skills);
        extraStats.addHPAndMaxHP(5 * lvl);

        inventory = new Inventory(1);
        inventory.addItem(Book.getJamesBook());
        updateLevelFromTo(1, lvl);
    }


    @Override
    public boolean avoidFightDiplomacy(Unit unit) {
        return skills.getDexterity() > unit.skills.getDexterity();
    }

    @Override
    public void beforeBattle() {

    }

    @Override
    public void afterTurn() {
        specialAttack(Hero.getHero());
        super.afterTurn();
    }

    @Override
    public void afterBattle() {
        //nothing
    }

    @Override
    public void specialAttack(Unit unit) {
        System.out.println("Life sucks... and Vampire drain ");
        int dmg = unit.battleStats.getMaxHP() / 33;
        unit.battleStats.doesDirectDMGtoHP(dmg);
        System.out.print(dmg + " hp from you and Vampire gain " + (dmg / 3) + " hp.\n");
        battleStats.addHP(dmg / 3);
    }


}
