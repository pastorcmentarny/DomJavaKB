package dms.pastor.rpg.game;

import dms.pastor.rpg.game.events.GuessNumberEvent;
import dms.pastor.rpg.game.lab.UnitLab;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
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
        Game game = Game.getGame();
        game.play();
        System.out.println("Exiting... GoodBye");
    }

    private static void runOther() {
        GuessNumberEvent gne = new GuessNumberEvent(0, 9, 3);
        gne.doEvent();

        System.out.println("You got " + gne.getReward() + "points.");
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
