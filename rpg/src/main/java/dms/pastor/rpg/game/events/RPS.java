package dms.pastor.rpg.game.events;

import dms.pastor.domain.Result;

/**
 * @author Pastor
 * Created Feb 17, 2015 at 7:39:48 PM
 */
public enum RPS {
    ROCK(1), PAPER(2), SCISSORS(3);
    String rockWin = "Rock crushes scissors.";
    String paperWin = "paper covers rock.";
    String scissorWin = "Scissors cuts papers.";
    String win = "You won!";
    String lose = "You lost!";
    String draw = "DRAW!";
    private final int number;

    RPS(int number) {
        this.number = number;
    }

    public int number() {
        return number;
    }

    public Result getResultFor() {
        return new Result(false);
    }
}
