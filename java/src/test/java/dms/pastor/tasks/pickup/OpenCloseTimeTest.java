package dms.pastor.tasks.pickup;


import org.junit.Test;

import java.time.LocalTime;

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
}