package dms.pastor.tasks.paint.canvas;

import org.junit.jupiter.api.Test;

import static dms.pastor.tasks.paint.canvas.Point.withReplacedHeight;
import static dms.pastor.tasks.paint.canvas.Point.withReplacedWidth;
import static dms.pastor.utils.randoms.RandomDataGenerator.getRandomCharacterAsString;
import static dms.pastor.utils.randoms.RandomDataGenerator.randomPositiveInteger;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 12/12/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class PointTest {

    @Test
    public void ofShouldReturnPoint() {
        // given
        final int width = randomPositiveInteger(10);
        final int height = randomPositiveInteger(10);
        final String fill = getRandomCharacterAsString();
        final Coordinates coordinates = new Coordinates(width, height);
        Point expectedResult = new Point(coordinates, fill);
        // when
        final Point result = Point.of(width, height, fill);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void withReplacedWidthShouldReturnPoint() {
        // given
        final int width = randomPositiveInteger(10);
        final int newWidth = randomPositiveInteger(width, 10);
        final int height = randomPositiveInteger(10);
        final String fill = getRandomCharacterAsString();
        final Coordinates coordinates = new Coordinates(width, height);
        Point point = new Point(coordinates, fill);
        final Coordinates expectedCoordinates = new Coordinates(newWidth, height);
        Point expectedPoint = new Point(expectedCoordinates, fill);
        // when
        final Point result = withReplacedWidth(newWidth, point);

        // then
        assertThat(result).isEqualTo(expectedPoint);
    }

    @Test
    public void withReplacedHeightShouldReturnPoint() {
        // given
        final int width = randomPositiveInteger(10);
        final int height = randomPositiveInteger(10);
        final int newHeight = randomPositiveInteger(height, 10);
        final String fill = getRandomCharacterAsString();

        final Coordinates coordinates = new Coordinates(width, height);
        Point point = new Point(coordinates, fill);

        final Coordinates expectedCoordinates = new Coordinates(width, newHeight);
        Point expectedPoint = new Point(expectedCoordinates, fill);
        // when
        final Point result = withReplacedHeight(newHeight, point);

        // then
        assertThat(result).isEqualTo(expectedPoint);
    }

}
