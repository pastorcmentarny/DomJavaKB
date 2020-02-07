package dms.pastor.tools.info.aircraft.validators;

import dms.pastor.utils.ValidatorUtils;

import java.util.Arrays;

import static dms.pastor.utils.file.TextFileUtils.FIELD_SEPARATOR;

public class AircraftValidator {
    private static final int FIELDS = 14;

    private AircraftValidator() {
    }

    public static void validate(String aircraftAsString) {
        ValidatorUtils.validateIfNotEmpty(aircraftAsString);
        final String[] aircraftFields = aircraftAsString.split(FIELD_SEPARATOR);
        if (aircraftFields.length != FIELDS) {
            throw new IllegalArgumentException("It should have " + FIELDS + " fields but was " + aircraftFields.length);
        }
        Arrays.asList(aircraftFields).forEach(field -> ValidatorUtils.validateIfNotBlank(field, "One of aircraft fields"));
    }
}
