package dms.pastor.prototypes.aberminegenerator.model;


import org.junit.jupiter.api.Test;

import static dms.pastor.prototypes.aberminegenerator.model.TerrainType.ROAD;
import static dms.pastor.prototypes.aberminegenerator.model.TerrainType.WALL;
import static org.assertj.core.api.Assertions.assertThat;

public class PixelTest {

    @Test
    public void buildPixelAcceptanceTest() {
        // when
        Pixel pixel = Pixel.buildPixel(false, ROAD, 2, 1);

        // then
        assertThat(pixel.isPenetrable()).isFalse();
        assertThat(pixel.isWall()).isFalse();
        assertThat(pixel.getType()).isEqualTo(ROAD);
    }

    @Test
    public void wallPixelAcceptanceTest() {
        // given
        Pixel pixel = Pixel.getWallAt(10, 10);

        // then
        assertThat(pixel.isPenetrable()).isFalse();
        assertThat(pixel.isWall()).isTrue();

    }

    @Test
    public void getPixelFromCharacterAcceptanceTest() {
        // given
        final int width = 1;
        final int height = 2;
        final var expectedPixel = Pixel.buildPixel(false, WALL, width, height);

        // when
        Pixel result = Pixel.getPixelFromCharacter('#', width, height);

        // then
        assertThat(result).isEqualTo(expectedPixel);
    }
}