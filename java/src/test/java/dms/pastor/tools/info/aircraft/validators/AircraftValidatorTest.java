package dms.pastor.tools.info.aircraft.validators;


import org.junit.Test;

import static dms.pastor.tools.info.aircraft.AircraftTestConfig.VALID_AIRCRAFT_AS_STRING;

// edge cases are tested on validators itself, so no need to duplication of test
public class AircraftValidatorTest {

    @Test
    public void shouldValidateAircraftAsString() {
        // given
        AircraftValidator aircraftValidator = new AircraftValidator();

        // when
        AircraftValidator.validate(VALID_AIRCRAFT_AS_STRING);
        // then no exception happen
    }
}