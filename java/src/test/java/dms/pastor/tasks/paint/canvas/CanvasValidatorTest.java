package dms.pastor.tasks.paint.canvas;

import org.junit.jupiter.api.Test;

import static dms.pastor.tasks.paint.canvas.Canvas.createCanvasFor;
import static dms.pastor.tasks.paint.canvas.CanvasValidator.validateIfCanvasIsSet;
import static dms.pastor.tasks.paint.canvas.CanvasValidator.validateIfImageSizeAreTheSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Author Dominik Symonowicz
 * Created 20/07/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class CanvasValidatorTest {
    private static final int CANVAS_WIDTH = 8;
    private static final int CANVAS_HEIGHT = 6;

    @Test
    public void validateIfCanvasIsSetShouldThrowExceptionIfCanvasIsNotSet() {
        // when
        assertThrows(InvalidCanvasException.class, () -> validateIfCanvasIsSet(Canvas.noCanvas()));

    }

    @Test
    public void validateIfCanvasIsSetShouldValidateIfCanvasIsSet() {
        // given
        final Canvas canvas = Canvas.createCanvasFor(CANVAS_WIDTH, CANVAS_HEIGHT);

        // when
        validateIfCanvasIsSet(canvas);

        // then no exception should be thrown
    }

    @Test
    public void validateIfImageSizeAreTheSameShouldThrowExceptionWhenWidthAreDifferent() {
        // given
        final Canvas canvas = Canvas.createCanvasFor(CANVAS_WIDTH, CANVAS_HEIGHT);

        // when
        assertThrows(InvalidCanvasException.class, () -> validateIfImageSizeAreTheSame(canvas, new String[5][CANVAS_HEIGHT]));

    }

    @Test
    public void validateIfImageSizeAreTheSameShouldThrowExceptionWhenHeightAreDifferent() {
        // given
        final Canvas canvas = Canvas.createCanvasFor(CANVAS_WIDTH, CANVAS_HEIGHT);

        // when
        assertThrows(InvalidCanvasException.class, () -> validateIfImageSizeAreTheSame(canvas, new String[CANVAS_WIDTH][5]));
    }

    @Test
    public void validateIfImageSizeAreTheSameShouldValidateIfImageHasSameDimensionsAsCanvas() {
        // given
        final Canvas canvas = Canvas.createCanvasFor(CANVAS_WIDTH, CANVAS_HEIGHT);
        final int border = 2;

        // when
        validateIfImageSizeAreTheSame(canvas, new String[CANVAS_WIDTH + border][CANVAS_HEIGHT + border]);

        // then no exception should be thrown
    }

    @Test
    public void createCanvasForShouldInvalidCanvasExceptionIfWidthIsZero() {
        // when
        assertThrows(InvalidCanvasException.class, () -> createCanvasFor(0, CANVAS_HEIGHT));

    }

    @Test
    public void createCanvasForShouldInvalidCanvasExceptionIfHeightIsZero() {
        // when
        assertThrows(InvalidCanvasException.class, () -> createCanvasFor(CANVAS_WIDTH, 0));
    }

}