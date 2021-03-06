package dms.pastor.rpg.game.units.enemies;

import dms.pastor.rpg.game.characteristics.Attribute;
import dms.pastor.rpg.game.characteristics.Skills;
import dms.pastor.rpg.game.characteristics.Stats;
import dms.pastor.rpg.game.items.Inventory;
import dms.pastor.rpg.game.units.Unit;
import dms.pastor.rpg.utils.RandomUtils;

/**
 * Created with IntelliJ IDEA.  Date: 05/03/13 Time: 15:56 To
 * change this template use File | Settings | File Templates.
 */
public class Mannequin extends Enemy {

    public Mannequin(int lvl) {
        name = RandomUtils.getRandomName(RandomUtils.getNameList()) + " - Mannequin";
        description = name + " .it is used for practice purposes.";
        this.lvl = lvl;
        criticalChance = 10;
        psycho = false;
        skills = new Skills(2, 0, 0, 1, 1, 0);
        setup();
        bonusPerLevelStats = Stats.generateSmallBonusStats();
        plainStats = Stats.generateStatsFromSkills(skills);
        plainStats.addHPAndMaxHP(lvl * 10);

        inventory = new Inventory(0);
        updateLevelFromTo(1, lvl);
        plainStats.setARM(lvl * 2);
        nativeAttributes.add(Attribute.UNDEAD);
        nativeAttributes.add(Attribute.MAGIC_RESISTANCE10);
        currentAttributes.addAll(nativeAttributes);
        updateToLevel(lvl);
    }

    private void updateToLevel(int lvl) {
        for (int currentLevel = 1; currentLevel <= lvl; currentLevel++) {
            levelUp();
        }
    }

    @Override
    public void levelUp() {
        plainStats.addToAllStats(1, psycho);
    }

    @Override
    public boolean avoidFightDiplomacy(Unit unit) {
        return false;
    }

    public int getExpForKill() {
        return 1;
    }

    @Override
    public void beforeBattle() {
        //NOTHING
    }

    @Override
    public void afterTurn() {
        System.out.println("Recreating default attributes");
        currentAttributes.clear();
        currentAttributes.addAll(nativeAttributes);
        super.afterTurn();
    }

    @Override
    public void afterBattle() {
        System.out.println(name + " said: Thank you for fight with me.");
    }

    @Override
    public void specialAttack(Unit unit) {
        //NOTHING
    }
}
