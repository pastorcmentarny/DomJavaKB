package dms.pastor.tools.tube;

import dms.pastor.domain.exception.NotFoundException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static dms.pastor.tools.tube.Status.PASSED;
import static dms.pastor.tools.tube.Status.VISITED;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static org.assertj.core.api.Assertions.assertThat;

public class StatusTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void fromValueShouldReturnStatusForLowerV() {
        // given
        final String validValueInLowerCase = "v";

        // when
        final Status result = Status.fromValue(validValueInLowerCase);

        // then
        assertThat(result).isEqualTo(VISITED);
    }

    @Test
    public void fromValueShouldReturnStatusForUpperP() {
        // given
        final String validValueInCapitalCase = "P";

        // when
        final Status result = Status.fromValue(validValueInCapitalCase);

        // then
        assertThat(result).isEqualTo(PASSED);
    }

    @Test
    public void fromValueShouldThrowNotFoundExceptionForInvalidCharacter() {
        // given
        final String invalidValue = "A";

        // expect
        exception.expect(NotFoundException.class);

        // when
        Status.fromValue(invalidValue);
    }

    @Test
    public void fromValueShouldThrowIllegalArgumentExceptionWhenInputIsNull() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        Status.fromValue(null);
    }

    @Test
    public void fromValueShouldThrowIllegalArgumentExceptionWhenInputIsEmpty() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        Status.fromValue(EMPTY_STRING);
    }

}
