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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    World(int width, int height, Pixel[][] world) {
        this.width = width;
        this.height = height;
        this.world = PixelUtils.clone2DArrayOfInts(world);
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


    @Override
    public String toString() {
        return "World{" +
            "width=" + width +
            ", height=" + height +
            ", world=" + getWorldAsString() +
            '}';
    }


    public boolean canGoTo(Coordinates currentCoordinates, Coordinates newCoordinates) {
        final var newPlace = getPixelAt(newCoordinates.getWidth(), newCoordinates.getHeight());
        System.out.println(newPlace);
        return newPlace.isPenetrable();
    }
}
