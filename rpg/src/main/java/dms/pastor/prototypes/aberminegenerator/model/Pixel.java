package dms.pastor.prototypes.aberminegenerator.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Pixel {
    private boolean penaratable;
    private TerrainType type;


    public static Pixel getWallPixel(int x, int y) {
        return new Pixel(false, TerrainType.WALL);
    }

    public boolean isWall() {
        return type.equals(TerrainType.WALL);
    }
}
