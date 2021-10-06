package dms.pastor.rpg.game.leveling;

import dms.pastor.rpg.game.characteristics.Skills;
import dms.pastor.rpg.game.characteristics.Stats;

/**
 * Author Dominik Symonowicz
 * Created 09/01/2019
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ToStatsTransformer {
    /*
            private int strength;
    private int charisma;
    private int intelligence;
    private int vitality;
    private int dexterity; //zręczność,sprawność,zwinność)
    private int psychokinesis;

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
     */
    public Stats transform(Stats stats, Skills skills) {
        final int strength = skills.getStrength();
        stats.addToDmg(strength * 3, strength);
        stats.addHPAndMaxHP((skills.getVitality() * 6) + skills.getStrength());
        return stats;
    }
}
