package dms.pastor.tools.info.aircraft.converters;


import dms.pastor.tools.info.aircraft.Aircraft;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static dms.pastor.tools.info.aircraft.AircraftTestConfig.VALID_AIRCRAFT_AS_STRING;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static org.assertj.core.api.Assertions.assertThat;

public class ToAircraftConverterTest {

    private ToAircraftConverter converter = new ToAircraftConverter();

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldThrowExceptionIfStringIsNull() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        converter.convert(null);
    }

    @Test
    public void shouldThrowExceptionIfStringIsEmpty() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        converter.convert(EMPTY_STRING);
    }

    @Test
    public void shouldThrowExceptionIfNumberFieldsAreIncorrect() {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("It should have 13 fields but was 15"
        );

        // when
        converter.convert("Airbus A350;;900;;wide body;;long haul;;2;;350;;6680;;6475;;1705;;2;;903;;950;;15000;;wrong1;;?;;");
    }

    @Test
    public void shouldThrowExceptionIfOneOfTheFieldsIsEmpty() {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("One of aircraft fields is blank because: String is blank");

        // when
        converter.convert("Airbus A350;;900;;wide body;;long haul;;2;;350;;6680;;6475;;1705;;2;;903;;950;; ;;");
    }

    @Test
    public void shouldConvertToAircraft() {
        // given
        final var expectedResult = Aircraft.builder()
            .model("Airbus A350")
            .variant("900")
            .bodyType("wide body")
            .role("long haul")
            .cockpitCrew(2)
            .passengerCapacityOneClass(350)
            .length(6680)
            .wingspan(6475)
            .height(1705)
            .engines(2)
            .cruiseSpeed(903)
            .maxSpeed(950)
            .range(15000)
            .build();

        // when
        final var aircraft = converter.convert(VALID_AIRCRAFT_AS_STRING);

        // then
        assertThat(aircraft).isEqualTo(expectedResult);

    }

}
