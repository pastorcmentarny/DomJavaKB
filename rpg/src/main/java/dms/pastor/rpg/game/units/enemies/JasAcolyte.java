package dms.pastor.rpg.game.units.enemies;

import dms.pastor.rpg.game.cfg.Config;
import dms.pastor.rpg.game.characteristics.Skills;
import dms.pastor.rpg.game.characteristics.Stats;
import dms.pastor.rpg.game.items.Book;
import dms.pastor.rpg.game.items.Inventory;
import dms.pastor.rpg.game.spells.Fireball;
import dms.pastor.rpg.game.units.Hero;
import dms.pastor.rpg.game.units.Unit;


public class JasAcolyte extends Enemy {
    public JasAcolyte(int level) {
        setName("James's Acolyte");
        setDescription("One of James's follower");
        this.lvl = level;
        psycho = false;
        skills = Skills.generateRandomSkills(30, Config.DEFAULT_INIT_MAX_POINTS_FOR_SKILLS, false, null);        //TODO replace null with init skills
        setup();
        //bonusStats.addToAllStats(lvl,psycho);
        plainStats = Stats.generateStatsFromSkills(skills);
        bonusPerLevelStats = Stats.generateDefaultBonusStatsFromSkills(skills);
        plainStats.addHPAndMaxHP(10 * lvl);
        extraStats.addArm(lvl);
        inventory = new Inventory(1);
        inventory.addItem(Book.getJamesBook());
        updateLevelFromTo(1, lvl);
        plainStats.setAccuracy(75);
    }

    @Override
    public void beforeBattle() {
        //NOTHING
    }

    @Override
    public void beforeTurn() {
        super.beforeTurn();
        if (lvl >= Unit.random.nextInt(101)) {
            specialAttack();
        }
    }


    @Override
    public void afterBattle() {
        //NOTHING
    }

    @Override
    public boolean avoidFightDiplomacy(Unit unit) {
        return false;//TODO implement it
    }

    @Override
    public void specialAttack(Unit unit) {
        //NOTHING
    }

    @Override
    public void specialAttack() {
        Fireball fireball = new Fireball(this);
        System.out.println(fireball.cast(Hero.getHero()).getMessage());
    }

}
