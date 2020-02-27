package dms.pastor.prototypes.aberminegenerator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

@Value
public class Pixel {
    private boolean penaratable;
    private TerrainType type;
    private Coordinates coordinates;

    public static Pixel buildPixel(boolean penaratable,TerrainType type,int width, int height){
        return new Pixel(penaratable,type,new Coordinates(width, height));
    }

    public static Pixel getWallPixel(int width, int height) {
        return new Pixel(false, TerrainType.WALL,new Coordinates(width,height));
    }

    public boolean isWall() {
        return type.equals(TerrainType.WALL);
    }
}
