package dms.pastor.tools.lotto.accuracy.check;

import org.junit.Test;

import static dms.pastor.utils.randoms.RandomDataGenerator.randomPositiveInteger;
import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    public static final int NOT_USEDACCURACY = randomPositiveInteger(1, 100);

    @Test
    public void getBalanceInPenniesShouldReturn100ForBalanceEqualsTo100() {
        // given
        final int onePound = 100;
        final Result result = new Result(NOT_USEDACCURACY, onePound);

        // when
        final int resultInPennies = result.getBalanceInPennies();

        // then
        assertThat(resultInPennies).isEqualTo(100);
    }

    @Test
    public void getBalanceInPenniesShouldReturnNineForBalanceEqualsTo9() {
        // given
        final int ninePennnies = 9;
        final Result result = new Result(NOT_USEDACCURACY, ninePennnies);
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
        final Result result = new Result(NOT_USEDACCURACY, tenThousandAndPoundFifty);
        final String balance = "- £10001.50";

        // when
        final String resultInPounds = result.getBalanceInPounds();

        // then
        assertThat(resultInPounds).isEqualTo(balance);
    }
}