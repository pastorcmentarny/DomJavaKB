package dms.pastor.tasks.paint.canvas;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static dms.pastor.tasks.paint.canvas.Canvas.createCanvasFor;
import static dms.pastor.tasks.paint.canvas.CanvasValidator.validateIfCanvasIsSet;
import static dms.pastor.tasks.paint.canvas.CanvasValidator.validateIfImageSizeAreTheSame;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 20/07/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class CanvasValidatorTest {
    private static final int CANVAS_WIDTH = 8;
    private static final int CANVAS_HEIGHT = 6;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void validateIfCanvasIsSetShouldThrowExceptionIfCanvasIsNotSet() throws Exception {
        // expect
        exception.expect(InvalidCanvasException.class);

        // when
        validateIfCanvasIsSet(Canvas.noCanvas());
    }

    @Test
    public void validateIfCanvasIsSetShouldValidateIfCanvasIsSet() throws Exception {
        // given
        final Canvas canvas = Canvas.createCanvasFor(CANVAS_WIDTH, CANVAS_HEIGHT);

        // when
        validateIfCanvasIsSet(canvas);

        // then no exception should be thrown
    }

    @Test
    public void validateIfImageSizeAreTheSameShouldThrowExceptionWhenWidthAreDifferent() {
        // expect
        exception.expect(InvalidCanvasException.class);

        // given
        final Canvas canvas = Canvas.createCanvasFor(CANVAS_WIDTH, CANVAS_HEIGHT);

        // when
        validateIfImageSizeAreTheSame(canvas, new String[5][CANVAS_HEIGHT]);
    }

    @Test
    public void validateIfImageSizeAreTheSameShouldThrowExceptionWhenHeightAreDifferent() {
        // expect
        exception.expect(InvalidCanvasException.class);

        // given
        final Canvas canvas = Canvas.createCanvasFor(CANVAS_WIDTH, CANVAS_HEIGHT);

        // when
        validateIfImageSizeAreTheSame(canvas, new String[CANVAS_WIDTH][5]);
    }

    @Test
    public void validateIfImageSizeAreTheSameShouldValidateIfImageHasSameDimensionsAsCanvas() throws Exception {
        // given
        final Canvas canvas = Canvas.createCanvasFor(CANVAS_WIDTH, CANVAS_HEIGHT);
        final int border = 2;

        // when
        validateIfImageSizeAreTheSame(canvas, new String[CANVAS_WIDTH + border][CANVAS_HEIGHT + border]);

        // then no exception should be thrown
    }

    @Test
    public void createCanvasForShouldInvalidCanvasExceptionIfWidthIsZero() throws Exception {
        // expect
        exception.expect(InvalidCanvasException.class);

        // when
        createCanvasFor(0, CANVAS_HEIGHT);
    }

    @Test
    public void createCanvasForShouldInvalidCanvasExceptionIfHeightIsZero() throws Exception {
        // expect
        exception.expect(InvalidCanvasException.class);

        // when
        createCanvasFor(CANVAS_WIDTH, 0);
    }

    @Test
    public void shouldGenerateCanvas() throws Exception {
        // given
        final int width = CANVAS_WIDTH;
        final int height = CANVAS_HEIGHT;

        // when
        final Canvas canvas = createCanvasFor(width, height);

        // then
        assertThat(canvas.getWidth()).isEqualTo(width);
        assertThat(canvas.getHeight()).isEqualTo(height);
    }

}