package dms.pastor.rpg.units.enemies.undead;

import dms.pastor.rpg.characteristics.Skills;
import dms.pastor.rpg.characteristics.Stats;
import dms.pastor.rpg.items.Book;
import dms.pastor.rpg.items.Inventory;
import dms.pastor.rpg.units.Unit;
import dms.pastor.rpg.units.enemies.Enemy;


public class Wraith extends Enemy {

    public Wraith(int level) {
        name = "Wraith";
        description = "soul ";//TODO
        this.lvl = level;
        psycho = true;
        skills = new Skills(3, 1, 5, 5, 5, 10);
        setup();
        bonusPerLevelStats = Stats.generateDefaultBonusStats(psycho);
        //bonusStats.addToAllStats(lvl,psycho);
        plainStats = Stats.generateStatsFromSkills(skills);
        extraStats.addSPAndMaxSP(lvl * 8);
        extraStats.addEvasion(33);

        inventory = new Inventory(1);
        inventory.addItem(Book.getJamesBook());
        updateLevelFromTo(1, lvl);
    }

    @Override
    public boolean avoidFightDiplomacy(Unit unit) {
        return false;
    }

    @Override
    public void beforeBattle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void afterBattle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void specialAttack(Unit unit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
