package dms.pastor.tasks.pickup;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static org.assertj.core.api.Assertions.assertThat;

public class OpenCloseTimeTest {


    private static final String DAY_OF_THE_WEEK = LocalDate.now().getDayOfWeek().toString();

    @Test
    public void shouldThrowExceptionIfDayIsNull() {
        System.out.println(DAY_OF_THE_WEEK);
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> new OpenCloseTime(null, LocalTime.now(), LocalTime.now()));

    }

    @Test
    public void shouldThrowExceptionIfDayIsEmpty() {
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> new OpenCloseTime(EMPTY_STRING, LocalTime.now(), LocalTime.now()));

    }

    @Test
    public void shouldReturnTrueIsShopIsNotOpenOnThatDay() {
        // given
        final OpenCloseTime allDayClosed = OpenCloseTime.builder()
                .day(DAY_OF_THE_WEEK)
                .build();
        // when
        final boolean isClosed = allDayClosed.isClosedWholeDay();

        // then
        assertThat(isClosed).isTrue();
    }

    @Test
    public void shouldReturnFalseIsShopHasOpenTimesOnly() {
        // given
        final OpenCloseTime allDayClosed = OpenCloseTime.builder()
                .day(DAY_OF_THE_WEEK)
                .open(LocalTime.now()).build();
        // when
        final boolean isClosed = allDayClosed.isClosedWholeDay();

        // then
        assertThat(isClosed).isFalse();
    }

    @Test
    public void shouldReturnFalseIsShopHasCloseTimesOnly() {
        // given
        final OpenCloseTime allDayClosed = OpenCloseTime.builder()
                .day(DAY_OF_THE_WEEK)
                .close(LocalTime.now()).build();
        // when
        final boolean isClosed = allDayClosed.isClosedWholeDay();

        // then
        assertThat(isClosed).isFalse();
    }

    @Test
    public void shouldReturnFalseIsShopHasOpenAndCloseTimes() {
        // given
        final OpenCloseTime allDayClosed = OpenCloseTime.builder()
                .day(DAY_OF_THE_WEEK)
                .open(LocalTime.now())
                .close(LocalTime.now())
                .build();
        // when
        final boolean isClosed = allDayClosed.isClosedWholeDay();

        // then
        assertThat(isClosed).isFalse();
    }

    @Test
    public void shouldReturnTrueIfIfShopIsOpen24hrFromMidnightToMidnight() {
        // given
        final OpenCloseTime open24h = OpenCloseTime.builder()
                .day(DAY_OF_THE_WEEK)
                .open(LocalTime.MIDNIGHT)
                .close(LocalTime.MIDNIGHT)
                .build();
        // when
        final boolean isOpen24h = open24h.isOpen24Hour();

        // then
        assertThat(isOpen24h).isTrue();
    }

    @Test
    public void shouldReturnFalseIfIfShopIsNotOpen24hrIfOpenAndCloseTimeAreNotMidnight() {
        // given
        LocalTime open;
        LocalTime close;
        if (new Random().nextBoolean()) {
            open = LocalTime.now();
            close = LocalTime.MIDNIGHT;
        } else {
            open = LocalTime.MIDNIGHT;
            close = LocalTime.now();
        }
        final OpenCloseTime isNotOpen24h = OpenCloseTime.builder()
                .day(DAY_OF_THE_WEEK)
                .open(open)
                .close(close)
                .build();
        // when
        final boolean isOpen24h = isNotOpen24h.isOpen24Hour();

        // then
        assertThat(isOpen24h).isFalse();
    }


    @Test
    public void shouldReturnOpen24HoursMessageIfOpenAndCloseTimeAreMidnight() {
        // given
        final OpenCloseTime openTimes = OpenCloseTime.builder()
                .day(DAY_OF_THE_WEEK)
                .open(LocalTime.MIDNIGHT)
                .close(LocalTime.MIDNIGHT)
                .build();
        // when
        final var result = openTimes.getOpenCloseTimeAsText();
        // then
        assertThat(result).isEqualTo("Open 24 hours");
    }

    @Test
    public void shouldReturnClosedIfShopHasNoOpenAndClosedTimes() {
        // given
        final OpenCloseTime openTimes = OpenCloseTime.builder()
                .day(DAY_OF_THE_WEEK)
                .build();
        // when
        final var result = openTimes.getOpenCloseTimeAsText();
        // then
        assertThat(result).isEqualTo("Closed");
    }

    @Test
    public void shouldReturnEmptyStringIfShopMissingOpenTime() {
        // given
        final OpenCloseTime openTimes = OpenCloseTime.builder()
                .day(DAY_OF_THE_WEEK)
                .open(LocalTime.now())
                .build();
        // when
        final var result = openTimes.getOpenCloseTimeAsText();

        // then
        assertThat(result).isEmpty();
    }

    @Test
    public void shouldReturnEmptyStringIfShopMissingClosedTime() {
        // given
        final OpenCloseTime openTimes = OpenCloseTime.builder()
                .day(DAY_OF_THE_WEEK)
                .close(LocalTime.now())
                .build();
        // when
        final var result = openTimes.getOpenCloseTimeAsText();

        // then
        assertThat(result).isEmpty();
    }

    @Test
    public void shouldReturnOpenAndCloseTimeAsText() {
        // given
        final OpenCloseTime openTimes = OpenCloseTime.builder()
                .day(DAY_OF_THE_WEEK)
                .open(LocalTime.of(10, 0))
                .close(LocalTime.of(22, 0))
                .build();
        // when
        final var result = openTimes.getOpenCloseTimeAsText();

        // then
        assertThat(result).isEqualTo("10:00 - 22:00");
    }


    @Test
    public void getOpen24HoursAcceptanceTest() {
        // when
        final var open24hours = OpenCloseTime.getOpen24HoursOn(DAY_OF_THE_WEEK);

        // then
        assertThat(open24hours.getDay()).isEqualTo(DAY_OF_THE_WEEK);
        assertThat(open24hours.getOpen()).isEqualTo(LocalTime.MIDNIGHT);
        assertThat(open24hours.getClose()).isEqualTo(LocalTime.MIDNIGHT);
    }

    @Test
    public void getClosedWholeDayAcceptanceTest() {
        // when
        final var open24hours = OpenCloseTime.getClosedOn(DAY_OF_THE_WEEK);

        // then
        assertThat(open24hours.getDay()).isEqualTo(DAY_OF_THE_WEEK);
        assertThat(open24hours.getOpen()).isNull();
        assertThat(open24hours.getClose()).isNull();
    }
}