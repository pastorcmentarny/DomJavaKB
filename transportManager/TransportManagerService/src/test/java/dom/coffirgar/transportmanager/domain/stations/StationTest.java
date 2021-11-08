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
}