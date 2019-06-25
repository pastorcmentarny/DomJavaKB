package dms.pastor.rpg.game.items.food;

import dms.pastor.rpg.game.units.Hero;

import java.util.Random;


public class Kebab extends FoodItem {


    public Kebab(int energy, int poisonChance, int value) {
        super(energy, poisonChance, value);
        setName("Kebab");
        setDescription("A tasty junk food.Lots of everything ... lot's of calories ,lot's of chance to get poison and etc.");
    }


    @Override
    public void eat(Hero hero) {
        Random random = new Random();
        int chance = random.nextInt(101);
        poisonChance += 10;
        System.out.println("You got " + poisonChance + "% to get poisoned(+10% as it is kebab)");
        if (chance > poisonChance) {
            hero.plainStats.setHP(hero.plainStats.getHP() - (hero.plainStats.getHP() / 8));
        } else {
            System.out.println("You enjoyed a delicious kebab that get you some health");
            hero.addHealthByPercent(10);
        }
    }

}
