package dms.pastor.prototypes.rockpaperscissors;


import org.junit.jupiter.api.Test;

import static dms.pastor.prototypes.rockpaperscissors.Shapes.*;
import static org.assertj.core.api.Assertions.assertThat;

class ResultCheckerTest {

    @Test
    public void drawGivesPointsForBothPlayers() {
        // given
        final Shapes randomShape = getRandomShape();
        RPSPlayer player1 = new RPSPlayer("player1", false, 0, randomShape);
        RPSPlayer player2 = new RPSPlayer("player2", false, 0, randomShape);
        final ResultChecker resultChecker = new ResultChecker(player1, player2);

        // when
        resultChecker.checkResult();

        // then
        assertThat(resultChecker.getPlayer1Score()).isOne();
        assertThat(resultChecker.getPlayer2Score()).isOne();
    }


    @Test
    public void scissorBeatsPaperTestForPlayer1() {
        // given
        RPSPlayer player1 = new RPSPlayer("player1", false, 0, SCISSORS);
        RPSPlayer player2 = new RPSPlayer("player2", false, 0, PAPER);
        final ResultChecker resultChecker = new ResultChecker(player1, player2);

        // when
        resultChecker.checkResult();

        // then
        assertThat(resultChecker.getPlayer1Score()).isOne();
        assertThat(resultChecker.getPlayer2Score()).isZero();
    }

    @Test
    public void scissorBeatsPaperTestForPlayer2() {
        // given
        RPSPlayer player1 = new RPSPlayer("player1", false, 0, PAPER);
        RPSPlayer player2 = new RPSPlayer("player2", false, 0, SCISSORS);
        final ResultChecker resultChecker = new ResultChecker(player1, player2);

        // when
        resultChecker.checkResult();

        // then
        assertThat(resultChecker.getPlayer1Score()).isZero();
        assertThat(resultChecker.getPlayer2Score()).isOne();
    }

    @Test
    public void paperBeatsRockTestForPlayer1() {
        // given
        RPSPlayer player1 = new RPSPlayer("player1", false, 0, PAPER);
        RPSPlayer player2 = new RPSPlayer("player2", false, 0, ROCK);
        final ResultChecker resultChecker = new ResultChecker(player1, player2);

        // when
        resultChecker.checkResult();

        // then
        assertThat(resultChecker.getPlayer1Score()).isOne();
        assertThat(resultChecker.getPlayer2Score()).isZero();
    }

    @Test
    public void paperBeatsRockTestForPlayer2() {
        // given
        RPSPlayer player1 = new RPSPlayer("player1", false, 0, ROCK);
        RPSPlayer player2 = new RPSPlayer("player2", false, 0, PAPER);
        final ResultChecker resultChecker = new ResultChecker(player1, player2);

        // when
        resultChecker.checkResult();

        // then
        assertThat(resultChecker.getPlayer1Score()).isZero();
        assertThat(resultChecker.getPlayer2Score()).isOne();
    }

    @Test
    public void rockBeatsScissorTestForPlayer1() {
        // given
        RPSPlayer player1 = new RPSPlayer("player1", false, 0, ROCK);
        RPSPlayer player2 = new RPSPlayer("player2", false, 0, SCISSORS);
        final ResultChecker resultChecker = new ResultChecker(player1, player2);

        // when
        resultChecker.checkResult();

        // then
        assertThat(resultChecker.getPlayer1Score()).isOne();
        assertThat(resultChecker.getPlayer2Score()).isZero();
    }

    @Test
    public void rockBeatsScissorTestForPlayer2() {
        // given
        RPSPlayer player1 = new RPSPlayer("player1", false, 0, SCISSORS);
        RPSPlayer player2 = new RPSPlayer("player2", false, 0, ROCK);
        final ResultChecker resultChecker = new ResultChecker(player1, player2);

        // when
        resultChecker.checkResult();

        // then
        assertThat(resultChecker.getPlayer1Score()).isZero();
        assertThat(resultChecker.getPlayer2Score()).isOne();
    }
}