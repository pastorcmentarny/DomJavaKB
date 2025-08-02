package dms.pastor.tasks.paint;

import dms.pastor.tasks.paint.canvas.Canvas;
import dms.pastor.tasks.paint.canvas.Coordinates;
import dms.pastor.tasks.paint.command.InvalidCommandSyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author Dominik Symonowicz
 * Created 22/02/2018
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public final class PaintIsRangeValidator {
    private static final Logger LOGGER = LoggerFactory.getLogger(PaintIsRangeValidator.class);

    private PaintIsRangeValidator() {
    }

    public static void validate(boolean condition, Canvas canvas, Coordinates startPoint, Coordinates endPoint) {
        if (condition) {
            LOGGER.warn("Start Point: {} End Point: {} Canvas: {}Border: {}\n{}", startPoint.toString(), endPoint.toString(), canvas.getCoordinatesAsString(), canvas.getBorder(), canvas.getCanvasAsString());
            throw new InvalidCommandSyntaxException("paint on border is not allowed");
        }

    }

}
