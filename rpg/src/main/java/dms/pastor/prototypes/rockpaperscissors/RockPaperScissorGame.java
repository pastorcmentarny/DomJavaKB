package dms.pastor.prototypes.rockpaperscissors;


import java.util.Scanner;


public class RockPaperScissorGame {
    private final Scanner scanner = new Scanner(System.in);
    public final RPSPlayer player1;
    public final RPSPlayer player2;
    private final int bestOf;

    public RockPaperScissorGame(int bestOf, RPSPlayer player1, RPSPlayer player2) {
        this.bestOf = bestOf;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void game() {

        for (int round = 1; round <= bestOf; round++) {
            round();
        }

        result();
    }

    private void result() {
        System.out.println(player1.getPoints() + " vs " + player2.getPoints());
        if(player1.getPoints() > player2.getPoints()){
            System.out.println(player1.getName() + " won!");
        } else if(player1.getPoints() < player2.getPoints()){
            System.out.println(player2.getName() + " won!");
        } else {
            System.out.println("Game finished with draw");
        }


    }

    private void round() {
        player1.setShape(getInputFor(player1));
        player2.setShape(getInputFor(player2));

        ResultChecker resultChecker = new ResultChecker(player1, player2);

        resultChecker.checkResult();

    }

    private Shapes getInputFor(RPSPlayer player) {
        if (player.isHuman()) {
            System.out.println(player.getName() + ": (R)ock, (P)aper or (S)cissors ?");
            final Shapes shape = Shapes.getShapeFromCharacter(scanner.next().charAt(0));
            System.out.println(player.getName() + " chose " + shape.name());
            return shape;
        } else {
            final Shapes shape = Shapes.getRandomShape();
            System.out.println(player.getName() + " chose " + shape.name());
            return shape;
        }
    }


    public static void main(String[] args) {
        new RockPaperScissorGame(5, new RPSPlayer("player1", false), new RPSPlayer("player2", false)).game();
    }
}
