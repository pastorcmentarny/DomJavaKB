package dms.pastor.spring.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class Train {
    private final String britishClass;
    private final String name;
    private final TractionType type;
    private final int maxSpeed; //km
    private final boolean tilting;
}
