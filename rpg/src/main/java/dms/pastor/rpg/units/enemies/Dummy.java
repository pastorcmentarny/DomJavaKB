package dms.pastor.rpg.units.enemies;

import dms.pastor.rpg.cfg.Config;
import dms.pastor.rpg.characteristics.Skills;
import dms.pastor.rpg.characteristics.Stats;
import dms.pastor.rpg.units.Unit;

import java.util.Random;


public class Dummy extends Enemy {

    public Dummy(int lvl) {
        if (lvl == -1) {
            lvl = new Random().nextInt(10) + 1;
//            lvl = new Random().nextInt(Config.MAX_LEVEL);
        }
        setName("Dummy " + lvl);
        setDescription("Dummy is dummy. In almost all cases is harmless.However,there is a rumor that Dummy knows deadly spell ..");
        this.lvl = lvl;
        psycho = false;
        skills = Skills.generateRandomSkills(Config.DEFAULT_POINTS_FOR_SKILLS, Config.DEFAULT_INIT_MAX_POINTS_FOR_SKILLS, false, null);        //TODO replace null with init skills
        setup();
        bonusPerLevelStats = Stats.generateSmallBonusStats();
        bonusPerLevelStats.addToAllStats(lvl, psycho);
        plainStats = new Stats(lvl, lvl, 40, 0, 30, 30, 0, 0, lvl, 0, 0, 0);

    }

    //generate event that has 1% to does dmg equals to hero health-1 (to left hero with 1 hp).If this happen ,then user will received bonus for secret discovery
    @Override
    public void beforeBattle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void beforeTurn() {
        super.beforeTurn();
    }

    @Override
    public void afterTurn() {
        //DO NOTHING
    }

    @Override
    public void afterBattle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean avoidFightDiplomacy(Unit unit) {
        System.out.println("As Dummy is dummy ,so it want fight,it doesn't understand concept of ... diplomacy");
        return false;
    }

    @Override
    public void specialAttack(Unit unit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean canAttack() {
        return true;
    }

    @Override
    public boolean canCastSpell() {
        return false;
    }

    @Override
    public boolean canUseItem() {
        return false;
    }

}
