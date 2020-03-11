package dms.pastor.prototypes.aberminegenerator.model;

import org.junit.jupiter.api.Test;

import static dms.pastor.prototypes.aberminegenerator.model.TerrainType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TerrainTypeTest {

    @Test
    public void getTerrainFromCharShouldReturnUnknownTypeIfValueCannotBeFound() {
        // given
        final char invalidCharacter = '±';

        // when
        final TerrainType result = TerrainType.getTerrainFromChar(invalidCharacter);

        // then
        assertEquals(UNKNOWN, result);
    }

    @Test
    public void getTerrainFromCharShouldReturnSandTypeForWallCharacter() {
        // given
        final char invalidCharacter = '#';

        // when
        final TerrainType result = TerrainType.getTerrainFromChar(invalidCharacter);

        // then
        assertEquals(WALL, result);
    }

    @Test
    public void getTerrainFromCharShouldReturnSandTypeForSandSpecialCharacter() {
        // given
        final char invalidCharacter = '░';

        // when
        final TerrainType result = TerrainType.getTerrainFromChar(invalidCharacter);

        // then
        assertEquals(SAND, result);
    }


}