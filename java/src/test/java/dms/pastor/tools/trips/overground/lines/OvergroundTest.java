package dms.pastor.tools.trips.overground.lines;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class OvergroundTest {

    @Test
    void getStationsShouldReturn112StationForOverground() {
        // when
        final var result = new Overground().getStations().size();

        // then
        assertThat(result).isEqualTo(112); //Current number of stations
    }
}