package dms.pastor.prototypes.aberminegenerator.model.generators;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static dms.pastor.prototypes.aberminegenerator.model.TerrainType.GRASS;
import static dms.pastor.prototypes.aberminegenerator.model.generators.TerrainGenerator.generateGrass;
import static dms.pastor.utils.randoms.RandomDataGenerator.randomNegativeInteger;
import static dms.pastor.utils.randoms.RandomDataGenerator.randomPositiveInteger;
import static org.assertj.core.api.Assertions.assertThat;

class TerrainGeneratorTest {

    @Test
    public void shouldThrowExceptionIfHeightIsNegative() {
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            generateGrass(randomPositiveInteger(), randomNegativeInteger());
        });

    }

    @Test
    public void shouldThrowExceptionIfWidthIsNegative() {
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            generateGrass(randomNegativeInteger(), randomPositiveInteger());
        });

    }

    @Test
    public void shouldGeneratePixels() {
        // given
        // when
        final var pixels = generateGrass(2, 2);

        // then
        assertThat(pixels[0][0].getType()).isEqualTo(GRASS);
        assertThat(pixels[1][1].getType()).isEqualTo(GRASS);
        assertThat(pixels[2][2].getType()).isEqualTo(GRASS);
    }
}