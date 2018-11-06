package dms.pastor.game.rpg.units.enemies;

import dms.pastor.game.rpg.units.Unit;
import dms.pastor.game.rpg.cfg.Config;
import dms.pastor.game.rpg.characteristics.Skills;
import dms.pastor.game.rpg.characteristics.Stats;
import dms.pastor.game.rpg.commons.Msg;
import dms.pastor.game.rpg.utils.RandomUtils;


public class Peasant extends Enemy {
    public Peasant(int level) {
        name = RandomUtils.getRandomName(RandomUtils.getStudentList());
        description = "a foolish and gullible farmer of low social status.";
        this.lvl = lvl;
        psycho = false;
        skills = Skills.generateRandomSkills(18, Config.DEFAULT_INIT_MAX_POINTS_FOR_SKILLS, false, null);        //TODO replace null with init skills
        setup();
        bonusPerLevelStats = Stats.generateSmalltBonusStats();
        bonusPerLevelStats.addToAllStats(lvl, psycho);
        plainStats = Stats.generateStatsFromSkills(skills);

        updateLevelFromTo(1, lvl);
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
        boolean wantFight = unit.skills.getStrength() > skills.getStrength();
        System.out.println(name + " uses strength as  'as unit of measure for who is right. After compare muscles " + name + " wants " + Msg.isWantFight(wantFight));
        return wantFight;
    }

    @Override
    public void specialAttack(Unit unit) {
        //NOTHING
    }

}
