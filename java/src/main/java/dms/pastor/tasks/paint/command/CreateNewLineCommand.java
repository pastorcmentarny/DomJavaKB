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
 * Author Dominik Symonowicz
 * Created 15/07/2017
 * WWW:	https://dominiksymonowicz.com/
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class CreateNewLineCommand implements Command {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateCanvasCommand.class);
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
        if (isHorizontal() && startPoint.getHeight() > endPoint.getHeight()) {
            throw new InvalidCommandSyntaxException(reason);
        }

        if (isVertical() && startPoint.getWidth() > endPoint.getWidth()) {
            throw new InvalidCommandSyntaxException(reason);
        }
    }

    public void setParam(String[] params) {
        startPoint = new Coordinates(Integer.parseInt(params[1]), Integer.parseInt(params[2]));
        endPoint = new Coordinates(Integer.parseInt(params[3]), Integer.parseInt(params[4]));
    }

    @Override
    public void execute(Canvas canvas) {
        LOGGER.debug("Executing Create New Line Command with dimensions from ({},{}) to ({},{})", startPoint.getWidth(), startPoint.getHeight(), endPoint.getWidth(), endPoint.getHeight());
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
        for (int i = startPoint.getWidth(); i <= endPoint.getWidth(); i++) {
            canvas.updatePixelAt(Point.of(i, startPoint.getHeight(), PIXEL_FILL));
        }
    }

    private void drawHorizontalLine(Canvas canvas) {
        for (int i = startPoint.getHeight(); i <= endPoint.getHeight(); i++) {
            canvas.updatePixelAt(Point.of(startPoint.getWidth(), i, PIXEL_FILL));
        }
    }

    private void validateAreParamsIsRange(Canvas canvas) {
        validate(startPoint.getHeight() < canvas.getBorder() || endPoint.getHeight() > canvas.getHeight() + canvas.getBorder(), canvas, startPoint, endPoint);
        validate(startPoint.getWidth() < canvas.getBorder() || endPoint.getWidth() > canvas.getWidth() + canvas.getBorder(), canvas, startPoint, endPoint);

    }


    private boolean isHorizontal() {
        return startPoint.getWidth() == endPoint.getWidth();
    }

    private boolean isVertical() {
        return startPoint.getHeight() == endPoint.getHeight();
    }

    public int getStartWidth() {
        return startPoint.getWidth();
    }

    public int getStartHeight() {
        return startPoint.getHeight();
    }

    public int getEndWidth() {
        return endPoint.getWidth();
    }

    public int getEndHeight() {
        return endPoint.getHeight();
    }
}
