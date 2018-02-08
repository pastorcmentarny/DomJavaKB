package dms.pastor.tools.lotto.lotto;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;

/**
 * Author Dominik Symonowicz
 * Created 14/01/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class LottoDraw {
    private final String DrawDate;
    private final int ball1;
    private final int ball2;
    private final int ball3;
    private final int ball4;
    private final int ball5;
    private final int ball6;
    private final int bonusBall;
    private final int ballSet;
    private final String machine;
    private final String raffle;
    private final int drawNumber;

    private LottoDraw(String drawDate, int ball1, int ball2, int ball3, int ball4, int ball5, int ball6, int bonusBall, int ballSet, String machine, String raffle, int drawNumber) {
        DrawDate = drawDate;
        this.ball1 = ball1;
        this.ball2 = ball2;
        this.ball3 = ball3;
        this.ball4 = ball4;
        this.ball5 = ball5;
        this.ball6 = ball6;
        this.bonusBall = bonusBall;
        this.ballSet = ballSet;
        this.machine = machine;
        this.raffle = raffle;
        this.drawNumber = drawNumber;
    }

    public String getDrawDate() {
        return DrawDate;
    }

    public int getBall1() {
        return ball1;
    }

    public int getBall2() {
        return ball2;
    }

    public int getBall3() {
        return ball3;
    }

    public int getBall4() {
        return ball4;
    }

    public int getBall5() {
        return ball5;
    }

    public int getBall6() {
        return ball6;
    }

    public int getBonusBall() {
        return bonusBall;
    }

    public int getBallSet() {
        return ballSet;
    }

    public String getMachine() {
        return machine;
    }

    public String getRaffle() {
        return raffle;
    }

    public int getDrawNumber() {
        return drawNumber;
    }

    public static LottoDraw getDrawWithNumbersOnly(int ball1, int ball2, int ball3, int ball4, int ball5, int ball6) {
        return new LottoDraw(null, ball1, ball2, ball3, ball4, ball5, ball6, 0, 0, EMPTY_STRING, EMPTY_STRING, 0);
    }

}
