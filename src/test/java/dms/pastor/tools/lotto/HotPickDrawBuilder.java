package dms.pastor.tools.lotto;

import java.time.LocalDate;
import java.util.Random;

import static dms.pastor.utils.RandomDataGenerator.generateString;

/**
 * Author Dominik Symonowicz
 * Created 18/09/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class HotPickDrawBuilder {
    private final Random random = new Random();
    private LocalDate drawDate = LocalDate.now();
    private int ball1 = randomHotPickNumber();
    private int ball2 = randomHotPickNumber();
    private int ball3 = randomHotPickNumber();
    private int ball4 = randomHotPickNumber();
    private int ball5 = randomHotPickNumber();
    private int ball6 = randomHotPickNumber();
    private int ballSet = random.nextInt(8) + 1;
    private String machine = generateString(9);
    private int drawNumber = random.nextInt(3000);

    private HotPickDrawBuilder() {
    }

    static HotPickDrawBuilder hotPickDrawBuilder() {
        return new HotPickDrawBuilder();
    }

    HotPickDraw build() {
        return new HotPickDraw(drawDate, ball1, ball2, ball3, ball4, ball5, ball6, ballSet, machine, drawNumber);
    }

    private int randomHotPickNumber() {
        return random.nextInt(59) + 1;
    }

    public HotPickDrawBuilder drawDate(LocalDate drawDate) {
        this.drawDate = drawDate;
        return this;
    }

    HotPickDrawBuilder ball1(int ball1) {
        this.ball1 = ball1;
        return this;
    }

    HotPickDrawBuilder ball2(int ball2) {
        this.ball2 = ball2;
        return this;
    }

    HotPickDrawBuilder ball3(int ball3) {
        this.ball3 = ball3;
        return this;
    }

    HotPickDrawBuilder ball4(int ball4) {
        this.ball4 = ball4;
        return this;
    }

    HotPickDrawBuilder ball5(int ball5) {
        this.ball5 = ball5;
        return this;
    }

    HotPickDrawBuilder ball6(int ball6) {
        this.ball6 = ball6;
        return this;
    }

    HotPickDrawBuilder ballSet(int ballSet) {
        this.ballSet = ballSet;
        return this;
    }

    HotPickDrawBuilder machine(String machine) {
        this.machine = machine;
        return this;
    }

    HotPickDrawBuilder drawNumber(int drawNumber) {
        this.drawNumber = drawNumber;
        return this;
    }

    HotPickDrawBuilder allBalls(int ball1,int ball2,int ball3, int ball4, int ball5, int ball6){
        this.ball1 = ball1;
        this.ball2 = ball2;
        this.ball3 = ball3;
        this.ball4 = ball4;
        this.ball5 = ball5;
        this.ball6 = ball6;
        return this;
    }
}