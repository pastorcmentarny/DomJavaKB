package dms.pastor.tasks.paint.canvas;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 18/07/2017
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class CoordinatesTest {

    private static final int NO_VALUE = -1;

    @Test
    public void shouldCreateNoCoordinationInstance() {
        // when
        final Coordinates coordinates = Coordinates.noCoordination();

        // then
        assertThat(coordinates.getWidth()).isEqualTo(NO_VALUE);
        assertThat(coordinates.getHeight()).isEqualTo(NO_VALUE);
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
