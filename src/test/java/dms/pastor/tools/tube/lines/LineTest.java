package dms.pastor.tools.tube.lines;

import dms.pastor.tools.tube.station.Station;
import dms.pastor.tools.tube.station.StationName;
import dms.pastor.tools.tube.station.Status;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LineTest {

    @Test
    public void has() throws Exception {
        // given

        // when

        // then
    }

    @Test
    public void getPercentageOfTravelledStation() throws Exception {
        // given
        final WaterlooAndCity waterlooAndCity = new WaterlooAndCity();

        final Station waterloo = new Station("Waterloo", Status.VISITED, null, null, null, null);
        final Station bank = new Station("Bank", Status.VISITED, null, null, null, null);
        final List<Station> passedStation = Arrays.asList(waterloo, bank);

        final List<StationName> stationNames = Arrays.asList(StationName.BANK, StationName.WATERLOO);
        // when
        final long result = waterlooAndCity.getPercentageOfTravelledStation(passedStation, stationNames);

        // then
        assertThat(result).isEqualTo(100);
    }

}