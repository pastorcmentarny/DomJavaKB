package dms.pastor.rpg.game.units.enemies.bosses;

import dms.pastor.rpg.game.armor.SportShoes;
import dms.pastor.rpg.game.armor.SportTrousers;
import dms.pastor.rpg.game.armor.TShirt;
import dms.pastor.rpg.game.characteristics.Skills;
import dms.pastor.rpg.game.characteristics.Stats;
import dms.pastor.rpg.game.items.weapons.*;
import dms.pastor.rpg.game.spells.AcidRainSpell;
import dms.pastor.rpg.game.units.Hero;
import dms.pastor.rpg.game.units.Unit;

import java.util.Random;

/*
Ola's attacks : warkocz Jak maczuga , spell acid spot attack(DMG + 10% ze zniszczy bron)... ola ma tyle pryszczy,

 */
public class OlaZ extends Boss {
    private int updateTo;

    public OlaZ(int stage) {
        switch (stage) {
            case 1:
                updateTo = 10;
                break;
            case 2:
                updateTo = 20;
                break;
            case 3:
                updateTo = 40;
                break;
            case 4:
                updateTo = 80;
                break;
            default:
                lvl = Hero.getHero().lvl;
        }
        setName("Ola Z");
        setDescription("Ola - a pure evil and perfect villain.");
        psycho = true;
        skills = new Skills(15, 6, 7, 4, 4, 4);
        bonusPerLevelStats = new Stats(2, 4, 5, 0, 25, 25, 10, 10, 1, 10, 10, 0);
        extraStats = new Stats();
        regenerateCurrentStatsFromSkills();
        if (updateTo > 1) {
            updateLevelFromTo(1, updateTo);
        }
        plainStats = Stats.generateStatsFromSkills(skills);
        TShirt chest = new TShirt();
        SportTrousers legs = new SportTrousers();
        SportShoes shoes = new SportShoes();
        plainStats.addArm(chest.armorPoints + legs.armorPoints + shoes.armorPoints);

        plainStats.addArm(lvl / 3);
        Weapon bb;
        if (lvl > 70) {
            bb = new MeteorFiberBasketballBall();
            plainStats.addHPAndMaxHP(lvl * lvl * 100);
        } else if (lvl >= 40) {
            bb = new CarbonFiberBaseballBat();
            plainStats.addHPAndMaxHP(lvl * 100);
        } else if (lvl > 10) {
            bb = new AluminiumBaseballBat();
            plainStats.addHPAndMaxHP(1000);
        } else {
            bb = new BaseballBat();
        }
        inventory.addItem(bb);
        bb.addToStats(plainStats);
        skills.setStrength(skills.getStrength() + 10);


    }

    @Override
    public void beforeTurn() {
        super.beforeTurn();
        if (random.nextInt(101) < 40) {
            System.out.println("Pimples attack..");
            AcidRainSpell pimples = new AcidRainSpell(this);
            pimples.cast(Hero.getHero());
        }

    }

    @Override
    public void afterTurn() {
        if (random.nextInt(101) < 60) {
            System.out.println("Braid attack..");
            if (random.nextBoolean()) {
                int dmg = Hero.getHero().battleStats.doesDMG(lvl * skills.getStrength(), battleStats.getARM());
                System.out.print(" .. and hit you and cause " + dmg + "  damage.");


            }
        }
        state.afterTurn();
    }

    public void useAbility(Hero hero, Unit enemy) {
        if (new Random().nextInt(100) < 7) {
            int noOfFatDrops = new Random().nextInt(28);
            int dmg = 0;
            int totalDmg = 0;
            for (int i = 0; i < noOfFatDrops; i++) {
                dmg = new Random().nextInt(2 * enemy.lvl);
                totalDmg += dmg;
            }
            System.out.println(hero.getName() + " does " + totalDmg + " from PMS attack");
            hero.plainStats.doesDMG(totalDmg, battleStats.getARM());
        }
    }
}
