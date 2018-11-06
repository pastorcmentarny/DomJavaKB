package dms.pastor.game.rpg.units.characteristic;

import dms.pastor.game.rpg.characteristics.Stats;


public interface StatsIncreaser {
    void increaseStats(Stats stats, Stats bonus);
}
