package dms.pastor.prototypes.aberminegenerator.model;


import org.junit.jupiter.api.Test;

import static dms.pastor.prototypes.aberminegenerator.model.TerrainType.ROAD;
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
}