package dms.pastor.game.rpg.units.enemies.undead;

import dms.pastor.game.rpg.characteristics.Skills;
import dms.pastor.game.rpg.characteristics.Stats;
import dms.pastor.game.rpg.units.Hero;
import dms.pastor.game.rpg.units.Unit;
import dms.pastor.game.rpg.units.enemies.Enemy;

import java.util.Random;


public class CuteBunny extends Enemy {
    public CuteBunny(int level) {
        name = this.getClass().getSimpleName();
        description = " It looks cute,but it is deadly undead animal who sucks your life . ";//TODO implement id
        this.lvl = lvl;
        psycho = false;
        skills = new Skills(5, 0, 1, 6, 3, 0);
        setup();
        bonusPerLevelStats = new Stats(lvl / 2, 2 * lvl, 5, 0, lvl * 5, lvl * 5, 0, 0, 2, 0, 0, 0);
        plainStats = new Stats(0, level * 2, 50, 25 + (lvl - 5), (lvl * 5), lvl * 50, 0, 0, (lvl / 2), 0, 0, 0);
        updateLevelFromTo(1, lvl);
    }

    @Override
    public boolean avoidFightDiplomacy(Unit unit) {
        System.out.println(name + " don't bother to fight with cowards");
        return true;
    }

    @Override
    public void beforeBattle() {
        //nothing
    }

    @Override
    public void specialAttack() {
        Hero unit = Hero.getHero();
        System.out.println("Life sucks... and " + name + " drain your health.");
        int dmg = unit.battleStats.getMaxHP() / 50;
        unit.battleStats.doesDirectDMGtoHP(dmg);
        System.out.print(dmg + " hp from you and Vampire gain " + (dmg / 3) + " hp.\n");
        battleStats.addHP(dmg / 3);
    }

    @Override
    public void beforeTurn() {
        specialAttack();
        super.beforeTurn();
    }


    @Override
    public void afterTurn() {
        Random r = new Random();
        if (r.nextInt(100) > 80) {
            int turns = 2;
            System.out.println("Cute eyes of " + name + "hipnotise you. You are stunned for " + turns + "turn(s).");
            Hero.getHero().state.setStunned(turns);
        }
        super.afterTurn();
    }

    @Override
    public void afterBattle() {
        //NOTHING
    }

    @Override
    public void specialAttack(Unit unit) {
        //Nothing
    }

}
