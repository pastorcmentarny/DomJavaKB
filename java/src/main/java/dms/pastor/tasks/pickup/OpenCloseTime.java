package dms.pastor.tasks.pickup;

import lombok.Builder;
import lombok.Data;

import java.time.LocalTime;
import java.util.Objects;

import static dms.pastor.utils.ObjectUtils.areAllObjectsNull;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;

@Data
@Builder
public class OpenCloseTime {
    LocalTime open;
    LocalTime close;

    public boolean isClosedWholeDay() {
        return areAllObjectsNull(open, close);
    }

    public boolean isOpen24Hour() {
        return open == LocalTime.MIDNIGHT && close == LocalTime.MIDNIGHT;
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
}
