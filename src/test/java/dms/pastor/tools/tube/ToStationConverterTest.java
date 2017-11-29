package dms.pastor.tools.tube;

import org.junit.Test;

import java.time.LocalDate;

import static dms.pastor.tools.tube.Status.VISITED;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 02/11/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ToStationConverterTest {

    private static final LocalDate PASSED_DATE = LocalDate.now();
    private static final LocalDate VISITED_DATE = LocalDate.now();

    @Test
    public void convertShouldConvertStationAsStringToObject() {
        // given
        final String stationAsString = "Chesham;;V;;none;;" + PASSED_DATE + Station.SEPARATOR + VISITED_DATE;
        final Station expectedStation = new Station("Chesham", VISITED, Line.noLine(), PASSED_DATE, VISITED_DATE);

        // when
        final Station station = ToStationConverter.convert(stationAsString);

        // then
        assertThat(station).isEqualTo(expectedStation);
    }

    @Test
    public void getStatusAsValue() {
        // given
        final Station station = new Station("Amersham", VISITED, null, PASSED_DATE, VISITED_DATE);

        // when
        final String result = station.getStatusAsValue();

        // then
        assertThat(result).isEqualTo("V");
    }

    @Test
    public void asLine() {
        // given
        final Station station = new Station("Amersham", VISITED, null, PASSED_DATE, VISITED_DATE);

        // when
        final String result = station.getStatusAsValue();

        // then
        assertThat(result).isEqualTo("V");
    }

}