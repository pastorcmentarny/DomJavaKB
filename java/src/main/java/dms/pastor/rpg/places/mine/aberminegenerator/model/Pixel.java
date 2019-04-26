package dms.pastor.rpg.places.mine.aberminegenerator.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Pixel {
    private boolean penaratable;
    private PixelType type;


    public static Pixel getWallPixel(int x, int y) {
        return new Pixel(false, PixelType.WALL);
    }

    public boolean isWall() {
        return type.equals(PixelType.WALL);
    }
}
