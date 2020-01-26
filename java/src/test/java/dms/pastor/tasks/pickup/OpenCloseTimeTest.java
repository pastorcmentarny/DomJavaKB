package dms.pastor.tasks.pickup;


import org.junit.Test;

import java.time.LocalTime;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class OpenCloseTimeTest {


    @Test
    public void shouldReturnTrueIsShopIsNotOpenOnThatDay() {
        // given
        final OpenCloseTime allDayClosed = OpenCloseTime.builder().build();
        // when
        final boolean isClosed = allDayClosed.isClosedWholeDay();

        // then
        assertThat(isClosed).isTrue();
    }

    @Test
    public void shouldReturnFalseIsShopHasOpenTimesOnly() {
        // given
        final OpenCloseTime allDayClosed = OpenCloseTime.builder().open(LocalTime.now()).build();
        // when
        final boolean isClosed = allDayClosed.isClosedWholeDay();

        // then
        assertThat(isClosed).isFalse();
    }

    @Test
    public void shouldReturnFalseIsShopHasCloseTimesOnly() {
        // given
        final OpenCloseTime allDayClosed = OpenCloseTime.builder().close(LocalTime.now()).build();
        // when
        final boolean isClosed = allDayClosed.isClosedWholeDay();

        // then
        assertThat(isClosed).isFalse();
    }

    @Test
    public void shouldReturnFalseIsShopHasOpenAndCloseTimes() {
        // given
        final OpenCloseTime allDayClosed = OpenCloseTime.builder()
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
                .open(LocalTime.MIDNIGHT)
                .close(LocalTime.now())
                .build();
        // when
        final boolean isOpen24h = isNotOpen24h.isOpen24Hour();

        // then
        assertThat(isOpen24h).isFalse();
    }

}