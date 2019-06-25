package dms.pastor.rpg.game.places;

import dms.pastor.rpg.game.Element;
import dms.pastor.rpg.game.units.Hero;

import java.util.Random;
import java.util.Scanner;


abstract class Place extends Element {
    final Random random = new Random();
    final Scanner scanner = new Scanner(System.in);
    final Hero hero = Hero.getHero();


    /*
    if player come to place it will see this message 
    */
    public abstract void description();


    public abstract void goToPlace();
}
