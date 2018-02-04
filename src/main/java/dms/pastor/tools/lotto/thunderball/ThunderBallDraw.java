package dms.pastor.tools.lotto.thunderball;

import java.time.LocalDate;

/**
 * Author Dominik Symonowicz
 * Created 22/11/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ThunderBallDraw {
    private final LocalDate DrawDate;
    private final int ball1;
    private final int ball2;
    private final int ball3;
    private final int ball4;
    private final int ball5;
    private final int thunderBall;
    private final String ballSet;
    private final String machine;
    private final int drawNumber;

    public ThunderBallDraw(LocalDate drawDate, int ball1, int ball2, int ball3, int ball4, int ball5, int thunderBall, String ballSet, String machine, int drawNumber) {
        DrawDate = drawDate;
        this.ball1 = ball1;
        this.ball2 = ball2;
        this.ball3 = ball3;
        this.ball4 = ball4;
        this.ball5 = ball5;
        this.thunderBall = thunderBall;
        this.ballSet = ballSet;
        this.machine = machine;
        this.drawNumber = drawNumber;
    }

    public LocalDate getDrawDate() {
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

    public int getThunderBall() {
        return thunderBall;
    }

    public String getBallSet() {
        return ballSet;
    }

    public String getMachine() {
        return machine;
    }

    public int getDrawNumber() {
        return drawNumber;
    }
}
