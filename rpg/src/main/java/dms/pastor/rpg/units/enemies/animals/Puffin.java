package dms.pastor.rpg.units.enemies.animals;

import dms.pastor.rpg.cfg.Config;
import dms.pastor.rpg.characteristics.Attribute;
import dms.pastor.rpg.characteristics.Skills;
import dms.pastor.rpg.characteristics.Stats;
import dms.pastor.rpg.units.Hero;
import dms.pastor.rpg.units.Unit;
import dms.pastor.rpg.units.enemies.Enemy;
import dms.pastor.rpg.utils.RandomUtils;

import java.util.Random;

/**
 * Author Dominik Symonowicz
 * Created   08/03/13
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Puffin extends Enemy {

    public Puffin(int lvl) {
        name = RandomUtils.getRandomName(RandomUtils.getAnimalNameList()) + " - A puffin.";
        description = name + " A evil creature from Seiriol world. They exterminated Nigelian race,who was response for peace in ancient times as they had ability to close portal from evil dimensions.Puffins are response why evil get into this universe and bring doom";
        this.lvl = lvl;
        psycho = false;
        skills = Skills.generateRandomSkills(20, Config.DEFAULT_INIT_MAX_POINTS_FOR_SKILLS, false, null);
        skills.setDexterity(skills.getDexterity());
        setup();
        plainStats.setARM(0);
        bonusPerLevelStats = Stats.generateSmallBonusStats();
        plainStats = Stats.generateStatsFromSkills(skills);

        nativeAttributes.add(Attribute.BIRD);
        nativeAttributes.add(Attribute.MAGIC_RESISTANCE50);

        updateLevelFromTo(1, lvl);
    }

    @Override
    public boolean avoidFightDiplomacy(Unit unit) {
        return unit.skills.getDexterity() > skills.getDexterity();
    }

    @Override
    public void beforeBattle() {
        //NOTHING
    }

    @Override
    public void afterTurn() {
        if (new Random().nextInt(100) > 70) {
            Hero.getHero().state.setWeakness(3);
        }
        super.afterTurn();
    }

    @Override
    public void afterBattle() {
        //NOTHING
    }

    @Override
    public void specialAttack(Unit unit) {
        //NOTHING
    }

}
