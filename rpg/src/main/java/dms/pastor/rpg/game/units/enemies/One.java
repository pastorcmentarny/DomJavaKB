package dms.pastor.rpg.game.units.enemies;

import dms.pastor.rpg.game.characteristics.Skills;
import dms.pastor.rpg.game.characteristics.Stats;
import dms.pastor.rpg.game.units.Unit;


public class One extends Enemy {
    private final Skills oneSkills = new Skills(1, 1, 1, 1, 1, 1);
    private final Stats oneStats = new Stats(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);


    public One() {
        lvl = 1;
        generateUnitData();
    }


    public One(int level) {
        this.lvl = level;
        generateUnitData();
    }

    private void generateUnitData() {
        setName("one");
        psycho = false;

        bonusPerLevelStats = Stats.generateDefaultBonusStats(psycho);
        this.skills = oneSkills;
        setup();

        bonusPerLevelStats = new Stats(oneStats.getMinDMG(), oneStats.getMaxDMG(), oneStats.getAccuracy(), oneStats.getEvasion(), oneStats.getHP(), oneStats.getMaxHP(), oneStats.getSP(), oneStats.getMaxSP(), oneStats.getARM(), oneStats.getMana(), oneStats.getMaxMana(), 0);
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
