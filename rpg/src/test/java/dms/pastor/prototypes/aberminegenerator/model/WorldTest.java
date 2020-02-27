package dms.pastor.prototypes.aberminegenerator.model;

import dms.pastor.prototypes.aberminegenerator.model.generators.TerrainGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WorldTest {

    World world;

    {
        final var DEFAULT_WORLD_WIDTH = 10;
        final var DEFAULT_WORLD_HEIGHT = 10;
        world = new World(DEFAULT_WORLD_WIDTH, DEFAULT_WORLD_HEIGHT, TerrainGenerator.generateGrass(DEFAULT_WORLD_WIDTH,DEFAULT_WORLD_HEIGHT));
    }

    @Test
    void noWorldAcceptanceTest() {
        // when
        final var result = World.noWorld();

        // then
        assertThat(result.isCreated()).isEqualTo(false);
        assertThat(result.getWorld()).isEqualTo(new Pixel[0][0]);
    }

    @Test
    void getWorld() {
    }

    @Test
    void setWorld() {
    }

    @Test
    void isCreated() {
        // when using default world then
        assertThat(world.isCreated()).isTrue();
    }

    @Test
    void getPreviousPixelFor() {
    }

    @Test
    void resetToNoWorldAcceptanceTest() {
        // when
        world.resetToNoWorld();

        // then
        assertThat(world.isCreated()).isFalse();
    }

    @Test
    void setPixel() {
        // given
        final var width = 1;
        final var height = 1;
        final var wallPixel = Pixel.getWallAt(width, height);

        // when
        world.updatePixel(wallPixel);

        // then
        final var pixel = this.world.getWorld()[width][height];
        assertThat(pixel).isEqualTo(wallPixel);
    }

    @Test
    void testSetPixel() {
    }
}