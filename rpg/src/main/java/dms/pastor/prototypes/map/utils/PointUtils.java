package dms.pastor.prototypes.map.utils;

import dms.pastor.prototypes.map.model.Coordinates;
import dms.pastor.prototypes.map.model.Point;
import dms.pastor.prototypes.map.model.TerrainType;

public class PointUtils {

    public static Point createWall(int weight, int width) {
        return new Point(Coordinates.at(weight, width), TerrainType.WALL);
    }
}
