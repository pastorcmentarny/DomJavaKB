package dms.pastor.prototypes.dcs.utils.random;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dms.pastor.prototypes.dcs.utils.random.InGameRandomUtils.HALF;
import static dms.pastor.utils.randoms.RandomDataGenerator.randomNegativeInteger;
import static dms.pastor.utils.randoms.RandomDataGenerator.randomPositiveInteger;
import static org.assertj.core.api.Assertions.assertThat;

public final class InGameRandomUtilsTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(InGameRandomUtilsTest.class);
    private final RandomUtils randomUtils = new InGameRandomUtils();

    @Test // test failed once
    public void isWillHappenWithProbabilityOfShouldReturnTrueIfPercentageIsAbove100() {
        // given
        final int percentage = 100 + randomPositiveInteger(256);

        // debug info
        LOGGER.debug("Percentage: " + percentage);

        // when
        final boolean willHappenWithProbabilityOf = randomUtils.isWillHappenWithProbabilityOf(percentage);

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
        for (int i = 0; i < 20; i++) {
            boolean result = randomUtils.isWillHappenWithProbabilityOf(HALF);
            if (result) {
                trueResult = true;
            } else {
                falseResult = true;
            }

            if (trueResult && falseResult) {
                LOGGER.debug("It took " + (i + 1) + " attempts to pass test.");
                break;
            }
        }

        // then
        assertThat(trueResult).isTrue();
        assertThat(falseResult).isTrue();
    }
}