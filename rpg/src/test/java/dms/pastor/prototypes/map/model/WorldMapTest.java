package dms.pastor.prototypes.map.model;

import dms.pastor.prototypes.map.utils.PointUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static dms.pastor.utils.randoms.RandomDataGenerator.randomPositiveInteger;
import static org.assertj.core.api.Assertions.assertThat;

class WorldMapTest {

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenCreatingNewWorldMapWithNegativeHeight() {
        // given
        final int negativeHeight = -1;

        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            WorldMap.newWorldMap(negativeHeight, randomPositiveInteger());
        });
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenCreatingNewWorldMapWithNegativeWidth() {
        // given
        final int negativeWidth = -1;

        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            WorldMap.newWorldMap(randomPositiveInteger(), negativeWidth);
        });
    }

    @Test
    public void addValidPointToMapAcceptanceTest() {
        // given
        WorldMap worldMap = WorldMap.newWorldMap(10, 10);
        final int height = 4;
        final int width = 3;
        final Point expectedResult = PointUtils.createWall(height, width);
        worldMap.setPointTo(PointUtils.createWall(height, width));

        // when
        final Optional<Point> result = worldMap.getPointAt(height, width);

        // then
        assertThat(result.isPresent()).isTrue();
        assertThat(result.orElse(Point.noPoint())).isEqualTo(expectedResult);
    }

    @Test
    public void shouldThrowExceptionIfHeightPointIsOutsideWorldMapAcceptanceTest() {
        // given
        WorldMap worldMap = WorldMap.newWorldMap(10, 10);
        final int height = 11;
        final int width = 9;

        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            worldMap.setPointTo(PointUtils.createWall(height, width));
            ;
        });
    }

    @Test
    public void shouldThrowExceptionIfWidthPointIsOutsideWorldMapAcceptanceTest() {
        // given
        WorldMap worldMap = WorldMap.newWorldMap(10, 10);
        final int height = 9;
        final int width = 11;

        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            worldMap.setPointTo(PointUtils.createWall(height, width));
            ;
        });
    }
}