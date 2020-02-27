package dms.pastor.prototypes.aberminegenerator.model;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PixelTest {

    @Test
    public void wallPixelAcceptanceTest() {
        // given
        Pixel pixel = Pixel.getWallAt(10, 10);

        // then
        assertThat(pixel.isPenetrable()).isFalse();
        assertThat(pixel.isWall()).isTrue();

    }
}