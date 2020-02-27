package dms.pastor.prototypes.aberminegenerator.model.generators;

import dms.pastor.prototypes.aberminegenerator.model.Pixel;
import dms.pastor.prototypes.aberminegenerator.model.World;

import java.util.stream.IntStream;

public class WorldGenerator {
    private WorldGenerator() {
    }

    public static World generateTestWorld() {
        int width = 6;
        int height = 7;

        World world = new World(width, height);
        final var pixels = new Pixel[width+1][height+1];

        for (int i = 0; i <= width; i++) {
            pixels[i][0] = Pixel.getWallAt(i, 0);
            pixels[0][i] = Pixel.getWallAt(0, i);
        }

        for (int i = 0; i < height; i++) {
            pixels[width][i] = Pixel.getWallAt(width,i);
            pixels[i][height] = Pixel.getWallAt(i,height);
        }

        IntStream.rangeClosed(1,3).forEach(c -> pixels[c][2] = Pixel.getStoneAt(c,2));
        pixels[5][2] = Pixel.getStoneAt(5,2);
        IntStream.rangeClosed(3,height-2).forEach(c -> pixels[c][4] = Pixel.getStoneAt(c,4));
        pixels[1][4] = Pixel.getStoneAt(1,4);

        for (int i = 0; i <= width; i++) {
            for (int j = 0; j <= height; j++) {
                if (pixels[i][j] == null) {
                    pixels[i][j] = Pixel.getGrassAt(i, j);
                }
            }
        }

        world.setWorld(pixels);
        return world;
    }
}
