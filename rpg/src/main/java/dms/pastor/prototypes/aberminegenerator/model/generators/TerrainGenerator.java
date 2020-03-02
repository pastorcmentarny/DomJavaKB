package dms.pastor.prototypes.aberminegenerator.model.generators;

import dms.pastor.prototypes.aberminegenerator.model.Pixel;
import dms.pastor.utils.ValidatorUtils;

public class TerrainGenerator {
    public static Pixel[][] generateGrass(int defaultWorldWidth, int defaultWorldHeight) {
        validateIfMapSizeIsValid(defaultWorldWidth, defaultWorldHeight);

        final var pixels = new Pixel[defaultWorldWidth + 1][defaultWorldHeight + 1];

        for (int width = 0; width <= defaultWorldWidth; width++) {
            for (int height = 0; height <= defaultWorldHeight; height++) {
                pixels[width][height] = Pixel.getGrassAt(width, height);
            }
        }
        return pixels;

    }

    private static void validateIfMapSizeIsValid(int defaultWorldWidth, int defaultWorldHeight) {
        ValidatorUtils.validateIfPositiveNumber(defaultWorldWidth, "width");
        ValidatorUtils.validateIfPositiveNumber(defaultWorldHeight, "height");
    }
}
