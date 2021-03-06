package dms.pastor.rpg.game.events;

import dms.pastor.rpg.game.cfg.Config;
import dms.pastor.rpg.game.commons.Msg;
import dms.pastor.domain.Result;

import java.util.Random;
import java.util.Scanner;


public class GuessNumberEvent implements EventInterface {


    private boolean answeredCorrectly = false;
    private final int answer;
    private final int chances;
    private final int bonus = 100;
    private int reward = 0;
    private final Scanner scanner = new Scanner(System.in);


    public GuessNumberEvent(int min, int max, int chances) {
        this.chances = chances;
        answer = new Random().nextInt(max) + min;


    }

    @Override
    public void doEvent() {
        System.out.println(Config.GUESS_NUMBER_EVENT_LINE);
        for (int i = 1; i <= chances; i++) {
            try {
                System.out.println("Type number  on keyboard..");
                int guess = scanner.nextInt();
                if (guess == answer) {
                    reward = bonus / i;
                    System.out.println("Well done! You guessed number! Your get reward:" + reward);
                    answeredCorrectly = true;
                    return;
                } else if (answer > guess) {
                    System.out.println("WRONG! Number is higher.");
                } else {
                    System.out.println("WRONG! Number is lower.");
                }
            } catch (Exception e) {
                return;
            }

        }
    }

    public Result getReward() {
        return new Result(true, " got reward ", reward);
    }

    public boolean isAnswered() {
        return answeredCorrectly;
    }


    @Override
    public void help() {
        Msg.noHelp();
    }


}
