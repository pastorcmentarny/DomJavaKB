package dms.pastor.rpg.game.units.enemies.bosses;

import dms.pastor.rpg.game.characteristics.Skills;
import dms.pastor.rpg.game.characteristics.Stats;
import dms.pastor.rpg.game.items.Book;
import dms.pastor.rpg.game.items.Inventory;
import dms.pastor.rpg.game.items.questsitems.JamesConstitution;


public class JamesClarke extends Boss {

    public JamesClarke() {
        super();
        setName("James C.");
        setDescription("He is one of the biggest villain in this game.Full of hate and passion to take control over the world");//TODO replace with proper description
        psycho = true;
        skills = new Skills(2, 14, 12, 3, 3, 8);
        setup();
        bonusPerLevelStats = Stats.generateSmallBonusStats();
        plainStats = Stats.generateStatsFromSkills(skills);
        int defaultPointBonus = 4000;
        plainStats.addSPAndMaxSP(defaultPointBonus * 5);
        extraStats.addHPAndMaxHP(defaultPointBonus);
        inventory = new Inventory(9);
        inventory.addItem(new JamesConstitution());
        inventory.addItem(Book.getJamesClarkBook());
        for (int i = 2; i < inventory.getSize(); i++) {
            inventory.addItem(Book.generateRandomBook());
        }
        updateLevelFromTo(1, 40);
        System.out.println("lvl" + lvl);
        bonusPerLevelStats.addToAllStats(lvl, psycho);
    }

    @Override
    public void beforeBattle() {
        //speech spells
    }

    @Override
    public void beforeTurn() {
        //NOTHING
    }

    @Override
    public void afterTurn() {
        //NOTHING
    }

    @Override
    public void afterBattle() {
        //NOTHING
    }

}
