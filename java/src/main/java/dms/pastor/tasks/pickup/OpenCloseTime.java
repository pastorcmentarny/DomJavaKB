package dms.pastor.tasks.pickup;

import lombok.Builder;
import lombok.Data;

import java.time.LocalTime;

import static dms.pastor.utils.ObjectUtils.areAllObjectsNull;

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
}
