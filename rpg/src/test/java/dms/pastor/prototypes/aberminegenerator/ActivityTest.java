package dms.pastor.prototypes.aberminegenerator;

import dms.pastor.prototypes.aberminegenerator.model.Coordinates;
import dms.pastor.prototypes.aberminegenerator.model.World;
import dms.pastor.prototypes.aberminegenerator.model.generators.WorldGenerator;
import org.junit.jupiter.api.Test;

import static dms.pastor.prototypes.aberminegenerator.Wanderer.withRandomNameAtTestStartPoint;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ActivityTest {

    @Test
    void walkSouthAcceptanceTest() {

        // given
        final var world = WorldGenerator.generateTestWorld();
        final var wanderer = withRandomNameAtTestStartPoint();
        wanderer.setCurrentCoordinateTo(new Coordinates(4,1));
        final var activity = new Activity(wanderer, world);

        // when
        activity.walkSouth();

        // then
        final var result = wanderer.getCoordinates();
        assertThat(result.getWidth()).isEqualTo(4);
        assertThat(result.getHeight()).isEqualTo(2);
    }

    @Test
    void walkEastAcceptanceTest() {

        // given
        final var world = WorldGenerator.generateTestWorld();
        final var wanderer = withRandomNameAtTestStartPoint();
        final var activity = new Activity(wanderer, world);

        // when
        activity.walkEast();

        // then
        final var result = wanderer.getCoordinates();
        assertThat(result.getWidth()).isEqualTo(2);
        assertThat(result.getHeight()).isEqualTo(1);
    }

    @Test
    void walkNorthAcceptanceTest() {

        // given
        final var world = WorldGenerator.generateTestWorld();
        final var wanderer = withRandomNameAtTestStartPoint();
        wanderer.setCurrentCoordinateTo(new Coordinates(4,2));
        final var activity = new Activity(wanderer, world);

        // when
        activity.walkNorth();

        // then
        final var result = wanderer.getCoordinates();
        assertThat(result.getWidth()).isEqualTo(4);
        assertThat(result.getHeight()).isEqualTo(1);
    }

    @Test
    void walkWestAcceptanceTest() {

        // given
        final var world = WorldGenerator.generateTestWorld();
        final var wanderer = withRandomNameAtTestStartPoint();
        wanderer.setCurrentCoordinateTo(new Coordinates(2,1));
        final var activity = new Activity(wanderer, world);

        // when
        activity.walkWest();

        // then
        final var result = wanderer.getCoordinates();
        assertThat(result.getWidth()).isEqualTo(1);
        assertThat(result.getHeight()).isEqualTo(1);
    }
}