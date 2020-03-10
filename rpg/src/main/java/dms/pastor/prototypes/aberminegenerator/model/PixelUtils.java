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

    public static String[] toArrayOfTiles(Pixel[][] source){
        int width = source.length-1;
        int height = source[0].length-1;
        String[] array = new String[(width+1)*(height+1)];
        int array_position = 0;
        for (int y = 0; y <= height; y++) {
            for (int x = 0; x <= width; x++) {
                    array[array_position] = source[x][y].getType().getTile();
                    array_position++;
                }
            }
        return  array;
    }
}
