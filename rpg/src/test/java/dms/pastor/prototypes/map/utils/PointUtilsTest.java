package dms.pastor.prototypes.map.utils;

import dms.pastor.prototypes.map.model.Coordinates;
import dms.pastor.prototypes.map.model.Point;
import dms.pastor.prototypes.map.model.TerrainType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointUtilsTest {

    @Test
    public void createWallAcceptanceTest() {
        // given
        final int height = 1;
        final int width = 1;
        final Point expectedResult = new Point(Coordinates.at(height, width), TerrainType.WALL);

        // when
        final Point result = PointUtils.createWall(height, width);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }
}