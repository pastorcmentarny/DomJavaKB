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
        String expectedResult = "WWWWWWW\n" +
            "WGGGGGW\n" +
            "WSSSGSW\n" +
            "WGGGGGW\n" +
            "WSGSSSW\n" +
            "WGGGGGW\n" +
            "WGGGTSW\n" +
            "WWWWWWW\n";
        // when
        final var world = WorldGenerator.generateTestWorld();

        // debug
        System.out.println(world.getWorldAsString());

        // then
        assertThat(world.getWorldAsString()).isEqualTo(expectedResult);
    }

    @Test
    public void shouldGenerateWorldFromFileAcceptanceTest(){
        // given

        // when
        final World result = WorldGenerator.generateFromFile();

        System.out.println("WORLD MAP:" + System.lineSeparator() + new Activity(Wanderer.withRandomNameAtTestStartPoint(),result).getWholeWorld());
        // then
        assertThat(result).isNotNull();
    }

}