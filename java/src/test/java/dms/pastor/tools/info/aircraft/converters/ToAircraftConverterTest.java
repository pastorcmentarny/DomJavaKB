package dms.pastor.tools.info.aircraft.converters;


import dms.pastor.tools.info.aircraft.Aircraft;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static dms.pastor.tools.info.aircraft.AircraftTestConfig.AIRCRAFT;
import static dms.pastor.tools.info.aircraft.AircraftTestConfig.VALID_AIRCRAFT_AS_STRING;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static org.assertj.core.api.Assertions.assertThat;

public class ToAircraftConverterTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldThrowExceptionIfStringIsNull() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        ToAircraftConverter.convert((String) null);
    }

    @Test
    public void shouldThrowExceptionIfStringIsEmpty() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        ToAircraftConverter.convert(EMPTY_STRING);
    }

    @Test
    public void shouldThrowExceptionIfNumberFieldsAreIncorrect() {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("It should have 14 fields but was 15"
        );

        // when
        ToAircraftConverter.convert("Airbus A350;;900;;wide body;;long haul;;2;;350;;6680;;6475;;1705;;2;;903;;950;;15000;;wrong1;;?;;");
    }

    @Test
    public void shouldThrowExceptionIfOneOfTheFieldsIsEmpty() {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("One of aircraft fields is blank because: String is blank");

        // when
        ToAircraftConverter.convert("Airbus A350;;900;;wide body;;long haul;;2;;350;;6680;;6475;;1705;;2;;903;;950;;15000;; ;;");
    }

    @Test
    public void shouldConvertToAircraft() {
        // when
        final List<Aircraft> aircraft = ToAircraftConverter.convert(VALID_AIRCRAFT_AS_STRING);

        // then
        assertThat(aircraft).isEqualTo(List.of(AIRCRAFT));

    }

}
