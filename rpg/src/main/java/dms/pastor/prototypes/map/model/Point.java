package dms.pastor.prototypes.map.model;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import static dms.pastor.prototypes.map.model.Coordinates.noCoordination;
import static dms.pastor.prototypes.map.model.TerrainType.UNKNOWN;


/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Point {
    private final Coordinates coordinates;
    private final TerrainType terrainType;

    public static Point noPoint() {
        return new Point(noCoordination(), UNKNOWN);
    }

}
