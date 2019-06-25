package dms.pastor.rpg.game.units.characteristic;

import dms.pastor.rpg.game.characteristics.Stats;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class LinearStatsIncreaser implements StatsIncreaser {

    @Override
    public void increaseStats(Stats stats, Stats bonus) {
        stats.setARM(stats.getARM() + bonus.getARM());
        stats.setAccuracy(stats.getAccuracy() + bonus.getAccuracy());
        stats.setEvasion(stats.getEvasion() + bonus.getEvasion());
        stats.setHP(stats.getHP() + bonus.getHP());
        stats.setMana(stats.getMana() + bonus.getMana());
        stats.setMaxDMG(stats.getMaxDMG() + bonus.getMaxDMG());
        stats.setMaxSP(stats.getMaxSP() + bonus.getMaxSP());
        stats.setMinDMG(stats.getMinDMG() + bonus.getMinDMG());
        stats.setSP(stats.getSP() + bonus.getSP());
    }

}
