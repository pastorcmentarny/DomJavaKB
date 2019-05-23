package dms.pastor.game.aberminegenerator.model;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PixelTest {

    @Test
    public void wallPixelAcceptanceTest() {
        // given
        Pixel pixel = Pixel.getWallPixel(10, 10);

        // then
        assertThat(pixel.isPenaratable()).isFalse();
        assertThat(pixel.isWall()).isTrue();

    }
}