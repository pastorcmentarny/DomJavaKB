package dms.pastor.rpg.units.npc;

import java.util.Random;


public class Selienta extends NPC {

    private final String[] dishes = {"Sichuan Beef", "Kung pao Chicken", "Bigos", "Gularz", "Lasagna"};

    public Selienta() {
        setName("Lynn");
        setDescription("A mysterious lady that is connect to virtual world to be able to share pictures ... of food.What slim people knows about delicious food?");
    }


    @Override
    public void talk() {
        System.out.println("You see a lady on street.You come to her to ask about direction ,she replied...");
        System.out.println("I upload few pictures of " + getRandomNameOfDish());
        System.out.println("... you tried to understand,but your social media skills wasn't enough good to understand people's passion to share picture of any dish that they eat.");
    }


    private String getRandomNameOfDish() {
        return dishes[new Random().nextInt(dishes.length)];
    }

    @Override
    public void smallTalk() {
        System.out.println("I uploaded picture of " + getRandomNameOfDish());
    }

    @Override
    public String getRandomPreTalk() {
        return "I am hungry";
    }
}
