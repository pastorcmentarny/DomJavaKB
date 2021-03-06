package dms.pastor.tasks.pickup.generators;

import dms.pastor.tasks.pickup.OpenCloseTime;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.List;

import static dms.pastor.tasks.pickup.generators.WeeklyOpenCloseTimesGenerator.*;
import static org.assertj.core.api.Assertions.assertThat;


public class WeeklyOpenCloseTimesGeneratorAcceptanceTest {

    @Test
    public void getTypicalWeeklyOpenCloseTimes() {
        // when
        final List<OpenCloseTime> result = WeeklyOpenCloseTimesGenerator.getTypicalWeeklyOpenCloseTimes();

        // then
        assertThat(result.size()).isEqualTo(7);
        assertThat(result.get(0)).usingRecursiveComparison().isEqualTo(getNormalOpenCloseHoursFor("MONDAY"));
        assertThat(result.get(5)).usingRecursiveComparison().isEqualTo(getNormalOpenCloseHoursForSaturday());
        assertThat(result.get(6)).usingRecursiveComparison().isEqualTo(getNormalOpenCloseHoursForSunday());

    }

    @Test
    public void getWeekOnlyOpenCloseTimes() {
        // when
        final var result = WeeklyOpenCloseTimesGenerator.getWeekOnlyOpenCloseTimes();

        // then
        assertThat(result.size()).isEqualTo(7);
        assertThat(result.get(0)).usingRecursiveComparison().isEqualTo(OpenCloseTime.builder().day("MONDAY").open(LocalTime.of(9, 0)).close(LocalTime.of(19, 30)).build());
        assertThat(result.get(5)).usingRecursiveComparison().isEqualTo(OpenCloseTime.getClosedOn("SATURDAY"));
        assertThat(result.get(6)).usingRecursiveComparison().isEqualTo(OpenCloseTime.getClosedOn("SUNDAY"));

    }

    @Test
    public void getOpen24HoursPerDay7DaysAWeek() {
        // when
        final var result = WeeklyOpenCloseTimesGenerator.getOpen24HoursPerDay7DaysAWeek();

        // then
        assertThat(result.size()).isEqualTo(7);
        result.forEach(day -> assertThat(day.getOpen()).isEqualTo(LocalTime.MIDNIGHT));
        result.forEach(day -> assertThat(day.getClose()).isEqualTo(LocalTime.MIDNIGHT));
    }
}