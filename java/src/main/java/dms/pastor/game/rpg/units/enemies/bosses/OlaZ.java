package dms.pastor.game.rpg.units.enemies.bosses;

import dms.pastor.game.rpg.units.Hero;
import dms.pastor.game.rpg.units.Unit;
import dms.pastor.game.rpg.armor.SportShoes;
import dms.pastor.game.rpg.armor.SportTrousers;
import dms.pastor.game.rpg.armor.TShirt;
import dms.pastor.game.rpg.characteristics.Skills;
import dms.pastor.game.rpg.characteristics.Stats;
import dms.pastor.game.rpg.items.weapons.*;
import dms.pastor.game.rpg.spells.AcidRainSpell;

import java.util.Random;


public class OlaZ extends Boss {
    int updateTo;

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
        setDescription("Ola - a pure evil and perfect vilian.");
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
            plainStats.addHPandMaxHP(lvl * lvl * 100);
        } else if (lvl >= 40) {
            bb = new CarbonFiberBaseballBat();
            plainStats.addHPandMaxHP(lvl * 100);
        } else if (lvl > 10) {
            bb = new AluminiumBaseballBat();
            plainStats.addHPandMaxHP(1000);
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
            int noOfFatdrops = new Random().nextInt(28);
            int dmg = 0;
            int totalDmg = 0;
            for (int i = 0; i < noOfFatdrops; i++) {
                dmg = new Random().nextInt(2 * enemy.lvl);
                totalDmg += dmg;
            }
            System.out.println(hero.getName() + " does " + totalDmg + " from PMS attack");
            hero.plainStats.doesDMG(totalDmg, battleStats.getARM());
        }
    }
}
