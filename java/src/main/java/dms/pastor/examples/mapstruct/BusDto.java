package dms.pastor.examples.mapstruct;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BusDto {
    private String manufacturerName;
    private int produced;
    private String busType;
    private boolean inService;
}
