package dms.pastor.tasks.paint;

import dms.pastor.tasks.paint.canvas.Canvas;
import dms.pastor.tasks.paint.canvas.Coordinates;
import dms.pastor.tasks.paint.command.InvalidCommandSyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author Dominik Symonowicz
 * Created 22/02/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class PaintIsRangeValidator {
    private static final Logger LOGGER = LoggerFactory.getLogger(PaintIsRangeValidator.class);

    private PaintIsRangeValidator() {
    }

    public static void validate(boolean condition, Canvas canvas, Coordinates startPoint, Coordinates endPoint) {
        if (condition) {
            LOGGER.warn("Start Point: " + startPoint.toString() + " End Point: " + endPoint.toString() + " Canvas: " + canvas.getCoordinatesAsString() + "Border: " + canvas.getBorder() + "\n" + canvas.getCanvasAsString());
            throw new InvalidCommandSyntaxException("paint on border is not allowed");
        }

    }

}
