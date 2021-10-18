package dom.coffirgar.transportmanager.mappers;

import dom.coffirgar.transportmanager.domain.stations.Station;
import dom.coffirgar.transportmanager.domain.stations.Status;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static dom.coffirgar.transportmanager.domain.stations.StationName.MOORGATE;
import static dom.coffirgar.transportmanager.mappers.ToStationConverter.convert;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 11/06/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ToStationConverterTest {

    @Test
    public void shouldConvertToTubeStation() {
        final LocalDate date = LocalDate.of(2017, 1, 1);
        // given
        final var stationAsString = "Moorgate;;V;;2017-01-01;;2017-01-01;;2017-01-01";
        final Station expectedResult = new Station(MOORGATE.getStationName(), Status.VISITED, date, date, date);

        // when
        final Station result = convert(stationAsString);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void wasBloggedShouldReturnFalseForN() {
        final LocalDate date = LocalDate.of(2017, 1, 1);
        // given
        final var stationAsString = "Moorgate;;V;;2017-01-01;;2017-01-01;;2017-01-01";
        final Station expectedResult = new Station(MOORGATE.getStationName(), Status.VISITED, date, date, date);

        // when
        final Station result = convert(stationAsString);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

}