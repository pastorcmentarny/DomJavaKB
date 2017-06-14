package dms.pastor.tools.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Collections.singletonList;

/**
 * Author Dominik Symonowicz
 * Created 11/03/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class BallCount {
    private final List<Integer> ballNumbers;
    private int count;

    BallCount(List<Integer> ballNumbers, int count) {
        this.ballNumbers = new ArrayList<>(ballNumbers);
        this.count = count;
    }

    static BallCount createForNumber(int ballNumber) {
        return new BallCount(singletonList(ballNumber), 0);
    }

    static BallCount createForSingleNumberWithCount(int ballNumber, int count) {
        return new BallCount(singletonList(ballNumber), count);
    }

    static BallCount dummyBall() {
        return new BallCount(singletonList(0), Integer.MIN_VALUE + 1);
    }

    public static boolean isDummyBall(BallCount ballCount) {
        return ballCount.getBallNumbers().get(0) == 0 && (ballCount.getCount() == Integer.MAX_VALUE - 1 || ballCount.getCount() == Integer.MIN_VALUE + 1);
    }

    void addCount() {
        count++;
    }

    void setCount(int count) {
        this.count = count;
    }


    List<Integer> getBallNumbers() {
        return ballNumbers;
    }

    int getCount() {
        return count;
    }

    void addBallNumber(Integer newBallNumber) {
        ballNumbers.add(newBallNumber);
    }
    void addBallNumbers(List<Integer> newBallNumbers) {
        ballNumbers.addAll(newBallNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallCount ballCount = (BallCount) o;
        return getCount() == ballCount.getCount() &&
                Objects.equals(getBallNumbers(), ballCount.getBallNumbers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBallNumbers(), getCount());
    }

    @Override
    public String toString() {
        return "BallCount{" +
                "ballNumbers=" + ballNumbers +
                ", count=" + count +
                '}';
    }
}
