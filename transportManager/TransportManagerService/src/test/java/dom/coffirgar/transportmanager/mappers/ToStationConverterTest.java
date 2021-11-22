package dom.coffirgar.transportmanager.mappers;

import dom.coffirgar.transportmanager.AbstractTest;
import dom.coffirgar.transportmanager.domain.stations.Station;
import dom.coffirgar.transportmanager.domain.stations.Status;
import dom.coffirgar.transportmanager.exceptions.NotFoundException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static dom.coffirgar.transportmanager.domain.stations.StationName.MOORGATE;
import static dom.coffirgar.transportmanager.mappers.ToStationConverter.fromStationAsString;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Author Dominik Symonowicz
 * Created 11/06/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ToStationConverterTest extends AbstractTest {


    @Test
    public void shouldConvertToTubeStation() {
        final LocalDate date = LocalDate.of(2017, 1, 1);
        // given
        final var stationAsString = "Moorgate;;V;;2017-01-01;;2017-01-01;;2017-01-01";
        final Station expectedResult = new Station(MOORGATE.getStationName(), Status.VISITED, date, date, date);

        // when
        final Station result = fromStationAsString(stationAsString);

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
        final Station result = fromStationAsString(stationAsString);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void toStationAsJsonShouldReturnStationAsJsonAsString() {
        // given
        final String expectedResult = """
                {"name":"Uxbridge","status":"VISITED","passedDate":"2021-11-21","visitedDate":"2021-11-21","visitedThisYearDate":"2021-11-21"}""";
        final LocalDate date = LocalDate.of(2021, 11, 21);
        final Station station = new Station("Uxbridge", Status.VISITED, date, date, date);
        ToStationConverter converter = new ToStationConverter(getObjectMapper());

        // when
        final String result = converter.toStationAsJson(station);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void toStationAsJsonShouldReturnNoStationAsJsonAsString() {
        // given
        final String expectedResult = """
                {"name":"","status":"UNKNOWN","passedDate":null,"visitedDate":null,"visitedThisYearDate":null}""";
        ToStationConverter converter = new ToStationConverter(getObjectMapper());

        // when
        final String result = converter.toStationAsJson(Station.noStation());

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void toStationAsJsonShouldReturnNotFoundException() {
        // given
        ToStationConverter converter = new ToStationConverter(getObjectMapper());
        final String expectedResult = "{}";

        // when
        final String result = converter.toStationAsJson(null);

        // then
        assertThat(result).isEqualTo(expectedResult);

    }

}