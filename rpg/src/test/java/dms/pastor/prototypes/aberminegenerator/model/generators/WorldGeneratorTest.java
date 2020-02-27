package dms.pastor.prototypes.aberminegenerator.model.generators;


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
            "WGGGGGW\n" +
            "WWWWWWW\n";
        // when
        final var world = WorldGenerator.generateTestWorld();

        // debug
        System.out.println(world.getWorldAsString());

        // then
        assertThat(world.getWorldAsString()).isEqualTo(expectedResult);
    }
}