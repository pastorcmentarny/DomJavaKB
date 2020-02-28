package dms.pastor.prototypes.aberminegenerator.model;

import dms.pastor.utils.ValidatorUtils;

public class PixelUtils {
    private PixelUtils(){}

    public static Pixel[][] clone2DArrayOfInts(Pixel[][] source) {
        ValidatorUtils.validateIfObjectValueIsNotNull(source, "2D Array of integers cannot be null.");

        if (source.length == 0) {
            return new Pixel[][]{};
        }

        int length = source.length;
        Pixel[][] destination = new Pixel[length][source[0].length];
        for (int i = 0; i < length; i++) {
            System.arraycopy(source[i], 0, destination[i], 0, source[i].length);
        }
        return destination;
    }
}
