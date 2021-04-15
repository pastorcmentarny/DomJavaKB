package dms.pastor.prototypes.aberminegenerator.ui.cli;

import dms.pastor.prototypes.aberminegenerator.Activity;
import dms.pastor.prototypes.aberminegenerator.Wanderer;
import dms.pastor.prototypes.aberminegenerator.model.generators.WorldGenerator;

import java.util.Scanner;


public class CommandLineUI {
    private final Scanner scanner = new Scanner(System.in);

    private final Activity activity;

    public CommandLineUI() {
        activity = new Activity(Wanderer.withRandomNameAtTestStartPoint(), WorldGenerator.generateTestWorld());
    }

    public void game() {

        boolean menu = true;
        System.out.println("Warm welcome citizen!");
        System.out.println(activity.getWholeWorld());
        while (menu) {
            System.out.println("What do you want to do ?");
            System.out.println(activity.getMap());
            switch (scanner.nextLine()) {
                case "a" -> activity.walkWest();
                case "w" -> activity.walkNorth();
                case "d" -> activity.walkEast();
                case "s" -> activity.walkSouth();
                case "q" -> menu = false;
            }
        }
        System.out.println("The universe ceased to exist.");

    }


}
