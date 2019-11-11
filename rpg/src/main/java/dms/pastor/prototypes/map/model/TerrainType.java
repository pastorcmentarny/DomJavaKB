package dms.pastor.prototypes.map.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TerrainType {
    WALL(false, "Wall", "#"),
    FIELD(true, "A field.", "."),
    UNKNOWN(false, "?", "\uD83D\uDC80");


    private final boolean accessible;
    private final String description;
    private final String fill;


}
