package dms.pastor.tools.trips.train;

import dms.pastor.domain.exception.NotFoundException;
import dms.pastor.tools.trips.common.options.Status;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static dms.pastor.tools.trips.common.options.Status.PASSED;
import static dms.pastor.tools.trips.common.options.Status.VISITED;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static org.assertj.core.api.Assertions.assertThat;

public class StatusTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void fromValueShouldReturnStatusForLowerV() {
        // given
        final String validValueInLowerCase = "v";

        // when
        final dms.pastor.tools.trips.common.options.Status result = dms.pastor.tools.trips.common.options.Status.fromValue(validValueInLowerCase);

        // then
        assertThat(result).isEqualTo(VISITED);
    }

    @Test
    public void fromValueShouldReturnStatusForUpperP() {
        // given
        final String validValueInCapitalCase = "P";

        // when
        final dms.pastor.tools.trips.common.options.Status result = dms.pastor.tools.trips.common.options.Status.fromValue(validValueInCapitalCase);

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
        dms.pastor.tools.trips.common.options.Status.fromValue(invalidValue);
    }

    @Test
    public void fromValueShouldThrowIllegalArgumentExceptionWhenInputIsNull() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        dms.pastor.tools.trips.common.options.Status.fromValue(null);
    }

    @Test
    public void fromValueShouldThrowIllegalArgumentExceptionWhenInputIsEmpty() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        dms.pastor.tools.trips.common.options.Status.fromValue(EMPTY_STRING);
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