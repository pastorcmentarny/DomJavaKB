package dms.pastor.rpg.game.units.enemies;


import dms.pastor.rpg.game.characteristics.Skills;
import dms.pastor.rpg.game.characteristics.Stats;
import dms.pastor.rpg.game.items.Book;
import dms.pastor.rpg.game.items.Inventory;
import dms.pastor.rpg.game.units.Unit;
import dms.pastor.rpg.utils.RandomUtils;

/**
 * Created with IntelliJ IDEA.
 * User:
 * Date: 13/03/13
 * Time: 17:19
 * To change this template use File | Settings | File Templates.
 */
public class Myfyriwr extends Enemy {
    public Myfyriwr(int lvl) {
        name = RandomUtils.getRandomName(RandomUtils.getNameList()) + " - Myfyriwr";
        description = name + " A student from planet Earth, who went to the student party and end up in this world.Now is spread vomit everywhere and ruins beauty of this world.";
        this.lvl = lvl;
        psycho = false;
        skills = new Skills(4, 4, 4, 4, 4, 4);
        setup();
        extraStats = new Stats(4, 8, 20, 0, 40, 40, 0, 0, 0, 0, 0, 0);
        bonusPerLevelStats = Stats.generateSmallBonusStats();
        //bonusStats.addToAllStats(lvl,psycho);


        inventory = new Inventory(1);
        inventory.addItem(Book.getJamesBook());
        updateLevelFromTo(1, lvl);


    }

    public void levelUp() {
        plainStats.addToAllStats(1, psycho);
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
        //NOTHING
    }

    @Override
    public int getExpForKill(String winner) {
        System.out.println(winner + " will get  1 exp for kill " + name);
        return 1;
    }

    @Override
    public void specialAttack(Unit unit) {
        //NOTHING
    }


}
