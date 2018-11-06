package dms.pastor.game.rpg.events;

import dms.pastor.game.rpg.commons.Result;

/**
 * @author Pastor
 * Created Feb 17, 2015 at 7:39:48 PM
 */
public enum RPS {
    ROCK(1), PAPPER(2), SCISSORS(3);
    String rockWin = "Rock crushes scissors.";
    String paperWin = "paper covers rock.";
    String scissorWin = "Scissors cuts papers.";
    String win = "You won!";
    String lose = "You lost!";
    String draw = "DRAW!";
    private int number;

    RPS(int number) {
        this.number = number;
    }

    public int number() {
        return number;
    }

    public Result getResultFor(int player, int enemy) {
        return new Result(false);
    }
}
