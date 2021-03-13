package dms.pastor.tools.trips.tube;

import dms.pastor.domain.exception.NotFoundException;
import dms.pastor.tools.trips.common.options.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static dms.pastor.tools.trips.common.options.Status.PASSED;
import static dms.pastor.tools.trips.common.options.Status.VISITED;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class StatusTest {


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
        // when
        Assertions.assertThrows(NotFoundException.class, () -> Status.fromValue(invalidValue));

    }

    @Test
    public void fromValueShouldThrowIllegalArgumentExceptionWhenInputIsNull() {
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> Status.fromValue(null));
    }

    @Test
    public void fromValueShouldThrowIllegalArgumentExceptionWhenInputIsEmpty() {
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> Status.fromValue(EMPTY_STRING));
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
