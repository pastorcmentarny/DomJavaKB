package dms.pastor.prototypes.aberminegenerator.model;


import dms.pastor.utils.ValidatorUtils;
import lombok.EqualsAndHashCode;

import java.util.Arrays;
import java.util.Objects;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.StringUtils.NEW_LINE;

@EqualsAndHashCode
public class World {
    private int width;
    private int height;
    private Pixel[][] world;

    //TODO improve it
    public World(int width, int height) {
        this.width = width;
        this.height = height;
        if(isCreated()){
            world = new Pixel[width+1][height+1];
        }else{
            world = new Pixel[0][0];
        }
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

    public void resetToNoWorld() {
        width = 0;
        height = 0;
        world = new Pixel[0][0];
    }

    public void updatePixel(Pixel pixel) {
        world[pixel.getCoordinates().getWidth()][pixel.getCoordinates().getHeight()] = pixel;
    }

    private Pixel getPixelAt(int width, int height) {
        return world[width][height];
    }


    public String getWorldAsString() {
        StringBuilder worldBuilder = new StringBuilder(EMPTY_STRING);
        if (width == 0 || height == 0) {
            return worldBuilder.toString();
        }
        for (int y = 0; y <= height; y++) {
            for (int x = 0; x <= width; x++) {
                if(Objects.nonNull(getPixelAt(x,y))){
                    worldBuilder.append(getPixelAt(x, y).getType().name().charAt(0));
                }

            }
            worldBuilder.append(NEW_LINE);
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
