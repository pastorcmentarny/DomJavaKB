package dms.pastor.examples.mapstruct;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Bus {
    private String manufacturerName;
    private int year;
    private BusType busType;
    private boolean inService;
}
