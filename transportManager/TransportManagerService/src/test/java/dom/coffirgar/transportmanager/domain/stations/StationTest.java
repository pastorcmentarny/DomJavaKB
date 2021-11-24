package dom.coffirgar.transportmanager.domain.stations;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static dom.coffirgar.transportmanager.domain.stations.Status.PASSED;
import static dom.coffirgar.transportmanager.domain.stations.Status.VISITED;
import static org.assertj.core.api.Assertions.assertThat;

class StationTest {

    private static final String STATION_NAME = "Station";

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
        Station station = new Station(STATION_NAME, Status.UNKNOWN, null, null, null);

        // when
        final boolean result = station.isPassedAlready();

        // then
        assertThat(result).isFalse();

    }

    @Test
    void isPassedAlreadyReturnFalseForNotVisited() {
        // given
        Station station = new Station(STATION_NAME, Status.NOT_VISITED, null, null, null);

        // when
        final boolean result = station.isPassedAlready();

        // then
        assertThat(result).isFalse();

    }

    @Test
    void isPassedAlreadyReturnTrueForPassed() {
        // given
        Station station = new Station(STATION_NAME, PASSED, LocalDate.now(), null, null);

        // when
        final boolean result = station.isPassedAlready();

        // then
        assertThat(result).isTrue();

    }

    @Test
    void isPassedAlreadyReturnTrueForVisited() {
        // given
        Station station = new Station(STATION_NAME, VISITED, LocalDate.now(), LocalDate.now(), LocalDate.now());

        // when
        final boolean result = station.isPassedAlready();

        // then
        assertThat(result).isTrue();
    }

    @Test
    void isVisitedThisYearAlreadyShouldReturnTrueIfStationWasVisitedThisYear() {
        // given
        Station station = new Station(STATION_NAME, VISITED, LocalDate.now(), LocalDate.now(), LocalDate.now());

        // when
        final boolean result = station.isVisitedThisYearAlready();

        // then
        assertThat(result).isTrue();
    }

    @Test
    void isVisitedThisYearAlreadyShouldReturnFalseIfStationWasPassed() {
        // given
        Station station = new Station(STATION_NAME, PASSED, LocalDate.now(), null, null);

        // when
        final boolean result = station.isVisitedThisYearAlready();

        // then
        assertThat(result).isFalse();
    }


    @Test
    void isVisitedThisYearAlreadyShouldReturnFalseIfStationWasVisitedLastYear() {
        // given
        final LocalDate dayInTheFarAwayPast = LocalDate.now().minusYears(2).minusDays(1);
        Station station = new Station(STATION_NAME, VISITED, LocalDate.now(), dayInTheFarAwayPast, dayInTheFarAwayPast);

        // when
        final boolean result = station.isVisitedThisYearAlready();

        // then
        assertThat(result).isFalse();
    }

    @Test
    void isVisitedThisYearAlreadyShouldReturnFalseIfStationWasVisitedLastYearButDateIsNotThere() {
        // given
        final LocalDate dayInTheFarAwayPast = LocalDate.now().minusYears(2).minusDays(1);
        Station station = new Station(STATION_NAME, VISITED, LocalDate.now(), dayInTheFarAwayPast, null);

        // when
        final boolean result = station.isVisitedThisYearAlready();

        // then
        assertThat(result).isFalse();
    }

    @Test
    void updateStationToVisitedShouldUpdateVisitedAndVisitedThisYear() {
        // given
        final LocalDate today = LocalDate.now();
        final LocalDate yesterday = LocalDate.now().minusDays(1);
        Station station = new Station(STATION_NAME, PASSED, yesterday, null, null);
        Station expectedResult = new Station(STATION_NAME, VISITED, yesterday, today, today);

        // when
        station.updateStationToVisited();

        // then
        assertThat(station).isEqualTo(expectedResult);
    }


    @Test
    void updateStationToVisitedShouldUpdatePassedAndVisitedAndVisitedThisYearIfStationStatusIsNotVisited() {
        // given
        final LocalDate today = LocalDate.now();
        Station station = new Station(STATION_NAME, Status.NOT_VISITED, null, null, null);
        Station expectedResult = new Station(STATION_NAME, VISITED, today, today, today);

        // when
        station.updateStationToVisited();

        // then
        assertThat(station).isEqualTo(expectedResult);
    }

    @Test
    void updateStationToVisitedShouldNotUpdateForVisitedThisYear() {
        // given
        final LocalDate day = LocalDate.of(2021, 2, 21);
        final LocalDate dayBefore = day.minusDays(1);
        Station station = new Station(STATION_NAME, VISITED, dayBefore, dayBefore, dayBefore);
        Station expectedResult = new Station(STATION_NAME, VISITED, dayBefore, dayBefore, dayBefore);

        // when
        station.updateStationToVisited();

        // then
        assertThat(station).isEqualTo(expectedResult);
    }

}