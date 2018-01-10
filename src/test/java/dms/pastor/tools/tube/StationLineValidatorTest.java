package dms.pastor.tools.tube;

import dms.pastor.domain.exception.NotFoundException;
import dms.pastor.tools.tube.station.StationLineValidator;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;

import static dms.pastor.tools.tube.station.Station.SEPARATOR;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class StationLineValidatorTest {

    private static final String TUBE_LINE_NAME = "Metropolitan line";

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldThrowIllegalArgumentExceptionIfStringIsNull() {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Station as string cannot be null or empty.");

        // when
        StationLineValidator.validate(null);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionIfStringIsEmpty() {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Station as string cannot be null or empty.");

        // when
        StationLineValidator.validate(EMPTY_STRING);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionIfStringCannotBeSpittedIntoCorrectNumberOfColumns() {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Invalid number of columns.");

        // when
        StationLineValidator.validate(generateString(5));
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionIfStatusDoNotExists() {
        // expect
        exception.expect(NotFoundException.class);
        exception.expectMessage("Status was not found.");

        // given
        final String invalidStatus = "D";

        // when
        StationLineValidator.validate("Acton Town" + SEPARATOR + invalidStatus + SEPARATOR + TUBE_LINE_NAME + SEPARATOR + LocalDate.now() + SEPARATOR + LocalDate.now() + SEPARATOR + LocalDate.now());


    }

}