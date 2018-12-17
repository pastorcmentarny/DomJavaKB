package dms.pastor.game.rpg.units.enemies.animals;


import dms.pastor.game.rpg.characteristics.Skills;
import dms.pastor.game.rpg.characteristics.Stats;
import dms.pastor.game.rpg.items.Inventory;
import dms.pastor.game.rpg.units.Hero;
import dms.pastor.game.rpg.units.Unit;
import dms.pastor.game.rpg.units.enemies.Enemy;
import dms.pastor.game.rpg.utils.RandomUtils;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Date: 13/03/13
 * Time: 14:58
 * To change this template use File | Settings | File Templates.
 */
public class Sheep extends Enemy {
    private final Random random = new Random();

    public Sheep(int lvl) {
        name = RandomUtils.getRandomName(RandomUtils.getAnimalNameList()) + " - A sheep.";
        description = name + " A cute animal with killer instinct. ";
        this.lvl = lvl;
        psycho = false;
        skills = new Skills(10, 1, 1, 10, 4, 0);
        setup();
        bonusPerLevelStats = new Stats(1, lvl, 2, 0, 25, 25, 0, 0, 0, 0, 0, 0);
        //bonusStats.addToAllStats(lvl,psycho);
        plainStats = Stats.generateStatsFromSkills(skills);
        plainStats.addHPAndMaxHP(5 * lvl);
        plainStats.addArm(lvl);

        inventory = new Inventory(0);
        updateLevelFromTo(1, lvl);
    }


    @Override
    public boolean avoidFightDiplomacy(Unit unit) {
        System.out.println("You can't talk to animals");
        return false;
    }

    @Override
    public void beforeBattle() {
        if (random.nextInt(100) > 50) {
            ramAttack(3);
        }
    }

    @Override
    public void beforeTurn() {
        if (random.nextInt(100) > 85) {
            ramAttack(2);
        }
    }

    @Override
    public void afterBattle() {
        Hero hero = Hero.getHero();
        if (random.nextInt(100) > hero.battleStats.getEvasion()) {
            int dmg = battleStats.getMaxHP() / 100;
            System.out.println("Sheep exploded and caused " + dmg + " to you.(your Armor will give you 50% person of normal protection)");
            hero.battleStats.doesDMG(dmg, hero.battleStats.getARM() / 2);
        }

    }

    @Override
    public void specialAttack(Unit unit) {
        //NOTHING
    }

    private void ramAttack(int turns) {
        System.out.println("Battering ram attack ... you are  stunned");
        Hero.getHero().state.setStunned(turns);
    }
}
