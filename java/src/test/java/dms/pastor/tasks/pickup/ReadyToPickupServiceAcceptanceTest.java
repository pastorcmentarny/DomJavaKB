package dms.pastor.tasks.pickup;


import dms.pastor.tasks.pickup.generators.ShopGenerator;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class ReadyToPickupServiceAcceptanceTest {
    ReadyToPickupService readyToPickupService = new ReadyToPickupService();

    @Test
    public void shouldReturnPickupNowIfShopIsCurrentlyOpen() {
        // given
        final var typicalShop = ShopGenerator.getTypicalShop();
        // when
        final var dateTime = LocalDateTime.of(2020, 1, 29, 17, 26);
        final var result = readyToPickupService.getPickupDateTimeFromShop(dateTime, typicalShop);
        // then
        assertThat(result).isEqualTo("You can pickup now.");
    }

    @Test
    public void shouldReturnPickupTodayAtOpenTime() {
        // given
        final var typicalShop = ShopGenerator.getTypicalShop();
        final var dateTime = LocalDateTime.of(2020, 1, 29, 3, 1);

        // when
        final var result = readyToPickupService.getPickupDateTimeFromShop(dateTime, typicalShop);

        // then
        assertThat(result).isEqualTo("You can pickup today at 09:00");
    }

    @Test
    public void shouldReturnPickupTomorrowAtOpenTime() {
        // given
        final var typicalShop = ShopGenerator.getTypicalShop();
        final var dateTime = LocalDateTime.of(2020, 1, 29, 22, 58);

        // when
        final var result = readyToPickupService.getPickupDateTimeFromShop(dateTime, typicalShop);

        // then
        assertThat(result).isEqualTo("You can pickup from tomorrow at 09:00");
    }


    @Test
    public void shouldReturnPickupOnFirstAvailableDayAtOpenTime() {
        // given
        final var openOnWeekdaysOnlyShop = ShopGenerator.getShopOpenOnlyOnWeekdays();
        final var dateTime = LocalDateTime.of(2020, 1, 24, 22, 58);

        // when
        final var result = readyToPickupService.getPickupDateTimeFromShop(dateTime, openOnWeekdaysOnlyShop);

        // then
        assertThat(result).isEqualTo("You can pickup from Monday 27 January 2020 at 09:00");
    }


    //TODO as bonus task shouldReturnPickupTomorrowAtMidnightFor24HoursShop()

}