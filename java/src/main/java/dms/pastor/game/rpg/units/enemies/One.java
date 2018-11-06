package dms.pastor.game.rpg.units.enemies;

import dms.pastor.game.rpg.units.Unit;
import dms.pastor.game.rpg.characteristics.Skills;
import dms.pastor.game.rpg.characteristics.Stats;


public class One extends Enemy {
    private Skills xskills = new Skills(1, 1, 1, 1, 1, 1);
    private Stats xstats = new Stats(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);


    public One() {
        lvl = 1;
        generateUnitData();
    }


    public One(int level) {
        this.lvl = level;
        generateUnitData();
    }

    public final void generateUnitData() {
        setName("one");
        psycho = false;

        bonusPerLevelStats = Stats.generateDefaultBonusStats(psycho);
        this.skills = xskills;
        setup();

        bonusPerLevelStats = new Stats(xstats.getMinDMG(), xstats.getMaxDMG(), xstats.getAccuracy(), xstats.getEvasion(), xstats.getHP(), xstats.getMaxHP(), xstats.getSP(), xstats.getMaxSP(), xstats.getARM(), xstats.getMana(), xstats.getMaxMana(), 0);
        regenerateCurrentStatsFromSkills();

    }

    @Override
    public void beforeBattle() {
        //NOTHING
    }


    @Override
    public void afterBattle() {
        //NOTHING
    }

    @Override
    public boolean avoidFightDiplomacy(Unit unit) {
        System.out.println("One has only one answer .... let's fight now.");
        return false;
    }

    @Override
    public void specialAttack(Unit unit) {
        //NOTHING
    }


}
