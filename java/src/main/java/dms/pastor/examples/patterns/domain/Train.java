package dms.pastor.examples.patterns.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class Train {
    private String name;
    private int maxSpeedInKm;
    private int capacity;
}
