package dms.pastor.tools.trips.common;

import dms.pastor.tools.trips.common.station.StationType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class ConstantsTest {

    @Test
    void get_all_stations_number_for_tube() {
        // when
        int result = Constants.get_all_stations_number_for(StationType.TUBE);

        // then
        assertThat(result).isEqualTo(Constants.ALL_TUBE_STATIONS);
    }

    @Test
    void get_all_stations_number_for_overground() {
        // when
        int result = Constants.get_all_stations_number_for(StationType.OVERGROUND);

        // then
        assertThat(result).isEqualTo(Constants.ALL_OVERGROUND_STATIONS);
    }
}