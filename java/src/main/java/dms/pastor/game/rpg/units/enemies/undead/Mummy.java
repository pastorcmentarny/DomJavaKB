package dms.pastor.game.rpg.units.enemies.undead;

import dms.pastor.game.rpg.characteristics.Skills;
import dms.pastor.game.rpg.characteristics.Stats;
import dms.pastor.game.rpg.items.Inventory;
import dms.pastor.game.rpg.items.ToiletPaper;
import dms.pastor.game.rpg.units.Unit;
import dms.pastor.game.rpg.units.enemies.Enemy;

import java.util.Random;


public class Mummy extends Enemy {

    private final Random r = new Random();

    public Mummy(int level) {
        name = this.getClass().getSimpleName();
        description = " A dead body covers filled with magic oil and cover with toilets for fashion reasons. ";//TODO implement id
        this.lvl = level;
        psycho = false;
        skills = new Skills(5, 0, 1, 6, 3, 0);
        setup();
        bonusPerLevelStats = new Stats(lvl / 2, 2 * lvl, 5, 0, lvl * 5, lvl * 5, 0, 0, 2, 0, 0, 0);
        plainStats = Stats.generateStatsFromSkills(skills);
        plainStats.addHPAndMaxHP(new Random().nextInt(5 * lvl));
        int madeFrom = r.nextInt(4) + 1;
        inventory = new Inventory(madeFrom);
        for (int i = 1; i <= madeFrom; i++) {
            inventory.addItem(new ToiletPaper());
        }

        updateLevelFromTo(1, lvl);
    }

    @Override
    public boolean avoidFightDiplomacy(Unit unit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void beforeBattle() {
        //Nothing
    }

    @Override
    public void afterTurn() {
        System.out.println("Magic balsams in toilet paper heal mummy by" + (3 * lvl) + "hp.");
        battleStats.addHP(3 * lvl);
        super.afterTurn();
    }

    @Override
    public void afterBattle() {
        //NOTHING
    }

    @Override
    public void specialAttack(Unit unit) {
        //NOTHING
    }

}
