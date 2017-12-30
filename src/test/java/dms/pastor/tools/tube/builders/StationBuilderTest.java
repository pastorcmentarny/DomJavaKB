package dms.pastor.tools.tube.builders;

import dms.pastor.tools.tube.station.Station;
import dms.pastor.tools.tube.station.Status;
import org.junit.Test;

import java.time.LocalDate;

import static dms.pastor.tools.tube.builders.StationBuilder.stationBuilder;
import static dms.pastor.tools.tube.station.Status.NOT_VISITED;
import static dms.pastor.tools.tube.station.Status.VISITED;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Assertions.assertThat;

public class StationBuilderTest {

    @Test
    public void buildShouldReturnStationWithSpecifiedFields() {
        // when
        final String name = generateString(2, 9);
        final LocalDate date = LocalDate.now();
        final Status visitedStation = VISITED;
        final Station result = stationBuilder()
                .lines(null)
                .name(name)
                .passedDate(date)
                .visitedDate(date)
                .status(visitedStation)
                .build();

        // then
        assertThat(result.getName()).isEqualTo(name);
        assertThat(result.getStatus()).isEqualTo(visitedStation);
        assertThat(result.getPassedDate()).isEqualTo(date);
        assertThat(result.getVisitedDate()).isEqualTo(date);
    }

    @Test
    public void buildNotVisitedShouldReturnStationWithNotVisitedStatus() {
        // when
        final Station result = stationBuilder().buildNotVisitedStation();

        // then
        assertThat(result.getName()).isNotNull();
        assertThat(result.getStatus()).isEqualTo(NOT_VISITED);
        assertThat(result.getPassedDate()).isNull();
        assertThat(result.getVisitedDate()).isNull();
    }
}