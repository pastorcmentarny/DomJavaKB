package dms.pastor.game.aberminegenerator.model;


import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PixelTest {


    @Ignore
    @Test //TODO improve it
    public void wallPixelAcceptanceTest() {
        // given
        Pixel pixel = Pixel.getWallPixel(10, 10);

        // then
        assertThat(pixel.isPenaratable()).isFalse();
        assertThat(pixel.isWall()).isTrue();

    }
}