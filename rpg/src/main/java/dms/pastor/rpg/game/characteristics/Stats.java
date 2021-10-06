package dms.pastor.rpg.game.characteristics;

import dms.pastor.rpg.game.cfg.Config;

import java.util.Random;


/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Stats {

    private int minDMG = 0;
    private int maxDMG = 0;
    private int accuracy = 0;
    private int evasion = 0;
    private int HP;
    private int maxHP = 0;
    private int SP = 0;
    private int maxSP = 0;
    private int ARM = 0;
    private int mana = 0;
    private int maxMana = 0;
    private int karma = 0;
    private int criticalChance = Config.DEFAULT_CRITICAL_CHANCE;
    private Random random = new Random();

    public Stats() {

    }

    public Stats(int minDMG, int maxDMG, int accuracy, int evasion, int HP, int maxHP, int SP, int maxSP, int ARM, int mana, int maxMana, int karma) {
        this.minDMG = minDMG;
        this.maxDMG = maxDMG;
        this.accuracy = accuracy;
        this.evasion = evasion;
        this.HP = HP;
        this.maxHP = maxHP;
        this.SP = SP;
        this.maxSP = maxSP;
        this.ARM = ARM;
        this.mana = mana;
        this.maxMana = maxMana;
        this.karma = karma;
    }

    static int calcBonus(int stat1, int stat2, int divider) {
        return (stat1 + stat2) / divider;
    }

    public static Stats generateDefaultBonusStatsFromSkills(Skills skills) {
        Stats stats = new Stats();
        stats.setARM((skills.getVitality() / 8) + (skills.getStrength() / 8));
        stats.setAccuracy((skills.getDexterity() / 2) + (skills.getIntelligence() / 8));
        stats.setEvasion(skills.getDexterity() / 9);
        stats.setHP(10 + (skills.getStrength()) + (skills.getVitality() * 2));
        stats.setMaxHP(stats.getHP());
        stats.setMana(skills.getIntelligence() / 2 + (skills.getPsychokinesis() * 2));
        stats.setMaxMana(stats.getMana());
        stats.setMinDMG(skills.getStrength() / 2);
        stats.setMaxDMG((skills.getStrength()) + skills.getIntelligence() / 4);
        stats.setKarma(1);
        return stats;
    }

    /*
     karma is a not part of generation. 
     */
    public static Stats generateStatsFromSkills(Skills skills) {
        Stats stats = new Stats();
        stats.setARM((skills.getVitality() / 4) + (skills.getStrength() / 4));
        stats.setAccuracy(40 + (skills.getDexterity() * 2) + (skills.getIntelligence() / 2));
        stats.setEvasion(1 + (skills.getDexterity() / 2));
        stats.setHP(10 + (skills.getStrength() * 2) + (skills.getVitality() * 6));
        stats.setMaxHP(stats.getHP());
        stats.setMana(skills.getIntelligence() + skills.getPsychokinesis() * 4);
        stats.setMaxMana(stats.getMana());
        stats.setMinDMG(skills.getStrength());
        stats.setMaxDMG((skills.getStrength() * 5 / 2) + skills.getIntelligence());
        return stats;
    }

    public static Stats addDefaultBonusFromSkills(Skills skills, Stats stats, boolean psycho, boolean magicShield) {

        int bonus = (skills.getVitality() + skills.getStrength()) / 12;
        stats.setARM(bonus);
        bonus = (skills.getDexterity() + (skills.getIntelligence() / 5)) / 4;
        stats.addAccuracy(bonus);
        stats.addEvasion(skills.getDexterity() / 9);
        bonus = (skills.getStrength() * 3 / 4) + skills.getVitality() * 4;
        stats.addHPAndMaxHP(bonus);
        bonus = skills.getPsychokinesis() * 3 + skills.getIntelligence();
        if (psycho) {
            stats.addManaAndMaxMana(bonus);
        }
        bonus = skills.getPsychokinesis() * 4;
        if (magicShield) {
            stats.addSPAndMaxSP(bonus);
        }
        stats.addMinDMG(skills.getStrength() / 2);
        stats.addMaxDMG(((skills.getStrength() * 3 / 4) + 2) + skills.getIntelligence() / 5);
        return stats;
    }

    public static Stats generateDefaultBonusStats(boolean psycho) {
        int psychoBonus = 0;
        if (psycho) {
            psychoBonus = 12;
        }
        return new Stats(1, 3, 2, 2, 24, 24, 0, 0, 0, psychoBonus, psychoBonus, 1);
    }

    public static Stats generateSmallBonusStats() {
        return new Stats(1, 2, 2, 2, 10, 10, 0, 0, 0, 0, 0, 0);
    }

    public static Stats generateZeroStats() {
        return new Stats(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    /**
     * @return the minDMG
     */
    public int getMinDMG() {
        return minDMG;
    }

    /**
     * @param minDMG the minDMG to set
     */
    public void setMinDMG(int minDMG) {
        this.minDMG = minDMG;
    }

    /**
     * @return the maxDMG
     */
    public int getMaxDMG() {
        return maxDMG;
    }

    /**
     * @param maxDMG the maxDMG to set
     */
    public void setMaxDMG(int maxDMG) {
        this.maxDMG = maxDMG;
    }

    /**
     * @return the accuracy
     */
    public int getAccuracy() {
        return accuracy;
    }

    /**
     * @param accuracy the accuracy to set
     */
    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    /**
     * @return the evasion
     */
    public int getEvasion() {
        return evasion;
    }

    /**
     * @param evasion the evasion to set
     */
    public void setEvasion(int evasion) {
        this.evasion = evasion;
    }

    /**
     * @return the HP
     */
    public int getHP() {
        return HP;
    }

    /**
     * @param HP the HP to set
     */
    public void setHP(int HP) {
        this.HP = HP;
    }

    /**
     * @return the SP
     */
    public int getSP() {
        return maxSP;
    }

    /**
     * @param SP the SP to set
     */
    public void setSP(int SP) {
        this.maxSP = SP;
    }

    /**
     * @return the ARM
     */
    public int getARM() {
        return ARM;
    }

    /**
     * @param ARM the ARM to set
     */
    public void setARM(int ARM) {
        this.ARM = ARM;
    }

    /**
     * @return the mana
     */
    public int getMana() {
        return mana;
    }

    /**
     * @param mana the mana to set
     */
    public void setMana(int mana) {
        this.mana = mana;
    }

    public void addStats(Stats anotherStats) {
        minDMG += anotherStats.getMinDMG();
        maxDMG += anotherStats.getMaxDMG();
        accuracy += anotherStats.getAccuracy();
        evasion += anotherStats.getEvasion();
        HP += anotherStats.getHP();
        maxHP += anotherStats.getMaxHP();
        SP += anotherStats.getSP();
        maxSP += anotherStats.getMaxSP();
        ARM += anotherStats.getARM();
        mana += anotherStats.getMana();
        maxMana += anotherStats.getMana();
    }

    public void levelUp(Stats lvlUpBonus, boolean psycho) {
        minDMG += lvlUpBonus.getMinDMG();
        maxDMG += lvlUpBonus.getMaxDMG();
        accuracy += lvlUpBonus.getAccuracy();
        evasion += lvlUpBonus.getEvasion();
        maxHP += lvlUpBonus.getHP();
        maxSP += lvlUpBonus.getSP();
        ARM += lvlUpBonus.getARM();
        if (psycho) {
            mana += lvlUpBonus.getMana();
            maxMana += lvlUpBonus.getMaxMana();
        }
        karma += lvlUpBonus.getKarma();
    }

    @Override
    public String toString() {
        return "Stats{" + "minDMG=" + minDMG + ", maxDMG=" + maxDMG + ", accuracy=" + accuracy + ", evasion=" + evasion + ", HP=" + maxHP + ", SP=" + maxSP + ", ARM=" + ARM + ", mana=" + mana + ", maxMana=" + maxMana + '}';
    }

    public int getRandomDmg() {
        return minDMG + new Random().nextInt(maxDMG - minDMG + 1);

    }

    public void addToAllStats(int pts, boolean psycho) {
        minDMG += pts;
        maxDMG += pts;
        accuracy += pts;
        evasion += pts;
        maxHP += pts;
        ARM += pts;
        if (psycho) {
            SP += pts;
            maxSP += pts;
            mana += pts;
            maxMana += pts;
        }
        //karma is not part of standard stats
    }

    void addRandomPointsToStats() {

    }

    public void AddRandomPointToStats(boolean psycho) {
        int number = psycho ? 24 : 16;

        switch (random.nextInt(number)) {
            case 0, 1, 2 -> {
                minDMG += 1;
                maxDMG += 1;
            }
            case 3, 4, 5 -> maxDMG += 1;
            case 6, 7 -> accuracy += 1;
            case 8, 9 -> evasion += 1;
            case 10, 11, 12, 13, 14 -> {
                HP += 1;
                maxHP += 1;
            }
            case 15 -> ARM += 1;
            case 16, 17, 18, 19 -> {
                SP += 1;
                maxSP += 1;
            }
            case 20, 21, 22, 23 -> {
                mana += 1;
                maxMana += 1;
            }
            default -> System.err.println("unknown selection for AddRandomPointToStats");
        }

    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getMaxSP() {
        return maxSP;
    }

    public void setMaxSP(int maxSP) {
        this.maxSP = maxSP;
    }

    public boolean isAlive() {
        return HP > 0;
    }

    public String getShortInfo() {
        return "Dmg:" + minDMG + "-" + maxDMG + " acc:" + accuracy + " ev:" + evasion + " HP: " + HP + "/" + maxHP + " SP: " + SP + "/" + maxSP + " arm:" + ARM + "  mana:" + mana + "/" + maxMana;

    }

    public int getMaxMana() {
        return maxMana;
    }

    private void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public void addKarma(int i) {
        this.karma += i;
    }

    public void addHealth(int healBy) {
        HP += healBy;
        if (HP > maxHP) {
            HP = maxHP;
        }
    }


    public void addHPAndMaxHP(int value) {
        if (value >= 0) {
            maxHP += value;
            HP = maxHP;
        }
    }

    public void useMP(int manaCost) {
        mana -= manaCost;
    }

    public int doesDMG(int dmg, int arm) {
        if (SP > 0) {
            SP -= dmg;
            if (SP < 0) {
                dmg = Math.abs(SP);
                SP = 0;
            }
        }
        dmg -= arm;
        if (dmg <= 1) {
            dmg = 1;
        }
        HP -= dmg;
        return dmg;
    }

    public void doesDirectDMGtoHP(int dmg) {
        HP -= dmg;
    }

    public void addMaxDMG(int i) {
        //log.debug("Max dmg " + maxDMG +"will be increased by " + i);
        maxDMG += i;
    }

    public void addMinDMG(int minDMG) {
        //log.debug("Min dmg ");
        this.minDMG += minDMG;
    }

    public void addAccuracy(int accuracy) {
        this.accuracy += accuracy;
    }

    public void addEvasion(int evasion) {
        this.evasion += evasion;
    }

    public void addArm(int arm) {
        this.ARM += arm;
    }

    public void restoreAll() {
        restoreHP();
        restoreMP();
        restoreSP();
    }

    private void restoreHP() {
        HP = maxHP;
    }

    private void restoreMP() {
        mana = maxMana;
    }

    private void restoreSP() {
        SP = maxSP;
    }

    public void addStatsFromWeapon() {

    }

    public void addSPAndMaxSP(int value) {
        if (value >= 0) {
            maxSP += value;
            SP = maxSP;
        }
    }

    private int getKarma() {
        return karma;
    }

    private void setKarma(int karma) {
        this.karma = karma;
    }

    public int getCriticalChance() {
        return criticalChance;
    }

    public void setCriticalChance(int criticalChance) {
        this.criticalChance = criticalChance;
    }

    private void addManaAndMaxMana(int bonus) {
        this.mana += bonus;
        this.maxMana += bonus;
    }

    public void addToDmg(int dmg, int extension) {
        if (extension < 0) {
            throw new IllegalArgumentException("Extension should be 0 or bigger");
        } else if (extension == 0) {
            minDMG += dmg;
            maxDMG += dmg;
        } else {
            int difference = dmg - (2 * extension);
            if (difference < 0) {
                maxDMG += dmg;
            } else {
                minDMG += (dmg - (2 * extension));
                maxDMG += dmg + extension;
            }

        }
    }

}
