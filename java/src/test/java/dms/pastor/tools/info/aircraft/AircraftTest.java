package dms.pastor.tools.info.aircraft;


import org.junit.Test;

import static java.lang.System.lineSeparator;
import static org.assertj.core.api.Assertions.assertThat;

public class AircraftTest {


    @Test
    public void shouldGetInfoForDomBirdCruiser() {
        // given 
        final var aircraft = Aircraft.builder()
            .model("Dom BirdCruiser")
            .variant("403")
            .bodyType("Wide Body")
            .role("Long Haul")
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
        lineSeparator();
        final String expectedResult = "Model: Dom BirdCruiser(403)" + lineSeparator() +
            "Body Type: Wide Body" + lineSeparator() +
            "Role: Long Haul" + lineSeparator() +
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