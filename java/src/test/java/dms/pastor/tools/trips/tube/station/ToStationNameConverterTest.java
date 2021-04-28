package dms.pastor.tools.trips.tube.station;


import dms.pastor.tools.trips.common.options.Status;
import dms.pastor.tools.trips.common.station.Station;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static dms.pastor.tools.trips.common.station.StationName.MOORGATE;
import static dms.pastor.tools.trips.common.station.ToStationConverter.convert;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 11/06/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ToStationNameConverterTest {

    @Test
    public void shouldConvertToTubeStation() {
        final LocalDate date = LocalDate.of(2017, 1, 1);
        // given
        final var stationAsString = "Moorgate;;V;;2017-01-01;;2017-01-01;;2017-01-01;;Y";
        final Station expectedResult = new Station(MOORGATE.getStationName(), Status.VISITED, date, date, date, true);

        // when
        final Station result = convert(stationAsString);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void wasBloggedShouldReturnFalseForN() {
        final LocalDate date = LocalDate.of(2017, 1, 1);
        // given
        final var stationAsString = "Moorgate;;V;;2017-01-01;;2017-01-01;;2017-01-01;;N";
        final Station expectedResult = new Station(MOORGATE.getStationName(), Status.VISITED, date, date, date, false);

        // when
        final Station result = convert(stationAsString);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

}