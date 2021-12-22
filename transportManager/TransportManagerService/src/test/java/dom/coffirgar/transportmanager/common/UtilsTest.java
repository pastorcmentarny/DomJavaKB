package dom.coffirgar.transportmanager.common;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UtilsTest {

    @Test
    void notEqualsReturnFalseIfBothAreNull() {
        // when
        final boolean result = Utils.notEquals(null, null);

        // then
        assertThat(result).isFalse();
    }

    @Test
    void notEqualsReturnFalseIfCurrentValueIsNull() {
        // when
        final boolean result = Utils.notEquals(null, Utils.generateString());

        // then
        assertThat(result).isFalse();
    }

    @Test
    void notEqualsReturnFalseIfNewValueIsNull() {
        // when
        final boolean result = Utils.notEquals(Utils.generateString(), null);

        // then
        assertThat(result).isFalse();
    }

    @Test
    void notEqualsReturnTrueIfNewAndCurrentValueAreDifferent() {

        // when
        final boolean result = Utils.notEquals(Utils.generateString(), Utils.generateString());

        // then
        assertThat(result).isTrue();
    }

    @Test
    void notEqualsReturnTrueIfNewAndCurrentValueAreDifferent2() {
        // when
        final boolean result = Utils.notEquals("S", "s");

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void countPercentageShouldReturn0Test() {

        // when
        int result = Utils.countPercentage(0, 100);

        // then
        assertThat(result).isZero();
    }

    @Test
    public void countPercentageShouldReturn1Test() {
        // given
        int expectedResult = 1;

        // when
        int result = Utils.countPercentage(1, 100);

        // then
        assertThat(result).isOne();
    }

    @Test
    public void countPercentageShouldReturn2Test() {
        // given
        int expectedResult = 2;

        // when
        int result = Utils.countPercentage(1, 50);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void countPercentageShouldReturn3Test() {
        // given
        int expectedResult = 3;

        // when
        int result = Utils.countPercentage(1, 29);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void countPercentageShouldReturn5Test() {
        // given
        int expectedResult = 5;

        // when
        int result = Utils.countPercentage(1, 20);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void countPercentageShouldReturn6Test() {
        // given
        int expectedResult = 6;

        // when
        int result = Utils.countPercentage(2, 29);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void countPercentageShouldReturn10Test() {
        // given
        int expectedResult = 10;

        // when
        int result = Utils.countPercentage(3, 29);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void countPercentageShouldReturn33Test() {
        // given
        int expectedResult = 33;

        // when
        int result = Utils.countPercentage(33, 100);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void countPercentageShouldReturn44Test() {
        // given
        int expectedResult = 44;

        // when
        int result = Utils.countPercentage(13, 29);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void countPercentageShouldReturn66Test() {
        // given
        int expectedResult = 66;

        // when
        int result = Utils.countPercentage(67, 101);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void countPercentageShouldReturn79Test() {
        // given
        int expectedResult = 79;

        // when
        int result = Utils.countPercentage(23, 29);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }


    @Test
    public void countPercentageShouldReturn93Test() {
        // given
        int expectedResult = 93;

        // when
        int result = Utils.countPercentage(27, 29);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }


    @Test
    public void countPercentageShouldReturn100Test() {
        // given
        int expectedResult = 100;

        // when
        int result = Utils.countPercentage(100, 100);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }
}