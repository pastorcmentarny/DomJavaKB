package dms.pastor.prototypes.rockpaperscissors;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static dms.pastor.prototypes.rockpaperscissors.Shapes.*;

@AllArgsConstructor
@Getter
public class ResultChecker {
    private final RPSPlayer player1;
    private final RPSPlayer player2;

    //scissor bets paper bets rock
    public void checkResult() {
        if (player1.getShape().equals(player2.getShape())) {
            player1.addPoint();
            player2.addPoint();
            System.out.println("DRAW!");
        }

        checkForScissorsVsPaperOrRock(player1, player2);
        checkForScissorsVsPaperOrRock(player2, player1);

        checkPaperVsRock(player1, player2);
        checkPaperVsRock(player2, player1);
    }

    private void checkPaperVsRock(RPSPlayer first, RPSPlayer second) {
        if (first.getShape().equals(PAPER)) {
            if (second.getShape().equals(ROCK)) {
                first.addPoint();
                System.out.println(first.getName() + " won!");
            }
        }
    }

    private void checkForScissorsVsPaperOrRock(RPSPlayer first, RPSPlayer second) {
        if (first.getShape().equals(SCISSORS)) {
            if (second.getShape().equals(PAPER)) {
                first.addPoint();
                System.out.println(first.getName() + " won!");

            }
            if (second.getShape().equals(ROCK)) {
                second.addPoint();
                System.out.println(second.getName() + " won!");
            }
        }
    }

    public int getPlayer1Score() {
        return player1.getPoints();
    }

    public int getPlayer2Score() {
        return player2.getPoints();
    }
}
