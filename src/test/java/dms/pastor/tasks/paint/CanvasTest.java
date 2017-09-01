package dms.pastor.tasks.paint;

import dms.pastor.tasks.paint.canvas.Canvas;
import dms.pastor.tasks.paint.canvas.InvalidCanvasException;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static dms.pastor.tasks.paint.canvas.Canvas.createCanvasFor;
import static dms.pastor.tasks.paint.canvas.Canvas.noCanvas;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 16/07/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class CanvasTest {
    private static final int DEFAULT_WIDTH = 6;
    private static final int DEFAULT_HEIGHT = 4;
    private static final int DEFAULT_SQUARE_LENGTH = 3;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    private Canvas canvas = noCanvas();

    @Before
    public void setUp() throws Exception {
        canvas = noCanvas();
    }

    @After
    public void tearDown() throws Exception {
        canvas = noCanvas();
    }

    @Test
    public void createCanvasForShouldInvalidCanvasExceptionIfWidthIsZero() throws Exception {
        // expect
        exception.expect(InvalidCanvasException.class);

        // when
        createCanvasFor(0, DEFAULT_HEIGHT);
    }

    @Test
    public void createCanvasForShouldInvalidCanvasExceptionIfHeightIsZero() throws Exception {
        // expect
        exception.expect(InvalidCanvasException.class);

        // when
        createCanvasFor(DEFAULT_WIDTH, 0);
    }

    @Test
    public void shouldGenerateCanvas() throws Exception {
        // given
        final int width = DEFAULT_WIDTH;
        final int height = DEFAULT_HEIGHT;

        // when
        final Canvas canvas = createCanvasFor(width, height);

        // then
        assertThat(canvas.getWidth()).isEqualTo(width);
        assertThat(canvas.getHeight()).isEqualTo(height);
    }

    @Test
    public void drawShouldDrawCanvasRectangleWithHigherWidth() throws Exception {
        // given
        final int width = 6;
        final Canvas canvas = createCanvasFor(width, DEFAULT_HEIGHT);
        final String expectedImage =
                "--------\n" +
                        "|      |\n" +
                        "|      |\n" +
                        "|      |\n" +
                        "|      |\n" +
                        "--------\n";

        // when
        final String image = canvas.getCanvasAsString();

        // then
        assertThat(image).isEqualTo(expectedImage);
    }

    @Test
    public void drawShouldDrawCanvasRectangleWithHigherHeight() throws Exception {
        // given
        final int width = 2;
        final int height = 3;
        final Canvas canvas = createCanvasFor(width, height);
        final String expectedImage =
                "----\n" +
                        "|  |\n" +
                        "|  |\n" +
                        "|  |\n" +
                        "----\n";

        // when
        final String image = canvas.getCanvasAsString();

        // then
        assertThat(image).isEqualTo(expectedImage);
    }

    @Test
    public void drawShouldDrawCanvasSquareWithLengthOfOne() throws Exception {
        // given
        final int width = 1;
        final int height = 1;
        final Canvas canvas = createCanvasFor(width, height);
        final String expectedImage =
                "---\n" +
                        "| |\n" +
                        "---\n";
        // when
        final String image = canvas.getCanvasAsString();

        // then
        assertThat(image).isEqualTo(expectedImage);
    }

    @Test
    public void drawShouldDrawCanvasSquareWithLengthOfFive() throws Exception {
        // given
        final int width = 5;
        final int height = 5;
        final Canvas canvas = createCanvasFor(width, height);
        final String expectedImage =
                "-------\n" +
                        "|     |\n" +
                        "|     |\n" +
                        "|     |\n" +
                        "|     |\n" +
                        "|     |\n" +
                        "-------\n";
        // when
        final String image = canvas.getCanvasAsString();

        // then
        assertThat(image).isEqualTo(expectedImage);
    }

    @Test
    public void noCanvasShouldGenerateCanvasWithoutLine() throws Exception {
        // when
        final Canvas canvas = noCanvas();

        // then
        assertThat(canvas.getWidth()).isZero();
        assertThat(canvas.getHeight()).isZero();
    }

    @Test
    public void drawShouldReturnEmptyStringForNoCanvas() throws Exception {
        // given
        Canvas canvas = noCanvas();

        // when
        final String image = canvas.getCanvasAsString();

        // then
        assertThat(image).isEmpty();
    }

    @Test
    public void recreateCanvasShouldSetNewValues() {
        // given
        final int width = 8;
        final int height = 6;

        // when
        canvas.recreateCanvas(width, height);

        // then
        assertThat(canvas.isNoCanvas()).isFalse();
        assertThat(canvas.getWidth()).isEqualTo(width);
        assertThat(canvas.getHeight()).isEqualTo(height);
    }

    @Test
    public void recreateCanvasShouldInvalidCanvasExceptionIfWidthIsZero() throws Exception {
        // expect
        exception.expect(InvalidCanvasException.class);

        // when
        canvas.recreateCanvas(0, DEFAULT_HEIGHT);
    }

    @Test
    public void recreateCanvasShouldInvalidCanvasExceptionIfHeightIsZero() throws Exception {
        // expect
        exception.expect(InvalidCanvasException.class);

        // when
        canvas.recreateCanvas(DEFAULT_WIDTH, 0);
    }

    @Test
    public void getCoordinatesAsStringShouldReturnEmptyStringIfCanvasIsNotSet() throws Exception {
        // given
        Canvas canvas = noCanvas();

        // when
        final String coordinatesAsString = canvas.getCoordinatesAsString();

        // then
        assertThat(coordinatesAsString).isEmpty();
    }

    @Test
    public void getCoordinatesAsStringShouldReturnCoordinatesForCanvas() throws Exception {
        // given
        final Canvas canvas = createCanvasFor(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        final String expectedResult = "Width: 6 Height: 4";

        // when
        final String coordinatesAsString = canvas.getCoordinatesAsString();

        // then
        assertThat(coordinatesAsString).isEqualTo(expectedResult);
    }

    @Test
    public void isCanvasReturnsTrueForCreatedCanvas() throws Exception {
        // given
        final Canvas canvas = createCanvasFor(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // when
        final boolean result = canvas.isCanvas();

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void isCanvasReturnsFalseIfCanvasWasNotCreated() throws Exception {
        // given
        final Canvas canvas = noCanvas();

        // when
        final boolean result = canvas.isCanvas();

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void isNoCanvasReturnsFalseForCreatedCanvas() throws Exception {
        // given
        final Canvas canvas = createCanvasFor(4, DEFAULT_HEIGHT);

        // when
        final boolean result = canvas.isNoCanvas();

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void isNoCanvasReturnsTrueIfCanvasWasNotCreated() throws Exception {
        // given
        final Canvas canvas = noCanvas();

        // when
        final boolean result = canvas.isNoCanvas();

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void undoShouldReturnPreviousStateOfImage() throws Exception {
        // given
        canvas = createCanvasFor(8, 6);
        final String expectedImage = canvas.getCanvasAsString();
        canvas.saveState();
        canvas.updatePixelAt(1, 1, "x");

        // when
        canvas.undo();

        // then
        assertThat(canvas.getCanvasAsString()).isEqualTo(expectedImage);
    }

    @Test
    public void redoShouldReturnNextStateOfImage() throws Exception {
        // given
        canvas = createCanvasFor(8, 6);
        canvas.saveState();
        canvas.updatePixelAt(1, 1, "x");
        canvas.saveState();
        final String expectedImage = canvas.getCanvasAsString();
        canvas.undo();

        // when
        canvas.redo();

        // then
        assertThat(canvas.getCanvasAsString()).isEqualTo(expectedImage);
    }

    @Test
    public void getImageAsStringShouldReturnImageWithDominikOnCanvas() {
        // given
        canvas = createCanvasFor(DEFAULT_SQUARE_LENGTH, DEFAULT_SQUARE_LENGTH);
        canvas.updatePixelAt(1, 1, "D");
        canvas.updatePixelAt(2, 1, "O");
        canvas.updatePixelAt(3, 1, "M");
        canvas.updatePixelAt(3, 2, "I");
        canvas.updatePixelAt(3, 3, "N");
        canvas.updatePixelAt(2, 3, "I");
        canvas.updatePixelAt(1, 3, "K");

        // when
        final String result = canvas.getCanvasAsString();
        // then
        assertThat(result).isEqualTo(
                "-----\n" +
                        "|DOM|\n" +
                        "|  I|\n" +
                        "|KIN|\n" +
                        "-----\n"
        );
    }

}
