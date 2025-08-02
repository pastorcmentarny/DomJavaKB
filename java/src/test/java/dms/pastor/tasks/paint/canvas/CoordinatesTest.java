package dms.pastor.tasks.paint.canvas;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 18/07/2017
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public class CoordinatesTest {

    private static final int NO_VALUE = -1;

    @Test
    public void shouldCreateNoCoordinationInstance() {
        // when
        final Coordinates coordinates = Coordinates.noCoordination();

        // then
        assertThat(coordinates.width()).isEqualTo(NO_VALUE);
        assertThat(coordinates.height()).isEqualTo(NO_VALUE);
    }

    @Test
    public void isCoordinationSetShouldReturnFalseIfHeightAndWidthAreSetToNoValue() {
        // given
        final Coordinates coordinates = Coordinates.noCoordination();

        // when
        final boolean result = coordinates.isCoordinatesSet();

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void isCoordinatesSetShouldReturnTrueForCoordinates() {
        // given
        final Coordinates coordinates = new Coordinates(8, 6);

        // when
        final boolean result = coordinates.isCoordinatesSet();

        // then
        assertThat(result).isTrue();
    }

}
