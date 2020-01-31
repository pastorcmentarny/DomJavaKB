package dms.pastor.tasks.pickup;

import dms.pastor.utils.ValidatorUtils;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalTime;
import java.util.Objects;

import static dms.pastor.utils.ObjectUtils.areAllObjectsNull;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static java.time.LocalTime.MIDNIGHT;


@Builder
@Getter
@EqualsAndHashCode
public class OpenCloseTime {
    private final String day;
    private final LocalTime open;
    private final LocalTime close;

    public OpenCloseTime(String day, LocalTime open, LocalTime close) {
        ValidatorUtils.validateIfNotEmpty(day, "Day");
        this.day = day.toUpperCase();
        this.open = open;
        this.close = close;
    }


    public boolean isClosedWholeDay() {
        return areAllObjectsNull(open, close);
    }

    public boolean isClosedAlready(LocalTime time) {
        return time.isAfter(close);
    }

    public boolean isOpen24Hour() {
        return open == MIDNIGHT && close == MIDNIGHT;
    }

    public String getOpenCloseTimeAsText() {
        if (isOpen24Hour()) {
            return "Open 24 hours";
        }

        if (isClosedWholeDay()) {
            return "Closed";
        }

        if (Objects.isNull(open) || Objects.isNull(close)) {
            return EMPTY_STRING;
        }

        return String.format("%s - %s", open.toString(), close.toString());
    }

    public static OpenCloseTime getClosedOn(String day) {
        return new OpenCloseTime(day, null, null);
    }

    public static OpenCloseTime getOpen24HoursOn(String day) {
        return new OpenCloseTime(day, MIDNIGHT, MIDNIGHT);
    }
}
