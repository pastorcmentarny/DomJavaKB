package dms.pastor.rpg.game.units.enemies.animals;

import dms.pastor.rpg.game.cfg.Config;
import dms.pastor.rpg.game.characteristics.Skills;
import dms.pastor.rpg.game.characteristics.Stats;
import dms.pastor.rpg.game.units.Hero;
import dms.pastor.rpg.game.units.Unit;
import dms.pastor.rpg.game.units.enemies.Enemy;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Seagull extends Enemy {

    public Seagull(int lvl) {

        setName("Seagull");
        description = name + "A bird with constant diarrhea and inspired somebody to create saying \"shit hit the fan\" that describes a very bad thing happen\" as seagull's 'waste products of metabolism'  that cause poison,weakness and madness on innocent victim.Therefore,if you exterminate this evil ,You will help make better life for any animal on this planet.";
        this.lvl = lvl;
        psycho = false;
        skills = Skills.generateRandomSkills(18, Config.DEFAULT_INIT_MAX_POINTS_FOR_SKILLS, false, null);        //TODO replace null with init skills
        setup();
        bonusPerLevelStats = Stats.generateSmallBonusStats();
        bonusPerLevelStats.addToAllStats(lvl, psycho);
        plainStats = Stats.generateStatsFromSkills(skills);

        updateLevelFromTo(1, lvl);
    }

    public static void shitAttack(Unit unit) {
        int dmg = unit.plainStats.getMaxHP() / 50;
        if (dmg == 13) {
            unit.plainStats.addKarma(5);
        }
        if (dmg == 7) {
            Hero.getHero().state.setPoisoned(3, Hero.getHero().plainStats.getMaxHP() / 50);
        }
    }

    @Override
    public void beforeBattle() {
        //NOTHING
    }

    @Override
    public void beforeTurn() {
        super.beforeTurn();
    }

    @Override
    public void afterTurn() {
        System.out.println("Attempting to shit on you");
        shitEvent();
        super.afterTurn();
    }

    @Override
    public void afterBattle() {
        //NOTHING
    }

    private void shitEvent() {
        //NOTHING
    }

    @Override
    public boolean avoidFightDiplomacy(Unit unit) {
        System.out.println("This bird don't give a shit about what are you talking.");
        return false;
    }

    @Override
    public void specialAttack(Unit unit) {
        //NOTHING
    }
}
