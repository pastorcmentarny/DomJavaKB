package dms.pastor.prototypes.aberminegenerator.model;

import lombok.Value;

import static dms.pastor.prototypes.aberminegenerator.model.TerrainType.*;

@Value
public class Pixel {
    private boolean penetrable;
    private TerrainType type;
    private Coordinates coordinates;

    public static Pixel buildPixel(boolean penetrable, TerrainType type, int width, int height) {
        return new Pixel(penetrable, type, new Coordinates(width, height));
    }

    public static Pixel getWallAt(int width, int height) {
        return new Pixel(false, WALL, new Coordinates(width, height));
    }

    public static Pixel getGrassAt(int width, int height) {
        return new Pixel(true, GRASS, new Coordinates(width, height));
    }

    public static Pixel getStoneAt(int width, int height) {
        return new Pixel(false, STONE, new Coordinates(width, height));
    }

    public static Pixel getHeroAt(int width, int height) {
        return new Pixel(false, HERO, new Coordinates(width, height));
    }


    public boolean isWall() {
        return type.equals(WALL);
    }
}
