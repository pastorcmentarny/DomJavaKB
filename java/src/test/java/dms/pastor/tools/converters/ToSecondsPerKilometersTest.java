package dms.pastor.tools.converters;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ToSecondsPerKilometersTest {


    @Test
    public void shouldThrowInvalidExceptionIfKphIsNegative() {
        // when
        assertThrows(IllegalArgumentException.class, () -> ToSecondsPerKilometers.transform(-1f));
    }

    @Test
    public void shouldReturnZeroIfKphIsZero() {
        // given
        float kph = 0;

        // when
        final var result = ToSecondsPerKilometers.transform(kph);

        // then
        assertThat(result).isZero();

    }

    @Test
    public void shouldReturn400SecondsIf9Kph() {
        // given
        float kph = 9;

        // when
        final var result = ToSecondsPerKilometers.transform(kph);

        // then
        assertThat(result).isEqualTo(400);

    }
}