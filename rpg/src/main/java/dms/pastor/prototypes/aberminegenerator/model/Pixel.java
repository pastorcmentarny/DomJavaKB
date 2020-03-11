package dms.pastor.prototypes.aberminegenerator.model;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

import static dms.pastor.prototypes.aberminegenerator.model.TerrainType.*;

@Slf4j
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

    public static Pixel getPixelFromCharacter(char charAt, int x, int y) {
        final TerrainType terrainType = getTerrainFromChar(charAt);
        return buildPixel(terrainType.isPenetrableByDefault(), terrainType, x, y);
    }
    //Temporary solution
    public TerrainType getType() {
        if (Objects.isNull(type)) {
            log.warn("Not type specified for pixel. Out of range?");
            return UNKNOWN;
        } else {
            return type;
        }
    }

    public boolean isWall() {
        return type.equals(WALL);
    }
}
