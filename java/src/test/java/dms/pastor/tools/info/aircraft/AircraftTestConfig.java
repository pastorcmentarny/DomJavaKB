package dms.pastor.tools.info.aircraft;

import static dms.pastor.tools.info.aircraft.BodyType.W;
import static dms.pastor.tools.info.aircraft.Role.LONG_HAUL;

public class AircraftTestConfig {
    public static final String VALID_AIRCRAFT_AS_STRING = "Airbus A350;;900;;W;;L;;2;;350;;6680;;6475;;1705;;2;;903;;950;;15000;;140795;;";
    public static final Aircraft AIRCRAFT = Aircraft.builder()
        .model("Airbus A350")
        .variant("900")
        .bodyType(W)
            .role(LONG_HAUL)
        .cockpitCrew(2)
        .passengerCapacityOneClass(350)
        .length(6680)
        .wingspan(6475)
        .height(1705)
        .engines(2)
        .cruiseSpeed(903)
        .maxSpeed(950)
        .range(15000)
        .fuelCapacity(140795)
        .build();
}
