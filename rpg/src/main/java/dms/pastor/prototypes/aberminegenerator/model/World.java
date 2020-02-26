package dms.pastor.prototypes.aberminegenerator.model;


import dms.pastor.utils.StringUtils;
import dms.pastor.utils.ValidatorUtils;
import lombok.EqualsAndHashCode;

import java.util.Arrays;

@EqualsAndHashCode
public class World {
    private int width;
    private int height;
    private Pixel[][] world;

    public World(int width, int height) {
        this.width = width;
        this.height = height;
        world = new Pixel[width][height];
    }

    World(int width, int height, Pixel[][] world) {
        this.width = width;
        this.height = height;
        this.world = clone2DArrayOfInts(world);
    }

    public static World noWorld() {
        return new World(0, 0);
    }

    public Pixel[][] getWorld() {
        return Arrays.copyOf(world, world.length);
    }

    public void setWorld(Pixel[][] world) {
        this.world = world;
    }

    public boolean isCreated() {
        return height > 0 && width > 0;
    }

    public int getPreviousPixelFor(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length " + length + " is invalid because previous pixel will be out of range.");
        }
        return length - 1;
    }

    public void resetToNoWorld() {
        width = 0;
        height = 0;
        world = new Pixel[0][0];
    }

    public void setPixel(Pixel point) {
        // setPixel(point.getWidth(), point.getHeight(), point.getFill());
    }

    public void setPixel(int x, int y, Pixel pixelFill) {
/*
        if (pixelFill == null || pixelFill.length() != 1) {
            throw new IllegalArgumentException(format("It must have one character but it has %d", isNull(pixelFill) ? 0 : pixelFill.length()));
        }
        world[x][y] = pixelFill;
 */
    }

    private Pixel getPixelAt(int x, int y) {
        return world[x][y];
    }


    private String getWorldAsString() {
        StringBuilder worldBuilder = new StringBuilder(StringUtils.EMPTY_STRING);
        if (width == 0 || height == 0) {
            return worldBuilder.toString();
        }
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                worldBuilder.append(getPixelAt(x, y));
            }
            worldBuilder.append(StringUtils.NEW_LINE);
        }
        return worldBuilder.toString();
    }

    private static Pixel[][] clone2DArrayOfInts(Pixel[][] source) {
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


    @Override
    public String toString() {
        return "World{" +
            "width=" + width +
            ", height=" + height +
            ", world=" + getWorldAsString() +
            '}';
    }
}
