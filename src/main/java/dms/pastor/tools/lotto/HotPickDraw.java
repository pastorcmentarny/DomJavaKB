package dms.pastor.tools.lotto;

import java.time.LocalDate;

/**
 * Author Dominik Symonowicz
 * Created 18/09/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
class HotPickDraw {
    private final LocalDate drawDate;
    private final int ball1;
    private final int ball2;
    private final int ball3;
    private final int ball4;
    private final int ball5;
    private final int ball6;
    private final int ballSet;
    private final String machine;
    private final int drawNumber;

    public HotPickDraw(LocalDate drawDate, int ball1, int ball2, int ball3, int ball4, int ball5, int ball6, int ballSet, String machine, int drawNumber) {
        this.drawDate = drawDate;
        this.ball1 = ball1;
        this.ball2 = ball2;
        this.ball3 = ball3;
        this.ball4 = ball4;
        this.ball5 = ball5;
        this.ball6 = ball6;
        this.ballSet = ballSet;
        this.machine = machine;
        this.drawNumber = drawNumber;
    }

    public LocalDate getDrawDate() {
        return drawDate;
    }

    int getBall1() {
        return ball1;
    }

     int getBall2() {
        return ball2;
    }

     int getBall3() {
        return ball3;
    }

     int getBall4() {
        return ball4;
    }

     int getBall5() {
        return ball5;
    }

     int getBall6() {
        return ball6;
    }

     int getBallSet() {
        return ballSet;
    }

     String getMachine() {
        return machine;
    }

     int getDrawNumber() {
        return drawNumber;
    }

    @Override
    public String toString() {
        return String.format("HotPickDraw{drawDate=%s, balls: (%d, %d, %d, %d, %d, %d). ballSet:%d machine:'%s' drawNumber:%d}", drawDate, ball1, ball2, ball3, ball4, ball5, ball6, ballSet, machine, drawNumber);
    }

    //TODO improve it
     boolean containsBalls(int... numbers) {
        for (int number : numbers) {
            if (isNotContains(number)) {
                return false;
            }
        }
        return true;
    }

    private boolean isNotContains(int number) {
        return !(ball1 == number || ball2 == number || ball3 == number || ball4 == number || ball5 == number || ball6 == number);
    }

    int[] getAllBalls() {
        return new int[]{ball1, ball2, ball3, ball4, ball5, ball6};
    }
}
