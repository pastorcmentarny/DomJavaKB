package dms.pastor.tools.info.aircraft;

import dms.pastor.domain.exception.NotFoundException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoleTest {

    @Test
    public void shouldReturnNarrowBodyTypeFromLetterN() {
        // given
        final var longHaulRoleLetter = "L";

        // when
        final var role = Role.getTypeFromLetter(longHaulRoleLetter);

        // then
        assertThat(role).isEqualTo(Role.LONG_HAUL);
    }

    @Test
    public void shouldThrowInvalidArgumentExceptionIfLetterIsNull() {
        // when
        assertThrows(IllegalArgumentException.class, () -> Role.getTypeFromLetter(null));
    }

    @Test
    public void shouldThrowNotFoundExceptionForNotSupportedLetter() {
        // given
        final String invalidLetter = "X";
        // when
        assertThrows(NotFoundException.class, () -> Role.getTypeFromLetter(invalidLetter));

    }

}