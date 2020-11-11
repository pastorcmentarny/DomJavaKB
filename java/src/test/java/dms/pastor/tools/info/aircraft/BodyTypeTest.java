package dms.pastor.tools.info.aircraft;


import dms.pastor.domain.exception.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BodyTypeTest {



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
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> BodyType.getTypeFromLetter(null));

    }

    @Test
    public void shouldThrowNotFoundExceptionForNotSupportedLetter() {

        // given
        final String invalidLetter = "X";
        // when
        final var exception = Assertions.assertThrows(NotFoundException.class, () -> BodyType.getTypeFromLetter(invalidLetter));

    }
}