package dms.pastor.rpg.game.places;

import java.util.Random;


public class TrainStation extends Place {
    private final Random random = new Random();
    private final String question;
    private final String reason;
    private final String[] reasons = {
        "Signal failure",
        "Train is broken down .",
        "Shortage of stuff .",
        "Because. ",
        "Invisible Elvis came from nowhere and kidnap track. ",
        "Because was already delayed by 10 light years due problem with signal failure. ",
        "Train accidentally departs just before you come tro station",
        "Track melt due 2 days of sunny weather and need to be replaced",
        "Train is stuck in the middle of the field ,because drive hit  flock of sheep.",
        "Track is frozen because is -0.005 degrees ,which means winter of the century"};
    private final String[] questionForReason = {"Why", "What happen", "Eee?"};

    public TrainStation() {
        question = (questionForReason[random.nextInt(questionForReason.length)]);
        reason = (reasons[random.nextInt(reasons.length)]);
    }


    //"I arrived late and depart on time. 

    @Override
    public void goToPlace() {
        System.out.println("You came into station and you full platform of unhappy people. There is no staff on the station as they under siege in their office.");
        System.out.println("You came to first person and asked..\n Where is train?\n" + (random.nextBoolean() ? "She" : "He") + " answered : Train is cancelled");
        System.out.println(question + "?");
        System.out.println(reason);
        System.out.println("and then you hear announcement with Train's company famous motto 'We apologize for any inconvenience that may cause to you.\n");
        System.out.println("It seems,you will not go anywhere.\nYou left station");
    }

    @Override
    public void description() {
        System.out.println("You came into train station. A place when you can take train to somewhere.");
    }

}
