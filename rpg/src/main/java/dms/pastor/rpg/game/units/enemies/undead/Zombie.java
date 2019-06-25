package dms.pastor.rpg.game.units.enemies.undead;

import dms.pastor.rpg.game.characteristics.Skills;
import dms.pastor.rpg.game.characteristics.Stats;
import dms.pastor.rpg.game.items.Inventory;
import dms.pastor.rpg.game.items.Items;
import dms.pastor.rpg.game.units.Hero;
import dms.pastor.rpg.game.units.Unit;
import dms.pastor.rpg.game.units.enemies.Enemy;

import java.util.Random;


public class Zombie extends Enemy {

    public Zombie(int level) {
        name = this.getClass().getSimpleName();
        description = " A dead body covers filled with magic oil and cover with toilets for fashion reasons. ";//TODO implement id
        this.lvl = level;
        psycho = false;
        skills = new Skills(5, 0, 1, 6, 3, 0);
        setup();
        bonusPerLevelStats = new Stats(lvl / 2, 2 * lvl, 5, 0, lvl * 5, lvl * 5, 0, 0, 2, 0, 0, 0);
        plainStats = Stats.generateStatsFromSkills(skills);
        plainStats.addHPAndMaxHP(new Random().nextInt(5 * lvl));

        if (random.nextBoolean()) {
            inventory = new Inventory(1);
            inventory.addItem(Items.generateRubbishItem());
        }

        updateLevelFromTo(1, lvl);
    }

    @Override
    public boolean avoidFightDiplomacy(Unit unit) {
        System.out.println("Zombie need food and you looks delicious");
        return true;
    }

    @Override
    public void beforeBattle() {
        if (random.nextInt(101) <= 40) {
            System.out.println("Zombie vomited on you and you got minor disease");
            specialAttack(null);// improve it
        }

    }

    @Override
    public void afterBattle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void specialAttack(Unit unit) {
        Hero.getHero().state.setDisease(3);
    }

}
