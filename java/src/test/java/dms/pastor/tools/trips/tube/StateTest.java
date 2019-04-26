package dms.pastor.tools.trips.tube;

import dms.pastor.domain.exception.NotFoundException;
import dms.pastor.tools.trips.common.options.State;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static org.assertj.core.api.Assertions.assertThat;

public class StateTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void fromValueShouldThrowNotFoundExceptionForInvalidCharacter() {
        // given
        final String invalidValue = "Z";

        // expect
        exception.expect(NotFoundException.class);

        // when
        State.fromValue(invalidValue);
    }

    @Test
    public void fromValueShouldThrowIllegalArgumentExceptionWhenInputIsNull() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        State.fromValue(null);
    }

    @Test
    public void fromValueShouldThrowIllegalArgumentExceptionWhenInputIsEmpty() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        State.fromValue(EMPTY_STRING);
    }

    @Test
    public void fromValueShouldReturnStatusForLowerO() {
        // given
        final String validValueInLowerCase = "o";

        // when
        final State result = State.fromValue(validValueInLowerCase);

        // then
        assertThat(result).isEqualTo(State.OPEN);
    }

    @Test
    public void fromValueShouldReturnStatusForCapitalA() {
        // given
        final String validValueInLowerCase = "A";

        // when
        final State result = State.fromValue(validValueInLowerCase);

        // then
        assertThat(result).isEqualTo(State.ABANDONED);
    }
}
