package dms.pastor.game.dcs.utils.random;

import org.junit.Test;

import static dms.pastor.game.dcs.utils.random.InGameRandomUtils.HALF;
import static dms.pastor.utils.randoms.RandomDataGenerator.randomNegativeInteger;
import static dms.pastor.utils.randoms.RandomDataGenerator.randomPositiveInteger;
import static org.assertj.core.api.Assertions.assertThat;

public final class InGameRandomUtilsTest {

    private final RandomUtils randomUtils = new InGameRandomUtils();

    @Test
    public void isWillHappenWithProbabilityOfShouldReturnTrueIfPercentageIsAbove100() {
        // when
        final boolean willHappenWithProbabilityOf = randomUtils.isWillHappenWithProbabilityOf(100 + randomPositiveInteger(256));

        // then
        assertThat(willHappenWithProbabilityOf).isTrue();
    }

    @Test
    public void isWillHappenWithProbabilityOfShouldReturnFalseIfPercentageIsNegative() {
        // when
        final boolean willHappenWithProbabilityOf = randomUtils.isWillHappenWithProbabilityOf(randomNegativeInteger());

        // then
        assertThat(willHappenWithProbabilityOf).isFalse();
    }

    @Test //TODO find better way to test random
    public void isWillHappenWithProbabilityOfShouldReturnTrueAndFalseForMany() {
        // given

        boolean trueResult = false;
        boolean falseResult = false;

        // when
        for (int i = 0; i < 1000; i++) {
            boolean result = randomUtils.isWillHappenWithProbabilityOf(HALF);
            if (result) {
                trueResult = true;
            } else {
                falseResult = true;
            }

            if (trueResult && falseResult) {
                break;
            }
        }

        // then
        assertThat(trueResult).isTrue();
        assertThat(falseResult).isTrue();
    }
}