package dms.pastor.tools.runs;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ToMinutesPerKilometersTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldThrowInvalidExceptionIfKphIsNegative() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        ToMinutesPerKilometers.transform(-1f);
    }

    @Test
    public void shouldReturnZeroIfKphIsZero() {
        // given
        float kph = 0;

        // when
        final var result = ToMinutesPerKilometers.transform(kph);

        // then
        assertThat(result).isZero();

    }

    @Test
    public void shouldReturn400SecondsIf9Kph() {
        // given
        float kph = 9;

        // when
        final var result = ToMinutesPerKilometers.transform(kph);

        // then
        assertThat(result).isEqualTo(400);

    }
}