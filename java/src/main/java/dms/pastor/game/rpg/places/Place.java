package dms.pastor.game.rpg.places;

import dms.pastor.game.rpg.units.Hero;
import dms.pastor.game.rpg.Element;

import java.util.Random;
import java.util.Scanner;


public abstract class Place extends Element {
    protected Random random = new Random();
    protected Scanner scanner = new Scanner(System.in);
    Hero hero = Hero.getHero();


    /*
    if player come to place it will see this message 
    */
    public abstract void description();


    public abstract void goToPlace();
}
