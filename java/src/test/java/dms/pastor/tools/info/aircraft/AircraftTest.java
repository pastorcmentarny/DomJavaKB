package dms.pastor.tools.info.aircraft;


import org.junit.Test;

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

        final String expectedResult = "Model: Dom BirdCruiser(403)\n" +
            "Body Type: Wide Body\n" +
            "Role: Long Haul\n" +
            "Cockpit crew: 3\n" +
            "Passenger Capacity: 666\n" +
            "Length: 0\n" +
            "Wingspan: 3400\n" +
            "Height: 400\n" +
            "Engines: 0\n" +
            "Cruise Speed: 911\n" +
            "Max Speed: 911\n" +
            "Range: 20000\n" +
            "Fuel Capacity: 150000";

        // when
        final var aircraftInfo = aircraft.info();

        // then
        assertThat(aircraftInfo).isEqualTo(expectedResult);

    }

}