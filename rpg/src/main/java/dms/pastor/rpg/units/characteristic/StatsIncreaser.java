package dms.pastor.rpg.units.characteristic;

import dms.pastor.rpg.characteristics.Stats;


interface StatsIncreaser {
    void increaseStats(Stats stats, Stats bonus);
}
