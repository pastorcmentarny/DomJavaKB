package dms.pastor.tools.info.aircraft.converters;


import org.junit.jupiter.api.Test;

import static dms.pastor.tools.info.aircraft.converters.ToUnitConverter.toMetersAsString;
import static org.assertj.core.api.Assertions.assertThat;

public class ToUnitConverterTest {

    @Test
    public void shouldReturnValueForHigherThat1meters() {
        // given
        final var expectedResult = "64.75m";
        // when
        final var result = toMetersAsString(6475);
        // then
        assertThat(result).isEqualTo(expectedResult);
    }
}