package dms.pastor.game.rpg.units.enemies.bosses;

import dms.pastor.game.rpg.characteristics.Skills;
import dms.pastor.game.rpg.characteristics.Stats;
import dms.pastor.game.rpg.items.Book;
import dms.pastor.game.rpg.items.Inventory;
import dms.pastor.game.rpg.items.questsitems.JamesConstitution;


public class JamesClarke extends Boss {
    private int defualtPointBonus = 4000;

    public JamesClarke() {
        super();
        setName("James C.");
        setDescription("He is one of the biggest villian in this game.Full of hate and passion to take control over the world");//TODO replace with proper description        
        psycho = true;
        skills = new Skills(2, 14, 12, 3, 3, 8);
        setup();
        bonusPerLevelStats = Stats.generateSmalltBonusStats();
        plainStats = Stats.generateStatsFromSkills(skills);
        plainStats.addSPandMaxSP(defualtPointBonus * 5);
        extraStats.addHPandMaxHP(defualtPointBonus);
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
