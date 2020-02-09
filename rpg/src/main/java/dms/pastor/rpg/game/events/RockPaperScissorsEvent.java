package dms.pastor.rpg.game.events;

import dms.pastor.domain.Result;

import java.util.Random;
import java.util.Scanner;


public class RockPaperScissorsEvent implements EventInterface {

    //1 Rock , 2 Paper , 3 Scissor
    private final String rockWin = "Rock crushes scissors.";
    private final String paperWin = "paper covers rock.";
    private final String scissorWin = "Scissors cuts papers.";
    private final String win = "You won!";
    private final String lose = "You lost!";
    private final String draw = "DRAW!";
    private Result result;

    @Override
    public void doEvent() {

    }


    //int[] levels =[2,3,5,8,13,16,21,28,34,55,64,89];

    private boolean game() {
        System.out.println("1. Rock\n2.Paper\n3.Scissors.");
        Scanner scanner = new Scanner(System.in);
        try {
            int i = scanner.nextInt();
            if (i > 3 || i < 1) {
                result = new Result(false, "You CHEAT");
            } else {
                Random random = new Random();
                int enemy = random.nextInt(3) + 1;
                if (i == enemy) {
                    System.out.println(draw);
                    return game(); // can cause infinitive loop ?
                } else {
                    switch (i) {
                        case 1:
                            if (enemy == 2) {
                                System.out.println(lose + paperWin);
                                return false;
                            } else {
                                System.out.println(win + rockWin);
                                return true;
                            }

                        case 2:
                            if (enemy == 1) {
                                System.out.println(win + paperWin);
                                return true;
                            } else {
                                System.out.println(lose + scissorWin);
                                return false;
                            }

                        case 3:
                            if (enemy == 1) {
                                System.out.println(lose + rockWin);
                                return false;
                            } else {
                                System.out.println(win + scissorWin);
                                return true;
                            }
                        default:
                            return false;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("You lost,because you cheat");
            return false;
        }
        return false;
    }

    @Override
    public Result getReward() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void help() {
        System.out.println("If you don;t know how to play Rock Paper Scissor, check great article on Wikipedia http://en.wikipedia.org/wiki/Rock-paper-scissors");
    }

}
