package dms.pastor.tasks.pickup;

import dms.pastor.utils.ObjectUtils;
import lombok.Builder;
import lombok.Data;

import java.time.LocalTime;
import java.util.Objects;

import static dms.pastor.utils.ObjectUtils.areAllObjectsNull;

@Data
@Builder
public class OpenCloseTime {
    LocalTime open;
    LocalTime close;

    public boolean isClosedWholeDay() {
        return areAllObjectsNull(open, close);
    }
}
