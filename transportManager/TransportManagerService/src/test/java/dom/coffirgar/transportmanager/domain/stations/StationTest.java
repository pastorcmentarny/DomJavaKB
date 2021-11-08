package dom.coffirgar.transportmanager.domain.stations;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class StationTest {

    @Test
    void isNotAStationReturnTrueForWhenIsANoStationObject() {
        // given
        final Station station = Station.noStation();

        // when
        final boolean result = station.isNotAStation();

        // then
        assertThat(result).isTrue();
    }

    @Test
    void isNotAStationReturnFalseForWhenIsAStationObject() {
        // given
        final Station station = Station.passed("Uxbridge,", LocalDate.now());

        // when
        final boolean result = station.isNotAStation();

        // then
        assertThat(result).isFalse();
    }

    @Test
    void isPassedAlreadyReturnFalseForUnknown() {
        // given
        Station station = new Station("Station", Status.UNKNOWN, null, null, null);

        // when
        final boolean result = station.isPassedAlready();

        // then
        assertThat(result).isFalse();

    }

    @Test
    void isPassedAlreadyReturnFalseForNotVisited() {
        // given
        Station station = new Station("Station", Status.NOT_VISITED, null, null, null);

        // when
        final boolean result = station.isPassedAlready();

        // then
        assertThat(result).isFalse();

    }

    @Test
    void isPassedAlreadyReturnTrueForPassed() {
        // given
        Station station = new Station("Station", Status.PASSED, LocalDate.now(), null, null);

        // when
        final boolean result = station.isPassedAlready();

        // then
        assertThat(result).isTrue();

    }

    @Test
    void isPassedAlreadyReturnTrueForVisited() {
        // given
        Station station = new Station("Station", Status.VISITED, LocalDate.now(), LocalDate.now(), LocalDate.now());

        // when
        final boolean result = station.isPassedAlready();

        // then
        assertThat(result).isTrue();

    }


}