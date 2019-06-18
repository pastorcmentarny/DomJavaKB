package dms.pastor.tools.info.aircraft.converters;

import dms.pastor.tools.info.aircraft.Aircraft;
import dms.pastor.tools.info.aircraft.AirplaneFieldExtractor;
import dms.pastor.tools.info.aircraft.validators.AircraftValidator;

import static dms.pastor.utils.file.TextFileUtils.FIELD_SEPARATOR;

public class ToAircraftConverter {

    public static Aircraft convert(String aircraftAsString) {
        final AircraftValidator validator = new AircraftValidator();
        validator.validate(aircraftAsString);
        final var aircraftFields = aircraftAsString.split(FIELD_SEPARATOR);
        final AirplaneFieldExtractor fieldExtractor = new AirplaneFieldExtractor(aircraftFields);
        return Aircraft.builder()
            .model(fieldExtractor.getModel())
            .variant(fieldExtractor.getVariant())
            .bodyType(fieldExtractor.getBodyType())
            .role(fieldExtractor.getRole())
            .cockpitCrew(fieldExtractor.getCockpitCrew())
            .passengerCapacityOneClass(fieldExtractor.getPassengerCapacityOneClass())
            .length(fieldExtractor.getLength())
            .wingspan(fieldExtractor.getWingspan())
            .height(fieldExtractor.getHeight())
            .engines(fieldExtractor.getEngines())
            .cruiseSpeed(fieldExtractor.getCruiseSpeed())
            .maxSpeed(fieldExtractor.getMaxSpeed())
            .range(fieldExtractor.getRange())
            .build();
    }
}
