package dms.pastor.game.rpg.units.characteristic;

import dms.pastor.game.rpg.characteristics.Stats;


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
