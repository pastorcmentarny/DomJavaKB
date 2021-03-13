package dms.pastor.examples.patterns.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class Train {
    private final String name;
    private final int maxSpeedInKm;
    private final int capacity;
}
