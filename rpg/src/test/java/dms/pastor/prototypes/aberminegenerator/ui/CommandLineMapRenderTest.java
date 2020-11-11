package dms.pastor.prototypes.aberminegenerator.ui;

import dms.pastor.prototypes.aberminegenerator.model.Coordinates;
import dms.pastor.prototypes.aberminegenerator.model.Pixel;
import dms.pastor.prototypes.aberminegenerator.model.generators.WorldGenerator;
import dms.pastor.prototypes.aberminegenerator.ui.cli.CommandLineMapRender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static dms.pastor.utils.randoms.RandomDataGenerator.randomNegativeInteger;

class CommandLineMapRenderTest {

    @Test
    void renderWithVisionRangeOfShouldThrowExceptionIfRangeIsNegativeAcceptanceTest() {
        // given
        final Pixel[][] map = WorldGenerator.generateTestWorld().getWorld();
        final Coordinates unitCoordinates = new Coordinates(1, 1);

        // expect
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CommandLineMapRender.renderAreaWithVisionRangeOf(map, unitCoordinates, randomNegativeInteger());
        });

    }

    @Test
    void renderWithVisionRangeOfAcceptanceTest() {

        // given
        final Pixel[][] map = WorldGenerator.generateTestWorld().getWorld();
        final Coordinates unitCoordinates = new Coordinates(1, 1);
        // when
        final String result = CommandLineMapRender.renderAreaWithVisionRangeOf(map, unitCoordinates, 3);

        // debug
        System.out.println(result);
    }
}