package dms.pastor.tools.info.aircraft;


import org.junit.Test;

import static dms.pastor.tools.info.aircraft.BodyType.W;
import static dms.pastor.tools.info.aircraft.Role.LONG_HAUL;
import static java.lang.System.lineSeparator;
import static org.assertj.core.api.Assertions.assertThat;

public class AircraftTest {


    @Test
    public void shouldGetInfoForDomBirdCruiser() {
        // given 
        final var aircraft = Aircraft.builder()
            .model("Dom BirdCruiser")
            .variant("403")
            .bodyType(W)
                .role(LONG_HAUL)
            .cockpitCrew(3)
            .passengerCapacityOneClass(666)
            .length(10000)
            .wingspan(3400)
            .height(400)
            .cruiseSpeed(911)
            .maxSpeed(999)
            .range(20000)
            .fuelCapacity(150000)
            .build();

        final String expectedResult = "Model: Dom BirdCruiser(403)" + lineSeparator() +
            "Body Type: " + W.getDescription() + lineSeparator() +
                "Role: " + LONG_HAUL.getDescription() + lineSeparator() +
            "Cockpit crew: 3" + lineSeparator() +
            "Passenger Capacity: 666" + lineSeparator() +
            "Length: 100.0m" + lineSeparator() +
            "Wingspan: 34.0m" + lineSeparator() +
            "Height: 4.0m" + lineSeparator() +
            "Engines: 0" + lineSeparator() +
            "Cruise Speed: 911km/h" + lineSeparator() +
            "Max Speed: 911km/h" + lineSeparator() +
            "Range: 20000km" + lineSeparator() +
            "Fuel Capacity: 150000l";

        // when
        final var aircraftInfo = aircraft.info();

        // then
        assertThat(aircraftInfo).isEqualTo(expectedResult);

    }

}