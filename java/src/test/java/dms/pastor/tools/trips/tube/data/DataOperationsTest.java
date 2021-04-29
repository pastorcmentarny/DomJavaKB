package dms.pastor.tools.trips.tube.data;

import dms.pastor.tools.trips.common.station.Station;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DataOperationsTest {

    @Disabled("Issue with importing")
    @Test
    void loadFromFile() {
        // when
        final List<Station> stations = DataOperations.loadFromFile();

        // debug
        System.out.println(stations);

        // then
        assertThat(stations.size()).isEqualTo(270);

    }
}