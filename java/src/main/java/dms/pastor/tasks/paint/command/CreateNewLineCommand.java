package dms.pastor.tasks.paint.command;

import dms.pastor.tasks.paint.canvas.Canvas;
import dms.pastor.tasks.paint.canvas.Coordinates;
import dms.pastor.tasks.paint.canvas.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dms.pastor.tasks.paint.PaintIsRangeValidator.validate;
import static dms.pastor.tasks.paint.canvas.Coordinates.noCoordination;
import static dms.pastor.tasks.paint.command.CommandValidator.validateParamsNumber;
import static dms.pastor.tasks.paint.command.CommandValidator.validatePositiveLength;

/**
 * Author: Dominik Symonowicz
 * Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
 * LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
 * GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 * Created 15/07/2017
 */
public class CreateNewLineCommand implements Command {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateNewLineCommand.class);
    private static final String PIXEL_FILL = "x";

    private Coordinates startPoint = noCoordination();
    private Coordinates endPoint = noCoordination();

    @Override
    public String getSyntax() {
        return "L";
    }

    @Override
    public boolean isParamsRequired() {
        return true;
    }

    @Override
    public void setParamsIfValid(String[] params) {
        validateParamsNumber(5, params);
        validatePositiveLength(params[1], "start width");
        validatePositiveLength(params[2], "start height");
        validatePositiveLength(params[3], "end width");
        validatePositiveLength(params[4], "end height");
        setParam(params);
        validateAreParamsIsInOrder();
        if ((isHorizontal() && isVertical()) || (!isHorizontal() && !isVertical())) {
            throw new InvalidCommandSyntaxException("Unable to create line with this params");
        }
    }

    private void validateAreParamsIsInOrder() {
        final String reason = "Start point must be smaller than end point";
        if (isHorizontal() && startPoint.height() > endPoint.height()) {
            throw new InvalidCommandSyntaxException(reason);
        }

        if (isVertical() && startPoint.width() > endPoint.width()) {
            throw new InvalidCommandSyntaxException(reason);
        }
    }

    public void setParam(String[] params) {
        startPoint = new Coordinates(Integer.parseInt(params[1]), Integer.parseInt(params[2]));
        endPoint = new Coordinates(Integer.parseInt(params[3]), Integer.parseInt(params[4]));
    }

    @Override
    public void execute(Canvas canvas) {
        LOGGER.debug("Executing Create New Line Command with dimensions from ({},{}) to ({},{})", startPoint.width(), startPoint.height(), endPoint.width(), endPoint.height());
        if (canvas.isNoCanvas()) {
            LOGGER.warn("Canvas is not created yet.");
            return;
        }
        validateAreParamsIsRange(canvas);
        drawLineOn(canvas);
    }

    private void drawLineOn(Canvas canvas) {
        if (isHorizontal()) {
            drawHorizontalLine(canvas);
        }
        if (isVertical()) {
            drawVerticalLine(canvas);
        }
    }

    private void drawVerticalLine(Canvas canvas) {
        for (int i = startPoint.width(); i <= endPoint.width(); i++) {
            canvas.updatePixelAt(Point.of(i, startPoint.height(), PIXEL_FILL));
        }
    }

    private void drawHorizontalLine(Canvas canvas) {
        for (int i = startPoint.height(); i <= endPoint.height(); i++) {
            canvas.updatePixelAt(Point.of(startPoint.width(), i, PIXEL_FILL));
        }
    }

    private void validateAreParamsIsRange(Canvas canvas) {
        validate(startPoint.height() < canvas.getBorder() || endPoint.height() > canvas.getHeight() + canvas.getBorder(), canvas, startPoint, endPoint);
        validate(startPoint.width() < canvas.getBorder() || endPoint.width() > canvas.getWidth() + canvas.getBorder(), canvas, startPoint, endPoint);

    }


    private boolean isHorizontal() {
        return startPoint.width() == endPoint.width();
    }

    private boolean isVertical() {
        return startPoint.height() == endPoint.height();
    }

    public int getStartWidth() {
        return startPoint.width();
    }

    public int getStartHeight() {
        return startPoint.height();
    }

    public int getEndWidth() {
        return endPoint.width();
    }

    public int getEndHeight() {
        return endPoint.height();
    }
}
