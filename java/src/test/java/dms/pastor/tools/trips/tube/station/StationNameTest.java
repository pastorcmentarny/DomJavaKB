package dms.pastor.tools.trips.tube.station;

import dms.pastor.tools.trips.common.station.StationName;
import dms.pastor.tools.trips.common.station.StationType;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static dms.pastor.tools.trips.common.station.StationName.CHESHAM;
import static dms.pastor.tools.trips.common.station.StationType.TUBE;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 08/06/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class StationNameTest {

    @Test
    public void shouldBe353TubeStations() {
        // given
        Set<StationName> uniqueStationNames = Stream.of(StationName.values()).collect(Collectors.toSet());

        // then
        assertThat(uniqueStationNames).hasSize(353);
    }

    @Test
    public void shouldBe270TubeStations() {
        // given
        Set<StationName> uniqueStationNames = Stream.of(StationName.values()).filter(stationName -> StationType.isTubeType(stationName.getStationType())).collect(Collectors.toSet());

        // then
        assertThat(uniqueStationNames).hasSize(270);
    }

    @Test
    public void shouldBe112vergroundStations() {
        // given
        Set<StationName> uniqueStationNames = Stream.of(StationName.values()).filter(stationName -> StationType.isOvergroundType(stationName.getStationType())).collect(Collectors.toSet());

        // then
        assertThat(uniqueStationNames).hasSize(112);
    }

    @Test
    public void hasShouldReturnTrueForExistingStation() {
        assertThat(StationName.has("Wembley Park")).isTrue();
    }

    @Test
    public void hasShouldReturnFalseForNonExistingStation() {
        assertThat(StationName.has("London Park")).isFalse();
    }


    @Test
    public void shouldReturnTubeTypeForChesham() {
        assertThat(CHESHAM.getStationType()).isEqualTo(TUBE);
    }
}