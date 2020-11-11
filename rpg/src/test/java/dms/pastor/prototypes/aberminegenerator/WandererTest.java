package dms.pastor.prototypes.aberminegenerator;

import dms.pastor.prototypes.aberminegenerator.model.Coordinates;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class WandererTest {

    @Test
    void getInfoShouldReturnDataAboutUnitOnUITest() {
        // given
        final Wanderer wanderer = new Wanderer("Gravity", new Coordinates(1, 2));
        // when
        final String info = wanderer.getInfo();

        // then
        assertThat(info).isEqualTo("Gravity @ [1,2]");
    }


    @Test
    void shouldGenerateWandererWithRandomNameAtSpecificCoordinates() {
        // when
        final int width = 1;
        final int height = 2;
        final Wanderer wanderer = Wanderer.withRandomNameAt(width, height);

        // then
        assertThat(wanderer.getName()).isNotBlank();
        assertThat(wanderer.getCoordinates().getWidth()).isEqualTo(width);
        assertThat(wanderer.getCoordinates().getHeight()).isEqualTo(height);
    }
}