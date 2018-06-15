package dms.pastor.tools.trips.tube;

import dms.pastor.tools.trips.tube.station.ToStationConverter;
import dms.pastor.tools.trips.tube.station.TubeStation;
import org.junit.Test;

import java.time.LocalDate;

import static dms.pastor.tools.trips.tube.station.Status.VISITED;
import static dms.pastor.tools.trips.tube.station.TubeStation.SEPARATOR;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ToTubeStationConverterTest {

    private static final LocalDate PASSED_DATE = LocalDate.now();
    private static final LocalDate VISITED_DATE = LocalDate.now();
    private static final LocalDate THIS_YEAR_VISITED_DATE = LocalDate.now();
    private static final boolean BLOGGED = true;

    @Test
    public void convertShouldConvertStationAsStringToObject() {
        // given

        final String stationAsString = "Chesham;;V;;" + PASSED_DATE + SEPARATOR + VISITED_DATE + SEPARATOR + THIS_YEAR_VISITED_DATE + SEPARATOR + "Y";
        final TubeStation expectedTubeStation = new TubeStation("Chesham", VISITED, PASSED_DATE, VISITED_DATE, THIS_YEAR_VISITED_DATE, BLOGGED);

        // when
        final TubeStation tubeStation = ToStationConverter.convert(stationAsString);

        // then
        assertThat(tubeStation).isEqualTo(expectedTubeStation);
    }

    @Test
    public void getStatusAsValue() {
        // given
        final TubeStation tubeStation = new TubeStation("Amersham", VISITED, PASSED_DATE, VISITED_DATE, THIS_YEAR_VISITED_DATE, BLOGGED);

        // when
        final String result = tubeStation.getStatusAsValue();

        // then
        assertThat(result).isEqualTo(VISITED.value());
    }

    @Test
    public void asLine() {
        // given
        final TubeStation tubeStation = new TubeStation("Amersham", VISITED, PASSED_DATE, VISITED_DATE, THIS_YEAR_VISITED_DATE, BLOGGED);

        // when
        final String result = tubeStation.getStatusAsValue();

        // then
        assertThat(result).isEqualTo(VISITED.value());
    }

}
