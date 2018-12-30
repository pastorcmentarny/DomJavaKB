package dms.pastor.rpg;

import dms.pastor.rpg.lab.UnitLab;
import dms.pastor.rpg.events.GuessNumberEvent;
import dms.pastor.rpg.utils.BalanceCheckerUtils;

/**
 * @author Pastor Created Jan 4, 2015 at 5:10:59 PM
 */
public class RPGLauncher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Running Aberystwyth RPG emulator..");
        playGame();
        //runOther();
        //runLab();
        //runDiagnostic();
    }

    public static void playGame() {
        //FIXME log.info("Starting new game");
        Game game = Game.getGame();
        game.play();
        System.out.println("Exiting... GoodBye");
    }

    private static void runOther() {
        GuessNumberEvent gne = new GuessNumberEvent(0, 9, 3);
        gne.doEvent();

        System.out.println("You got " + gne.getReward() + "points.");
        /*
        ProgressViewer pv = new ProgressViewer();
        pv.run();
        */
    }

    private static void runLab() {
        UnitLab ul = new UnitLab();
        ul.runAExperiment();
    }

    private static void runDiagnostic() {
        BalanceCheckerUtils bcu = new BalanceCheckerUtils();
        bcu.runBalanceDiagnostic();
    }

}
