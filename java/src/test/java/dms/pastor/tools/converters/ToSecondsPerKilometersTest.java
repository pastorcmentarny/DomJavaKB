package dms.pastor.tools.converters;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;


public class ToSecondsPerKilometersTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldThrowInvalidExceptionIfKphIsNegative() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        ToSecondsPerKilometers.transform(-1f);
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