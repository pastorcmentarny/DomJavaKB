package dms.pastor.tools.trips.common;

import dms.pastor.tools.trips.common.station.StationType;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


class ConstantsTest {

    @Test
    void getAllStationsNumberForTube() {
        // when
        int result = Constants.getAllStationsNumberFor(StationType.TUBE);

        // then
        assertThat(result).isEqualTo(Constants.ALL_TUBE_STATIONS);
    }

    @Test
    void getAllStationsNumberForOverground() {
        // when
        int result = Constants.getAllStationsNumberFor(StationType.OVERGROUND);

        // then
        assertThat(result).isEqualTo(Constants.ALL_OVERGROUND_STATIONS);
    }

    @Test
    void getDateAsStringOrNoneReturnNoneForNull(){
        // when
        final var result = Constants.getDateAsStringOrNone(null);

        // then
        assertThat(result).isEqualTo("none");
    }

    @Test
    void getDateAsStringOrNoneReturnNoneForToday(){
        //given
        final var todayDate = LocalDate.of(2021,4,8);

        // when
        final var result = Constants.getDateAsStringOrNone(todayDate);

        // then
        assertThat(result).isEqualTo("2021-04-08");
    }
}