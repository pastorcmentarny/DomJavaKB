package dms.pastor.tools.trips.tube;

import dms.pastor.domain.exception.NotFoundException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static dms.pastor.tools.trips.common.station.StationLineValidator.validate;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.file.TextFileUtils.FIELD_SEPARATOR;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class OvergroundStationNameOvergroundLineValidatorTest {

    @Test
    public void shouldThrowIllegalArgumentExceptionIfStringIsNull() {
        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> validate(null));

        // then
        assertThat(exception.getMessage()).isEqualTo("TubeStation as string cannot be null or empty.");
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionIfStringIsEmpty() {
        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> validate(EMPTY_STRING));

        // then
        assertThat(exception.getMessage()).isEqualTo("TubeStation as string cannot be null or empty.");

    }

    @Test
    public void shouldThrowIllegalArgumentExceptionIfStringCannotBeSpittedIntoCorrectNumberOfColumns() {
        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> validate(generateString(5)));

        // then
        assertThat(exception.getMessage()).startsWith("Invalid number of columns. Expect 6 but was 1Line:");
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionIfStatusDoNotExists() {
        // given
        final String invalidStatus = "D";

        // when
        assertThrows(NotFoundException.class, () -> validate("Acton Town" + FIELD_SEPARATOR + invalidStatus + FIELD_SEPARATOR + LocalDate.now() + FIELD_SEPARATOR + LocalDate.now() + FIELD_SEPARATOR + LocalDate.now() + FIELD_SEPARATOR + "Y"));
    }

}