package dms.pastor.rpg.game.units;

import dms.pastor.rpg.game.Element;
import dms.pastor.rpg.game.cfg.Config;
import dms.pastor.rpg.game.characteristics.*;
import dms.pastor.rpg.game.commons.CLI;
import dms.pastor.rpg.game.items.Inventory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * if you idientify yourself with any of these character,then .. go to psychiatra.
 * He should solve your dillusion problems
 */
public abstract class Unit extends Element implements Cloneable, Comparable<Unit> {

    public final Random random = new Random();

    public int lvl = 1;
    public int exp = 0;
    protected int criticalChance = Config.DEFAULT_CRITICAL_CHANCE;
    public final int criticalMultiplayer = Config.DEFAULT_CRITICAL_MULTIPLAYER;
    public int nextLvlExp = Config.DEFAULT_FIRST_NEXT_LEVEL_EXP;

    public boolean isPlayer = false;
    public boolean psycho = false;

    public Skills skills;
    private SkillsType[] skillBonusTypes;

    public Stats plainStats;
    public Stats bonusPerLevelStats;
    protected Stats extraStats; // TODO implement it

    public BattleStats battleStats;
    public final ArrayList<Attribute> nativeAttributes = new ArrayList<>();
    public final ArrayList<Attribute> currentAttributes = new ArrayList<>();

    public Inventory inventory = new Inventory(0);
    public final State state = new State(currentAttributes);

    protected Unit() {

    }

    protected Unit(int level) {
        this.lvl = level;
    }

    protected Unit(String name, Skills skills, boolean psycho, int lvl) {
        this.lvl = lvl;
        this.name = name;
        this.skills = skills;
        this.psycho = psycho;
        setup();
    }

    public Unit(String name, Skills skills, boolean psycho, int lvl, SkillsType[] possibleSkillBonus) {
        this.lvl = lvl;
        this.name = name;
        this.skills = skills;
        this.psycho = psycho;

        setup();
    }


    @Override
    public String toString() {
        return name + "{" +
            //", description=" + description + //TODO undo it
            ", psycho=" + psycho + ", skills=" + skills.toString() + ", stats=" + plainStats.toString() + ", bonusStats=" + bonusPerLevelStats + ", lvl=" + lvl + ", exp=" + exp + '}';
    }

    //STATS SECTION

    protected void regenerateCurrentStatsFromSkills() {
        plainStats = null;
        plainStats = Stats.generateStatsFromSkills(skills);
        //plainStats.addStats(bonusPerLevelStats); //TODO ???
        for (int i = 1; i <= lvl; i++) {
            plainStats.levelUp(bonusPerLevelStats, psycho);

        }
    }

    public void generateBattleStats() {
        battleStats = new BattleStats(state);
        battleStats.addStats(plainStats);
        battleStats.addStats(extraStats);
    }


    public int getExpForKill(String winner) {
        int pts = (skills.getCharisma() + skills.getDexterity() + skills.getIntelligence() + skills.getPsychokinesis() + skills.getStrength() + skills.getVerbal() + skills.getVitality() + lvl) * lvl;
        System.out.println(winner + " will get " + pts + "exp for kill " + name);
        return pts;
    }

    public int getMoneyForKill() {
        int jackpot = plainStats.getARM() + plainStats.getAccuracy() + plainStats.getEvasion() + plainStats.getMaxDMG() + plainStats.getRandomDmg();
        if (jackpot < 1) {
            jackpot = 1;
        }
        return random.nextInt(jackpot);
    }


    public boolean isAlive() {
        return plainStats.getHP() > 0;
    }


    public String displayShortInfo(boolean inBattle) {
        return name + "{ Level:" + lvl + " ][ Exp/NxtLvlAt: " + exp + "/" + nextLvlExp + "][ Stats:" + (inBattle ? battleStats.getShortInfo() : plainStats.getShortInfo()) + " ][ Skills: " + skills.getShortInfo() + "]}";
    }

    protected void levelUp() {
        if (lvl < Config.MAX_LEVEL) {
            lvl++;
            Config.getExpNeededForEnemyLevel(lvl);
            System.out.println(CLI.CUTE_LINE_SEPARATOR);
            System.out.println(name + " is leveled up and is on level: " + lvl);
            System.out.println(CLI.CUTE_LINE_SEPARATOR);
            if (lvl % Config.DEFAULT_SKILL_BONUS_FREQUENCY == 0) {
                Skills.addRandomSkill(skills, SkillsType.values());
                regenerateCurrentStatsFromSkills();
                bonusPerLevelStats = Stats.generateDefaultBonusStatsFromSkills(skills);
            }
            plainStats.levelUp(bonusPerLevelStats, psycho);
        } else {
            //FIXME log.info( name + "reaches highest level and cannot be more clever.");
        }
    }


    protected void updateLevelFromTo(int from, int to) {
        if (from >= to) {
            //FIXME log.warn("You can't update " + name + " from higher level to lower.");
        }
        //FIXME log.debug("updating level from " + from + " to " + to);
        for (int i = from; i < to; i++) {
            if (i > Config.MAX_LEVEL) {
                //FIXME log.debug("You reach maximum level and you can't level up anymore.{" + Config.MAX_LEVEL + "}");
                break;
            } else {
                levelUp();
            }

        }
    }

    //TODO improve
    protected final void setup() {
        bonusPerLevelStats = new Stats();
        extraStats = new Stats();
        if (skillBonusTypes == null) {
            skillBonusTypes = SkillsType.values();
        }
        regenerateCurrentStatsFromSkills();

    }


    public boolean isCriticalChance() {
        return criticalChance > new Random().nextInt(101);
    }

    public boolean canAttack() {
        return state.isNotStunned();
    }


    public boolean canCastSpell() {
        return psycho && state.isNotStunned();
    }


    public boolean canUseItem() {
        return state.isNotStunned();
    }

    public Unit[] getUnitsSortedByInitiative(Unit[] units) {
        Arrays.sort(units);
        return units;
    }

    @Override
    public int compareTo(Unit b) {
        return this.skills.getInitiative() - b.skills.getInitiative();
    }

}
