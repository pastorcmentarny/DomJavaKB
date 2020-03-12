package dms.pastor.prototypes.aberminegenerator.model;

import dms.pastor.prototypes.aberminegenerator.model.generators.WorldGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PixelUtilsTest {

    @Test
    void toArrayOfTilesAcceptanceTest() {
        // given
        final Pixel[][] worldAs2DArray = WorldGenerator.generateTestWorld().getWorld();
        final String expectedResult = "########,,,,,##OOO,O##,,,,,##O,OOO##,,,,,##,,,T░########";

        // when
        final String result = String.join("", PixelUtils.toArrayOfTiles(worldAs2DArray));

        // then
        assertThat(result).isEqualTo(expectedResult);
    }
}