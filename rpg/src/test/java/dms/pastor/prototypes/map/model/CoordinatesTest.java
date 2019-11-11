package dms.pastor.prototypes.map.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class CoordinatesTest {

    @Test
    void noCoordinationShouldReturnCoordinatesWithSpecificValue() {
        // given
        final int noCoordinateValue = Integer.MIN_VALUE + 1;

        // when
        final var result = Coordinates.noCoordination();

        // then
        assertThat(result.getHeight()).isEqualTo(noCoordinateValue);
        assertThat(result.getWidth()).isEqualTo(noCoordinateValue);
    }

    @Test
    public void atWithWeight1AndWidth1ShouldCreateCoordinatesAtWeight1AndWidth1() {
        // given
        final int height = 1;
        final int width = 1;

        // when
        final var result = Coordinates.at(height, width);

        // then
        assertThat(result.isCoordinatesSet()).isTrue();
        assertThat(result.getHeight()).isEqualTo(1);
        assertThat(result.getWidth()).isEqualTo(1);
    }
}