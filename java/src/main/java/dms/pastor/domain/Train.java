package dms.pastor.domain;

import dms.pastor.utils.TextUtils;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Train {
    private String trainId;
    private TrainType trainType;
    private boolean inService;
    private int maxSpeed;
    private String description;

    @Override
    public String toString() {
        return "Train{" +
                "British Class:'" + trainId + '\'' +
                ", Train Type:" + trainType +
                ", Is it service?:" + TextUtils.getYesNoFromBoolean(inService) +
                ", maxSpeed(in kmh)=" + maxSpeed +
                ",\ndescription='" + description + '\'' +
                '}';
    }
}
