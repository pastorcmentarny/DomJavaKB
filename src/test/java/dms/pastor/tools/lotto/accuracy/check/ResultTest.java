package dms.pastor.tools.lotto.accuracy.check;

import org.junit.Test;

import static dms.pastor.utils.randoms.RandomDataGenerator.randomPositiveInteger;
import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    private static final int NOT_USED_ACCURACY = randomPositiveInteger(1, 100);

    @Test
    public void getBalanceInPenniesShouldReturn100ForBalanceEqualsTo100() {
        // given
        final int onePound = 100;
        final Result result = new Result(NOT_USED_ACCURACY, onePound);

        // when
        final int resultInPennies = result.getBalanceInPennies();

        // then
        assertThat(resultInPennies).isEqualTo(100);
    }

    @Test
    public void getBalanceInPenniesShouldReturnNineForBalanceEqualsTo9() {
        // given
        final int ninePennies = 9;
        final Result result = new Result(NOT_USED_ACCURACY, ninePennies);
        final String balance = "£0.09";

        // when
        final String resultInPounds = result.getBalanceInPounds();

        // then
        assertThat(resultInPounds).isEqualTo(balance);
    }

    @Test
    public void getBalanceInPenniesShouldReturnMinusTenThousandAndOnePoundFiftyForBalanceEqualsToMinus10000150() {
        // given
        final int tenThousandAndPoundFifty = -1000150;
        final Result result = new Result(NOT_USED_ACCURACY, tenThousandAndPoundFifty);
        final String balance = "- £10001.50";

        // when
        final String resultInPounds = result.getBalanceInPounds();

        // then
        assertThat(resultInPounds).isEqualTo(balance);
    }
}