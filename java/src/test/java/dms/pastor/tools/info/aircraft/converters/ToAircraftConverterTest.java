package dms.pastor.tools.info.aircraft.converters;


import dms.pastor.tools.info.aircraft.Aircraft;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static dms.pastor.tools.info.aircraft.AircraftTestConfig.AIRCRAFT;
import static dms.pastor.tools.info.aircraft.AircraftTestConfig.VALID_AIRCRAFT_AS_STRING;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static org.assertj.core.api.Assertions.assertThat;

public class ToAircraftConverterTest {



    @Test
    public void shouldThrowExceptionIfStringIsNull() {
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        ToAircraftConverter.convert((String) null);

        });

    }

    @Test
    public void shouldThrowExceptionIfStringIsEmpty() {
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        ToAircraftConverter.convert(EMPTY_STRING);
        });

    }

    @Test
    public void shouldThrowExceptionIfNumberFieldsAreIncorrect() {
        // when
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> ToAircraftConverter.convert("Airbus A350;;900;;wide body;;long haul;;2;;350;;6680;;6475;;1705;;2;;903;;950;;15000;;wrong1;;?;;"));

        // then
         assertThat(exception.getMessage()).isEqualTo("It should have 14 fields but was 15");
    }

    @Test
    public void shouldThrowExceptionIfOneOfTheFieldsIsEmpty() {
        // when
        final var exception = Assertions.assertThrows(IllegalArgumentException.class,() ->         ToAircraftConverter.convert("Airbus A350;;900;;wide body;;long haul;;2;;350;;6680;;6475;;1705;;2;;903;;950;;15000;; ;;"));

        // then
         assertThat(exception.getMessage()).isEqualTo("One of aircraft fields is blank because: String is blank");
    }

    @Test
    public void shouldConvertToAircraft() {
        // when
        final List<Aircraft> aircraft = ToAircraftConverter.convert(VALID_AIRCRAFT_AS_STRING);

        // then
        assertThat(aircraft).isEqualTo(List.of(AIRCRAFT));

    }

}
