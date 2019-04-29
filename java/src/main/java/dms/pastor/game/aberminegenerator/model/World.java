package dms.pastor.game.aberminegenerator.model;


import dms.pastor.tasks.paint.canvas.Image;

import java.util.Arrays;
import java.util.Objects;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.StringUtils.NEW_LINE;
import static dms.pastor.utils.ValidatorUtils.validateIfNotNull;

public class World {
    private int width;
    private int height;
    private Pixel[][] world;

    public World(int width, int height) {
        this.width = width;
        this.height = height;
        world = new Pixel[width][height];
    }

    World(int width, int height, Pixel[][] image) {
        this.width = width;
        this.height = height;
        this.world = clone2DArrayOfInts(image);
    }

    public static Image noImage() {
        return new Image(0, 0);
    }

    private int getWidth() {
        return width;
    }

    private int getHeight() {
        return height;
    }

    public Pixel[][] getImage() {
        return Arrays.copyOf(world, world.length);
    }

    public void setImage(Pixel[][] image) {
        this.world = image;
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

    public void resetToNoImage() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof World)) return false;
        World world1 = (World) o;
        return getWidth() == world1.getWidth() &&
            getHeight() == world1.getHeight() &&
            Arrays.equals(world, world1.world);
    }

    private String getImageAsString() {
        StringBuilder imageBuilder = new StringBuilder(EMPTY_STRING);
        if (width == 0 || height == 0) {
            return imageBuilder.toString();
        }
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                imageBuilder.append(getPixelAt(x, y));
            }
            imageBuilder.append(NEW_LINE);
        }
        return imageBuilder.toString();
    }

    private static Pixel[][] clone2DArrayOfInts(Pixel[][] source) {
        validateIfNotNull(source, "2D Array of integers cannot be null.");

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

    @Override //it is getImageAsString() instead getImage()
    public int hashCode() {
        return Objects.hash(getWidth(), getHeight(), getImageAsString());
    }

    @Override
    public String toString() {
        return "Image{" +
            "width=" + width +
            ", height=" + height +
            ", image=" + getImageAsString() +
            '}';
    }
}
