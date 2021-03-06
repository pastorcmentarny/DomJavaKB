package dms.pastor.rpg.game.units.enemies.cs;

import dms.pastor.rpg.game.characteristics.Skills;
import dms.pastor.rpg.game.characteristics.Stats;
import dms.pastor.rpg.game.items.Book;
import dms.pastor.rpg.game.items.Inventory;
import dms.pastor.rpg.game.items.questsitems.FloppyDisk;
import dms.pastor.rpg.game.units.enemies.bosses.Boss;

/**
 * @author dominiksymonowicz
 */
class NighelHardy extends Boss {
    //60% to make you sleep,(20% if you are resist to sleep
    // cast random offensive and defensive spell every turn
    // low HP ,but  very high 

    public NighelHardy() {
        setName("Nighel H.");
        setDescription("He is a famous teacher as he is always challenge,there ");//TODO
        psycho = true;
        skills = new Skills(4, 10, 9, 3, 5, 9);
        setup();
        bonusPerLevelStats = Stats.generateSmallBonusStats();
        bonusPerLevelStats.addToAllStats(lvl, psycho);
        plainStats = Stats.generateStatsFromSkills(skills);
        extraStats.addHPAndMaxHP(2000);
        inventory = new Inventory(2);
        inventory.addItem(new FloppyDisk());
        for (int i = 2; i < inventory.getSize(); i++) {
            inventory.addItem(Book.generateRandomBook());
        }
        updateLevelFromTo(1, 25);
    }
}
