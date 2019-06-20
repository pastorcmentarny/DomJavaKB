package dms.pastor.tools.info.aircraft;


import dms.pastor.domain.exception.NotFoundException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class BodyTypeTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldReturnNarrowBodyTypeFromLetterN() {
        // given
        final var narrowBodyLetter = "N";

        // when
        final var bodyType = BodyType.getTypeFromLetter(narrowBodyLetter);

        // then
        assertThat(bodyType).isEqualTo(BodyType.N);
    }

    @Test
    public void shouldThrowInvalidArgumentExceptionIfLetterIsNull() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        BodyType.getTypeFromLetter(null);
    }

    @Test
    public void shouldThrowNotFoundExceptionForNotSupportedLetter() {
        // expect
        exception.expect(NotFoundException.class);

        // given
        final String invalidLetter = "X";

        // when
        BodyType.getTypeFromLetter(invalidLetter);
    }
}