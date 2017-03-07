package dms.pastor.tools.lotto;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static dms.pastor.tools.lotto.HotPickDrawBuilder.hotPickDrawBuilder;
import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 20/09/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class HotPickDrawTest {

    private static final int BALL_1 = 1;
    private static final int BALL_2 = 2;
    private static final int BALL_3 = 3;
    private static final int BALL_4 = 4;
    private static final int BALL_5 = 5;
    private static final int BALL_6 = 6;
    private static final int BALL_SET = 7;
    private static final String MACHINE_NAME = "testMachine";
    private static final int DRAW_NUMBER = 8;
    private static final LocalDate DATE = LocalDate.now();
    private HotPickDraw hotPickDraw;

    @Before
    public void setUp() throws Exception {
        hotPickDraw = hotPickDrawBuilder()
                .ball1(BALL_1)
                .ball2(BALL_2)
                .ball3(BALL_3)
                .ball4(BALL_4)
                .ball5(BALL_5)
                .ball6(BALL_6)
                .ballSet(BALL_SET)
                .machine(MACHINE_NAME)
                .drawNumber(DRAW_NUMBER)
                .drawDate(DATE)
                .build();
    }

    @Test
    public void shouldReturnFalseIfBallIsNotInBallDrawTest() throws Exception {
        // when
        final boolean result = hotPickDraw.containsBalls(9, 10);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void shouldReturnFalseIfSomeBallAreNotInBallDrawTest() throws Exception {
        // when
        final boolean result = hotPickDraw.containsBalls(6, 7);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void shouldReturnTrueIfBallIsInBallDrawNotTest() throws Exception {
        // when
        final boolean result = hotPickDraw.containsBalls(1, 2);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void shouldReturnHotPickDrawDescription() {
        // given
        String expectedResult = "HotPickDraw{" +
                "drawDate=" + DATE +
                ", balls: (" + BALL_1 +
                ", " + BALL_2 +
                ", " + BALL_3 +
                ", " + BALL_4 +
                ", " + BALL_5 +
                ", " + BALL_6 +
                "). ballSet:" + BALL_SET +
                " machine:'" + MACHINE_NAME + '\'' +
                " drawNumber:" + DRAW_NUMBER +
                '}';

        // when
        final String result = hotPickDraw.toString();

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

}