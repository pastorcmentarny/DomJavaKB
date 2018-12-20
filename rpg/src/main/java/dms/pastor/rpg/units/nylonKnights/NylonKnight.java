package dms.pastor.rpg.units.nylonKnights;

import dms.pastor.rpg.armor.SportShoes;
import dms.pastor.rpg.armor.SportTrousers;
import dms.pastor.rpg.armor.TShirt;
import dms.pastor.rpg.characteristics.Skills;
import dms.pastor.rpg.characteristics.Stats;
import dms.pastor.rpg.items.weapons.AluminiumBaseballBat;
import dms.pastor.rpg.units.Unit;
import dms.pastor.rpg.units.enemies.Enemy;


public class NylonKnight extends Enemy {
    public NylonKnight(int level) {
        name = this.getClass().getSimpleName();
        description = name + " are trained 'dresiarz ";//TODO implement id
        this.lvl = level;
        psycho = false;
        criticalChance = lvl / 2;
        skills = new Skills(10, 2, 2, 6, 6, 0);
        setup();
        bonusPerLevelStats = new Stats(3, 10, 2, 1, 25, 25, 0, 0, 1, 0, 0, 0);
        plainStats = Stats.generateStatsFromSkills(skills);

        TShirt chest = new TShirt();
        SportTrousers legs = new SportTrousers();
        SportShoes shoes = new SportShoes();
        plainStats.addArm(chest.armorPoints + legs.armorPoints + shoes.armorPoints);
        updateLevelFromTo(1, lvl);
        plainStats.addArm(lvl / 3);
        AluminiumBaseballBat bb = new AluminiumBaseballBat();
        inventory.addItem(bb);
        bb.addToStats(plainStats);
    }

    @Override
    public boolean avoidFightDiplomacy(Unit unit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void beforeBattle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void afterBattle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void specialAttack(Unit unit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
