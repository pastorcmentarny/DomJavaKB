package dms.pastor.tasks.pickup;

import dms.pastor.domain.exception.SomethingWentWrongException;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.time.format.TextStyle.FULL_STANDALONE;
import static java.util.Locale.ENGLISH;

public class ReadyToPickupService {

    private static final int INDEX_NOT_FOUND = -1;
    private static final String UNABLE_TO_FIND_ERROR_MESSAGE = "Unable to find pickup time for you, please contact us";

    public String getPickupDateTimeFromShop(LocalDateTime time, Shop shop) {
        final Optional<OpenCloseTime> openCloseTime = shop.getWeeklyOpenCloseTimes().stream().filter(day -> day.isNotClosedWholeDay() && day.getDay().equalsIgnoreCase(time.getDayOfWeek().toString())).findFirst();
        if (openCloseTime.isPresent()) {
            final OpenCloseTime openClose = openCloseTime.get();
            final LocalTime openCloseLocalTime = LocalTime.of(time.getHour(), time.getMinute());
            if (openClose.isClosedWholeDay() || openClose.isClosedAlready(openCloseLocalTime)) {
                return findNextAvailableOpenDay(time, shop, openCloseTime.get());
            }
            if (openCloseLocalTime.isBefore(openClose.getClose()) && openCloseLocalTime.isAfter(openClose.getOpen())) {
                return "You can pickup now.";
            } else if (openCloseLocalTime.isBefore(openClose.getClose()) && openCloseLocalTime.isBefore(openClose.getOpen())) {
                return String.format("You can pickup today at %s", openClose.getOpen().toString());
            }
        }
        return UNABLE_TO_FIND_ERROR_MESSAGE;
    }

    private String findNextAvailableOpenDay(LocalDateTime time, Shop shop, OpenCloseTime openCloseTime) {
        final List<OpenCloseTime> weeklyOpenCloseTimes = shop.getWeeklyOpenCloseTimes();
        final int index = weeklyOpenCloseTimes.indexOf(openCloseTime);

        throwExceptionIfIndexNotFound(index);

        Collections.rotate(weeklyOpenCloseTimes, -index - 1);
        int counter = 1;
        for (OpenCloseTime today : weeklyOpenCloseTimes) {
            if (!today.isClosedWholeDay()) {
                if (today.isOpen24Hour()) {
                    return "You can pickup tomorrow at midnight.";
                } else {
                    LocalDateTime pickupDate = time.plusDays(counter);
                    return getPickupMessageForNextAvailableDay(counter, today, pickupDate);
                }
            }
            counter += 1;
        }
        return UNABLE_TO_FIND_ERROR_MESSAGE;
    }

    private String getPickupMessageForNextAvailableDay(int counter, OpenCloseTime today, LocalDateTime pickupDate) {
        String pickupDateText;
        if (counter == 1) {
            pickupDateText = "tomorrow";
        } else {
            pickupDateText = String.format("%s %s %s %s", pickupDate.getDayOfWeek().getDisplayName(FULL_STANDALONE, ENGLISH), pickupDate.getDayOfMonth(), pickupDate.getMonth().getDisplayName(FULL_STANDALONE, ENGLISH), pickupDate.getYear());
        }
        return String.format("You can pickup from %s at %s", pickupDateText, today.getOpen().toString());
    }

    private void throwExceptionIfIndexNotFound(int index) {
        if (index == INDEX_NOT_FOUND) {
            throw new SomethingWentWrongException("No index found for open time that should exists");
        }
    }
}
