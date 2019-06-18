package dms.pastor.tools.info.aircraft;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DataFileManagerTest {


    @Test
    public void shouldLoadAircraftDataFromFile() {

        // when
        final var aircraft = DataFileManager.getAircraftDataFromFile();

        // then
        assertThat(aircraft).isEqualTo(AircraftTestConfig.AIRCRAFT);

    }

}