package dms.pastor.game.rpg.units.enemies.bosses;

import dms.pastor.game.rpg.characteristics.Skills;
import dms.pastor.game.rpg.characteristics.Stats;
import dms.pastor.game.rpg.items.Book;
import dms.pastor.game.rpg.items.Inventory;
import dms.pastor.game.rpg.items.questsitems.JamesConstitution;


class Yogi extends Boss {
    private static String[] dariaPreTalks = {"Diana - I dropped 2 kilo! Yogi - Don't forget flush the toilet after that!",};

    public Yogi() {
        setName("Yogi");
        setDescription("He is one of the biggest villain in this game.Full of hate and passion to take control over the world");//TODO replace with proper description
        psycho = true;
        skills = new Skills(2, 14, 12, 3, 3, 8);
        setup();
        bonusPerLevelStats = Stats.generateSmallBonusStats();
        bonusPerLevelStats.addToAllStats(lvl, psycho);
        plainStats = Stats.generateStatsFromSkills(skills);
        extraStats.addHPAndMaxHP(4000);
        inventory = new Inventory(9);
        inventory.addItem(new JamesConstitution());
        inventory.addItem(Book.getJamesClarkBook());
        for (int i = 2; i < inventory.getSize(); i++) {
            inventory.addItem(Book.generateRandomBook());
        }
        updateLevelFromTo(1, 40);
    }
}
