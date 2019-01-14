package dms.pastor.tools.trips.tube.station;


import dms.pastor.tools.trips.common.options.Status;
import org.junit.Test;

import java.time.LocalDate;

import static dms.pastor.tools.trips.tube.station.ToStationConverter.convert;
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
public class ToStationConverterTest {

    @Test
    public void shouldConvertToTubeStation() {
        final LocalDate date = LocalDate.of(2017, 1, 1);
        // given
        final var stationAsString = "Moorgate;;V;;2017-01-01;;2017-01-01;;2017-01-01;;Y";
        final TubeStation expectedResult = new TubeStation(Station.MOORGATE.getStationName(), Status.VISITED, date, date, date, true);
        // when
        final TubeStation result = convert(stationAsString);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void wasBloggedShouldReturnFalseForN() {
        final LocalDate date = LocalDate.of(2017, 1, 1);
        // given
        final var stationAsString = "Moorgate;;V;;2017-01-01;;2017-01-01;;2017-01-01;;N";
        final TubeStation expectedResult = new TubeStation(Station.MOORGATE.getStationName(), Status.VISITED, date, date, date, false);
        // when
        final TubeStation result = convert(stationAsString);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

}