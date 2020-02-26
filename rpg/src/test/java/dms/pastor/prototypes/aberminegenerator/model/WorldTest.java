package dms.pastor.prototypes.aberminegenerator.model;

import dms.pastor.prototypes.aberminegenerator.model.generators.TerrainGenerator;
import org.junit.jupiter.api.Test;

class WorldTest {

    World world;

    {
        final var DEFAULT_WORLD_WIDTH = 10;
        final var DEFAULT_WORLD_HEIGHT = 10;
        world = new World(DEFAULT_WORLD_WIDTH, DEFAULT_WORLD_HEIGHT, TerrainGenerator.generateGrass(DEFAULT_WORLD_WIDTH,DEFAULT_WORLD_HEIGHT));
    }

    @Test
    void noWorld() {
    }

    @Test
    void getWorld() {
    }

    @Test
    void setWorld() {
    }

    @Test
    void isCreated() {
    }

    @Test
    void getPreviousPixelFor() {
    }

    @Test
    void resetToNoWorld() {
    }

    @Test
    void setPixel() {
    }

    @Test
    void testSetPixel() {
    }
}