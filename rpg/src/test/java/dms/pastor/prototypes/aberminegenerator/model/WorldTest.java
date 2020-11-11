package dms.pastor.prototypes.aberminegenerator.model;

import dms.pastor.prototypes.aberminegenerator.Wanderer;
import dms.pastor.prototypes.aberminegenerator.model.generators.TerrainGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WorldTest {

    final int DEFAULT_WORLD_WIDTH = 10;
    final int DEFAULT_WORLD_HEIGHT = 10;
    final World world = new World(DEFAULT_WORLD_WIDTH, DEFAULT_WORLD_HEIGHT, TerrainGenerator.generateGrass(DEFAULT_WORLD_WIDTH, DEFAULT_WORLD_HEIGHT));


    @Test
    void noWorldAcceptanceTest() {
        // when
        final var result = World.noWorld();

        // then
        assertThat(result.isCreated()).isEqualTo(false);
        assertThat(result.getWorld()).isEqualTo(new Pixel[0][0]);
    }

    @Test
    void getWorldAcceptanceTest() {
        // given
        final var worldAsPixels = TerrainGenerator.generateGrass(DEFAULT_WORLD_WIDTH, DEFAULT_WORLD_HEIGHT);
        // when
        final var result = this.world.getWorld();

        // then
        assertThat(result).isEqualTo(worldAsPixels);
    }

    @Test
    void setWorld() {
        // given
        World originalWorld = World.noWorld();
        final var worldAsPixels = TerrainGenerator.generateGrass(DEFAULT_WORLD_WIDTH, DEFAULT_WORLD_HEIGHT);
        // when
        originalWorld.setWorld(worldAsPixels);

        // then
        assertThat(originalWorld.getWorld()).isEqualTo(worldAsPixels);
    }

    @Test
    void isCreatedAcceptanceTest() {
        // when using default world then
        assertThat(world.isCreated()).isTrue();
    }

    @Test
    void resetToNoWorldAcceptanceTest() {
        // when
        world.resetToNoWorld();

        // then
        assertThat(world.isCreated()).isFalse();
    }

    @Test
    void setPixelAcceptanceTest() {
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
    public void shouldGoToTheEastIfMoveIsValid() {
        // given
        Wanderer unit = Wanderer.withRandomNameAtTestStartPoint();
        final var coordinates = unit.getCoordinates();
        final var newCoordinates = new Coordinates(coordinates.getWidth() + 1, coordinates.getHeight());
        // when
        final var result = world.canGoTo(newCoordinates);

        // then
        assertThat(result).isTrue();

    }

    @Test
    public void shouldReturnWallPixelWhenGetPixelCoordinatesForWall() {
        // given
        final int width = 0;
        final int height = 0;
        final Pixel expected = Pixel.getGrassAt(width, height);
        // when
        final Pixel pixel = world.getPixelAt(width, height);

        // then
        assertThat(pixel).isEqualTo(expected);
    }

    @Test
    public void shouldReturnUnknownPixelWhenGetPixelCoordinatesAreInvalid() {
        // given
        final int width = 999;
        final int height = 999;
        final Pixel expected = Pixel.getUnknownAt(width, height);
        // when
        final Pixel pixel = world.getPixelAt(width, height);

        // then
        assertThat(pixel).isEqualTo(expected);
    }

    @Test
    public void shouldReturnUnknownPixelWhenGetPixelAtWithWidthIsOutOfRange() {
        // given
        final int width = 999;
        final int height = 0;
        final Pixel expected = Pixel.getUnknownAt(width, height);
        // when
        final Pixel pixel = world.getPixelAt(width, height);

        // then
        assertThat(pixel).isEqualTo(expected);
    }

    @Test
    public void shouldReturnUnknownPixelWhenGetPixelAtWithHeightIsOutOfRange() {
        // given
        final int width = 0;
        final int height = 999;
        final Pixel expected = Pixel.getUnknownAt(width, height);
        // when
        final Pixel pixel = world.getPixelAt(width, height);

        // then
        assertThat(pixel).isEqualTo(expected);
    }

}