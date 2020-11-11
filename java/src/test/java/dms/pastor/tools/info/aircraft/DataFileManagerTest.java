package dms.pastor.tools.info.aircraft;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DataFileManagerTest {


    @Test
    public void shouldLoadAircraftDataFromFile() {
        // when
        final var aircraftList = DataFileManager.getAircraftDataFromFile();

        // then
        assertThat(aircraftList.size()).isEqualTo(19);
        assertThat(aircraftList.get(5)).isEqualTo(AircraftTestConfig.AIRCRAFT);

    }

}