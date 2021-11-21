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
}