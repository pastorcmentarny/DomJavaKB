package dms.pastor.tasks.pickup;

import dms.pastor.domain.exception.SomethingWentWrongException;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class ReadyToPickupService {

    public static final int INDEX_NOT_FOUND = -1;

    public String getPickupDateTimeFromShop(LocalDateTime time, Shop shop) {
        final Optional<OpenCloseTime> openCloseTime = shop.getWeeklyOpenCloseTimes().stream().filter(x -> x.getDay().equalsIgnoreCase(time.getDayOfWeek().toString())).findFirst();

        if (openCloseTime.isPresent()) {
            final OpenCloseTime openClose = openCloseTime.get();
            final LocalTime openCloseLocalTime = LocalTime.of(time.getHour(), time.getMinute());
            if (openClose.isClosedWholeDay() || openClose.isClosedAlready(openCloseLocalTime)) {
                System.out.println("?");
                return findNextAvailableOpenDay(time, shop, openCloseTime.get());
            }
            if (openCloseLocalTime.isBefore(openClose.getClose()) && openCloseLocalTime.isAfter(openClose.getOpen())) {
                return "You can pickup now.";
            } else if (openCloseLocalTime.isBefore(openClose.getClose()) && openCloseLocalTime.isBefore(openClose.getOpen())) {
                return String.format("You can pickup today at %s", openClose.getOpen().toString());
            }
        }
        return null;
    }

    private String findNextAvailableOpenDay(LocalDateTime time, Shop shop, OpenCloseTime openCloseTime) {
        System.out.println("Checking next available day..");
        final List<OpenCloseTime> weeklyOpenCloseTimes = shop.getWeeklyOpenCloseTimes();
        final int index = weeklyOpenCloseTimes.indexOf(openCloseTime);

        throwExceptionIfIndexNotFound(index);

        Collections.rotate(weeklyOpenCloseTimes, -index - 1);
        int counter = 1;
        String pickupDateText;
        for (OpenCloseTime today : weeklyOpenCloseTimes) {
            if (!today.isClosedWholeDay()) {
                if (today.isOpen24Hour()) {
                    return "You can pickup today at midnight.";
                } else {
                    LocalDateTime pickupDate = time.plusDays(counter);
                    if (counter == 1) {
                        pickupDateText = "tomorrow";
                    } else {
                        pickupDateText = pickupDate.getDayOfWeek().getDisplayName(TextStyle.FULL_STANDALONE, Locale.ENGLISH) + " " + pickupDate.getDayOfMonth() + " " + pickupDate.getMonth().getDisplayName(TextStyle.FULL_STANDALONE, Locale.ENGLISH) + " " + pickupDate.getYear();
                    }
                    return String.format("You can pickup from %s at %s", pickupDateText, today.getOpen().toString());
                }
            }
            counter += 1;
        }
        return null; //TODO change it
    }

    private void throwExceptionIfIndexNotFound(int index) {
        if (index == INDEX_NOT_FOUND) {
            throw new SomethingWentWrongException("No index found for open time that should exists");
        }
    }
}
