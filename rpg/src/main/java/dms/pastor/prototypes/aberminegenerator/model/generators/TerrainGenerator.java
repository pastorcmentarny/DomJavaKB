package dms.pastor.prototypes.aberminegenerator.model.generators;

import dms.pastor.prototypes.aberminegenerator.model.Pixel;
import dms.pastor.utils.ValidatorUtils;

import static dms.pastor.prototypes.aberminegenerator.model.TerrainType.GRASS;

public class TerrainGenerator {
    public static Pixel[][] generateGrass(int defaultWorldWidth, int defaultWorldHeight) {
        validateIfMapSizeIsValid(defaultWorldWidth, defaultWorldHeight);

        final var pixels = new Pixel[defaultWorldWidth+1][defaultWorldHeight+1];

        for (int x = 0; x <= defaultWorldWidth; x++) {
            for (int y = 0; y <= defaultWorldHeight; y++) {
                pixels[x][y] = new Pixel(false, GRASS);
            }
        }
        return pixels;

    }

    private static void validateIfMapSizeIsValid(int defaultWorldWidth, int defaultWorldHeight) {
        ValidatorUtils.validateIfPositiveNumber(defaultWorldWidth, "width");
        ValidatorUtils.validateIfPositiveNumber(defaultWorldHeight, "height");
    }
}
