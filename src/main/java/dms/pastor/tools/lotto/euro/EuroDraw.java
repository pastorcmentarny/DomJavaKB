package dms.pastor.tools.lotto.euro;

import dms.pastor.tools.lotto.hotpick.Draw;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class EuroDraw implements Draw {
    private final LocalDate drawDate;
    private final int ball1;
    private final int ball2;
    private final int ball3;
    private final int ball4;
    private final int ball5;
    private final int luckyStar1;
    private final int luckyStar2;
    private final String ukMillionaireMaker;
    private final int drawNumber;


    public EuroDraw(LocalDate drawDate, int ball1, int ball2, int ball3, int ball4, int ball5, int luckyStar1, int luckyStar2, String ukMillionaireMaker, int drawNumber) {
        this.drawDate = drawDate;
        this.ball1 = ball1;
        this.ball2 = ball2;
        this.ball3 = ball3;
        this.ball4 = ball4;
        this.ball5 = ball5;
        this.luckyStar1 = luckyStar1;
        this.luckyStar2 = luckyStar2;
        this.ukMillionaireMaker = ukMillionaireMaker;
        this.drawNumber = drawNumber;
    }

    public LocalDate getDrawDate() {
        return drawDate;
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

    public int getLuckyStar1() {
        return luckyStar1;
    }

    public int getLuckyStar2() {
        return luckyStar2;
    }

    public String getUkMillionaireMaker() {
        return ukMillionaireMaker;
    }

    public int getDrawNumber() {
        return drawNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EuroDraw euroDraw = (EuroDraw) o;
        return getBall1() == euroDraw.getBall1() &&
                getBall2() == euroDraw.getBall2() &&
                getBall3() == euroDraw.getBall3() &&
                getBall4() == euroDraw.getBall4() &&
                getBall5() == euroDraw.getBall5() &&
                getLuckyStar1() == euroDraw.getLuckyStar1() &&
                getLuckyStar2() == euroDraw.getLuckyStar2() &&
                getDrawNumber() == euroDraw.getDrawNumber() &&
                Objects.equals(getDrawDate(), euroDraw.getDrawDate()) &&
                Objects.equals(getUkMillionaireMaker(), euroDraw.getUkMillionaireMaker());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDrawDate(), getBall1(), getBall2(), getBall3(), getBall4(), getBall5(), getLuckyStar1(), getLuckyStar2(), getUkMillionaireMaker(), getDrawNumber());
    }

    @Override
    public String toString() {
        return "EuroDraw{" +
                "drawDate=" + drawDate +
                ", ball1=" + ball1 +
                ", ball2=" + ball2 +
                ", ball3=" + ball3 +
                ", ball4=" + ball4 +
                ", ball5=" + ball5 +
                ", luckyStar1=" + luckyStar1 +
                ", luckyStar2=" + luckyStar2 +
                ", ukMillionaireMaker='" + ukMillionaireMaker + '\'' +
                ", drawNumber=" + drawNumber +
                '}';
    }
}
