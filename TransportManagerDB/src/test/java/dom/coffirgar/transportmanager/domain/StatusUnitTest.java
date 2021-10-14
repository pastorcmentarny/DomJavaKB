package dom.coffirgar.transportmanager.domain;

import dom.coffirgar.transportmanager.exceptions.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static dom.coffirgar.transportmanager.common.Utils.EMPTY_STRING;
import static dom.coffirgar.transportmanager.domain.Status.*;
import static org.assertj.core.api.Assertions.assertThat;

class StatusUnitTest {

    @Test
    public void fromValueShouldReturnStatusForLowerV() {
        // given
        final String validValueInLowerCase = "v";
        // when
        final Status result = fromValue(validValueInLowerCase);

        // then
        assertThat(result).isEqualTo(VISITED);
    }

    @Test
    public void fromValueShouldReturnStatusForUpperP() {
        // given
        final String validValueInCapitalCase = "P";
        // when
        final Status result = fromValue(validValueInCapitalCase);

        // then
        assertThat(result).isEqualTo(PASSED);
    }

    @Test
    public void fromValueShouldThrowNotFoundExceptionForInvalidCharacter() {
        // given
        final String invalidValue = "A";
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
        Assertions.assertThrows(IllegalArgumentException.class, () -> fromValue(EMPTY_STRING));

    }


    @Test
    public void asNameShouldReturnNameWithCapitalizedFirstCharacterAndNoUnderscoreForNotVisited() {
        // given
        final String expectedResult = "not visited";
        // when
        final String result = Status.NOT_VISITED.asName();

        // then
        assertThat(result).isEqualTo(expectedResult);
    }
}