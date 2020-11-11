package dms.pastor.tools.trips.tube;

import dms.pastor.domain.exception.NotFoundException;
import dms.pastor.tools.trips.common.options.State;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static dms.pastor.tools.trips.common.options.State.fromValue;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static org.assertj.core.api.Assertions.assertThat;

public class StateTest {


    @Test
    public void fromValueShouldThrowNotFoundExceptionForInvalidCharacter() {
        // given
        final String invalidValue = "Z";
        // when
        Assertions.assertThrows(NotFoundException.class, () -> fromValue(invalidValue));
    }

    @Test
    public void fromValueShouldThrowIllegalArgumentExceptionWhenInputIsNull() {
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> fromValue(null));

    }

    @Test
    public void fromValueShouldThrowIllegalArgumentExceptionWhenInputIsEmpty() {
        // when
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> fromValue(EMPTY_STRING));


    }

    @Test
    public void fromValueShouldReturnStatusForLowerO() {
        // given
        final String validValueInLowerCase = "o";
        // when
        final State result = fromValue(validValueInLowerCase);

        // then
        assertThat(result).isEqualTo(State.OPEN);
    }

    @Test
    public void fromValueShouldReturnStatusForCapitalA() {
        // given
        final String validValueInLowerCase = "A";
        // when
        final State result = fromValue(validValueInLowerCase);

        // then
        assertThat(result).isEqualTo(State.ABANDONED);
    }
}
