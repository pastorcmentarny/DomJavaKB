package dms.pastor.tools.info.aircraft;

import dms.pastor.domain.exception.NotFoundException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class RoleTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

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
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        Role.getTypeFromLetter(null);
    }

    @Test
    public void shouldThrowNotFoundExceptionForNotSupportedLetter() {
        // expect
        exception.expect(NotFoundException.class);

        // given
        final String invalidLetter = "X";

        // when
        Role.getTypeFromLetter(invalidLetter);
    }

}