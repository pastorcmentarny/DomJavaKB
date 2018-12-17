package dms.pastor.game.rpg.places;

import dms.pastor.game.rpg.Game;
import dms.pastor.game.rpg.quests.PenDinasQuest;
import dms.pastor.game.rpg.quests.QuestMonitor;

import java.util.Scanner;


public class World {

    private final Game game;
    private final Scanner scanner = new Scanner(System.in);
    private final QuestMonitor quests = QuestMonitor.getQuestMonitor();

    public World(Game game) {
        this.game = game;
    }

    //TODO Generate names from class name
    public void map() {

        boolean stay = true;
        while (stay) {
            System.out.println("Where do you want go ?");
            System.out.println(" 1. Go to Castle");
            System.out.println(" 2. Go to Aberystwyth");
            System.out.println(" 3. Go to University");
            System.out.println(" 4. Go to Pen Dinas");
            System.out.println(" 5. Go to Penparcau");
            System.out.println(" 6. Go to Constitution Hill");
            System.out.println(" 7. Go to Graveyard");
            System.out.println(" 8. Go to Library");
            System.out.println(" 9. Go to Roland's Tavern");
            System.out.println("10. Go to Monastery");
            System.out.println("0.Walk around");
            if (isLlanbadarnVisible()) {
                System.out.println("11. Go to Llanbadarn");
            }
            stay = false;
            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        Castle castle = new Castle();
                        castle.goToPlace();
                        break;
                    case 2:
                        Aberystwyth aber = new Aberystwyth();
                        aber.goToPlace(game.getSteps());
                        break;
                    case 3:
                        University uni = new University();
                        uni.goToPlace();
                        break;
                    case 4:
                        if (quests.isPenDinasQuestCompleted()) {
                            if (quests.isNicolasInTower()) {
                                System.out.println("You came to Tower again,but apart of drunk nicolas,there is nothing there.");
                            } else {
                                System.out.println("You arrived to empty tower.You ask yourself.. Why I am here?Why I came to place?What's wrong with me?");
                            }
                        } else {
                            PenDinasQuest pdq = new PenDinasQuest(game);
                            pdq.startAQuest();
                        }
                        break;
                    case 5:
                        CompSciCamp cs = new CompSciCamp();
                        cs.goToPlace();
                        break;
                    case 6:
                        ConstitutionHill hill = new ConstitutionHill(game);
                        hill.goToPlace();
                        break;
                    case 7:
                        Graveyard mcd = new Graveyard();
                        mcd.goToPlace();
                        break;
                    case 8:
                        Library lib = new Library();
                        lib.goToPlace();
                        break;
                    case 9:
                        Tavern tavern = new Tavern();
                        tavern.goToPlace();
                        break;
                    case 10:
                        Monastery hospital = new Monastery();
                        hospital.goToPlace();
                        break;
                    case 11:
                        if (isLlanbadarnVisible()) {
                            LlanbadarnLab ll = new LlanbadarnLab();
                            ll.goToPlace();
                        }
                        break;
                    case 0:
                        System.out.println(CommonPlaces.getCommentAboutWeather());
                        break;
                    default:
                        stay = true;
                }
            } catch (Exception e) {
                System.out.println("Something went wrong: " + e.getMessage());
            }
        }
    }

    private boolean isLlanbadarnVisible() {
        return false; //implement secret location
    }
}
