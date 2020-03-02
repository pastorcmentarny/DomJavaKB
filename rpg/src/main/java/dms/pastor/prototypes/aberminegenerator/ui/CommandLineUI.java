package dms.pastor.prototypes.aberminegenerator.ui;

import dms.pastor.prototypes.aberminegenerator.Activity;
import dms.pastor.prototypes.aberminegenerator.Wanderer;
import dms.pastor.prototypes.aberminegenerator.model.generators.WorldGenerator;

import java.util.Scanner;


public class CommandLineUI {
    private final Scanner scanner = new Scanner(System.in);

    private Activity activity;

    public CommandLineUI() {
        activity = new Activity(Wanderer.withRandomNameAtTestStartPoint(), WorldGenerator.generateTestWorld());
    }

    public void game() {

        boolean menu = true;
        while (menu){
            System.out.println("What do you want to do ?");
            System.out.println(activity.getMap());
            switch (scanner.nextLine()) {
                case "a":
                    activity.walkWest();
                    break;
                case "w":
                    activity.walkNorth();
                    break;
                case "d":
                    activity.walkEast();
                    break;
                case "s":
                    activity.walkSouth();
                    break;
                case "q":
                    menu = false;
                    break;
            }
        }
        System.out.println("The universe ceased to exist.");

    }


}
