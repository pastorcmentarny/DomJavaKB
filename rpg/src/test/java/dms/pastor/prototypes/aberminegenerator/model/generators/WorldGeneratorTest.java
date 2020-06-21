package dms.pastor.prototypes.aberminegenerator.model.generators;


import dms.pastor.prototypes.aberminegenerator.Activity;
import dms.pastor.prototypes.aberminegenerator.Wanderer;
import dms.pastor.prototypes.aberminegenerator.model.World;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WorldGeneratorTest {

    @Test
    public void shouldGenerateWorldAcceptanceTest() {
        // given
        String expectedResult =
                "WWWWWUU" + System.lineSeparator() +
                        "WGGGGUU" + System.lineSeparator() +
                        "WSSSGUU" + System.lineSeparator() +
                        "WGGGGUU" + System.lineSeparator() +
                        "WSGSSUU" + System.lineSeparator() +
                        "WGGGGUU" + System.lineSeparator() +
                        "UUUUUUU" + System.lineSeparator() +
                        "UUUUUUU" + System.lineSeparator();
        // when
        final var world = WorldGenerator.generateTestWorld();

        // debug
        System.out.println(world.getWorldAsString());

        // then
        assertThat(world.getWorldAsString()).isEqualTo(expectedResult);
    }

    @Test
    public void shouldGenerateWorldFromFileAcceptanceTest() {
        // given

        // when
        final World result = WorldGenerator.generateFromFile();

        System.out.println("WORLD MAP:" + System.lineSeparator() + new Activity(Wanderer.withRandomNameAtTestStartPoint(), result).getWholeWorld());
        // then
        assertThat(result).isNotNull();
    }

}