package dms.pastor.tools.trips.tube;

import dms.pastor.tools.trips.common.station.ToStationConverter;
import dms.pastor.tools.trips.common.station.Station;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static dms.pastor.tools.trips.common.options.Status.VISITED;
import static dms.pastor.utils.file.TextFileUtils.FIELD_SEPARATOR;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ToOvergroundStationNameConverterTest {

    private static final LocalDate PASSED_DATE = LocalDate.now();
    private static final LocalDate VISITED_DATE = LocalDate.now();
    private static final LocalDate THIS_YEAR_VISITED_DATE = LocalDate.now();
    private static final boolean BLOGGED = true;

    @Test
    public void convertShouldConvertStationAsStringToObject() {
        // given

        final String stationAsString = "Chesham;;V;;" + PASSED_DATE + FIELD_SEPARATOR + VISITED_DATE + FIELD_SEPARATOR + THIS_YEAR_VISITED_DATE + FIELD_SEPARATOR + "Y";
        final Station expectedStation = new Station("Chesham", VISITED, PASSED_DATE, VISITED_DATE, THIS_YEAR_VISITED_DATE, BLOGGED);

        // when
        final Station station = ToStationConverter.convert(stationAsString);

        // then
        assertThat(station).isEqualTo(expectedStation);
    }

    @Test
    public void getStatusAsValue() {
        // given
        final Station station = new Station("Amersham", VISITED, PASSED_DATE, VISITED_DATE, THIS_YEAR_VISITED_DATE, BLOGGED);

        // when
        final String result = station.getStatusAsValue();

        // then
        assertThat(result).isEqualTo(VISITED.value());
    }

    @Test
    public void asLine() {
        // given
        final Station station = new Station("Amersham", VISITED, PASSED_DATE, VISITED_DATE, THIS_YEAR_VISITED_DATE, BLOGGED);

        // when
        final String result = station.getStatusAsValue();

        // then
        assertThat(result).isEqualTo(VISITED.value());
    }

}
