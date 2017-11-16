package dms.pastor.tools.tube;

import dms.pastor.domain.exception.NotFoundException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;

import static dms.pastor.tools.tube.Station.SEPARATOR;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;

public class StationLineValidatorTest {

    private static final String TUBE_LINE_NAME = "Metropolitan line";

    @Rule
    public ExpectedException exception = ExpectedException.none();

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
        StationLineValidator.validate("Acton Town" + SEPARATOR + invalidStatus + SEPARATOR + TUBE_LINE_NAME + SEPARATOR + LocalDate.now() + SEPARATOR + LocalDate.now());


    }

}