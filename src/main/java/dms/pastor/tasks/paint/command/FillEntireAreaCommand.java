package dms.pastor.tasks.paint.command;

import dms.pastor.tasks.paint.canvas.Canvas;
import dms.pastor.tasks.paint.canvas.Coordinates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dms.pastor.tasks.paint.canvas.Coordinates.noCoordination;
import static dms.pastor.tasks.paint.command.CommandValidator.*;

/**
 * Author Dominik Symonowicz
 * Created 15/07/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class FillEntireAreaCommand implements Command {
    private static final Logger LOGGER = LoggerFactory.getLogger(Canvas.class);
    private Coordinates startPoint = noCoordination();
    private String fillCharacter;

    private static void fillArea(Canvas canvas, boolean[][] visitedPixel,
                                 int width, int height, String pixel, String currentFill) {
        LOGGER.debug("Checking if pixel can be filled. ");
        if (isOutOfCanvas(canvas, width, height)) {
            return;
        }

        if (visitedPixel[width][height]) {
            return;
        }

        if (isOnBorder(canvas, width, height)) {
            return;
        }

        if (canvas.getPixelAt(width, height).equals(pixel)) {
            return;
        }

        if (notEquals(canvas, width, height, currentFill)) {
            return;
        }

        LOGGER.debug("Updating pixel at ({},{})", width, height);
        canvas.updatePixelAt(width, height, pixel);
        visitedPixel[width][height] = true;

        LOGGER.debug(canvas.getCanvasAsString());
        fillArea(canvas, visitedPixel, previous(width), height, pixel, currentFill);
        fillArea(canvas, visitedPixel, next(width), height, pixel, currentFill);
        fillArea(canvas, visitedPixel, width, previous(height), pixel, currentFill);
        fillArea(canvas, visitedPixel, width, next(height), pixel, currentFill);
    }

    private static int next(int pixel) {
        return pixel + 1;
    }

    private static int previous(int pixel) {
        return pixel - 1;
    }

    private static boolean notEquals(Canvas canvas, int width, int height, String currentFill) {
        return !canvas.getPixelAt(width, height).equals(currentFill);
    }

    private static boolean isOutOfCanvas(Canvas canvas, int width, int height) {
        return width < 0 || height < 0 || width > canvas.getWidth() || height > canvas.getHeight();
    }

    private static boolean isOnBorder(Canvas canvas, int width, int height) {
        final String pixel = canvas.getPixelAt(width, height);
        return pixel.equals("-") || pixel.equals("|");
    }

    @Override
    public String getSyntax() {
        return "B";
    }

    @Override
    public boolean isParamsRequired() {
        return true;
    }

    @Override
    public void setParamsIfValid(String[] params) {
        validateParamsNumber(4, params);
        validatePositiveLength(params[1], "start height");
        validatePositiveLength(params[2], "end width");
        validateFillCharacter(params[3], "fill character");
        setParam(params);
    }

    private void setParam(String[] params) {
        startPoint = new Coordinates(Integer.valueOf(params[1]), Integer.valueOf(params[2]));
        fillCharacter = params[3];
    }

    @Override
    public void execute(Canvas canvas) {
        LOGGER.debug("Executing Fill Entire Area Command with starting point: ({},{})", startPoint.getWidth(), startPoint.getHeight());

        if (canvas.isNoCanvas() || !startPoint.isCoordinatesSet()) {
            return;
        }

        final String currentFill = canvas.getPixelAt(startPoint.getWidth(), startPoint.getHeight());

        boolean[][] mark = new boolean[canvas.getWidth() + 1][canvas.getHeight() + 1];
        fillArea(canvas, mark, startPoint.getWidth(), startPoint.getHeight(), fillCharacter, currentFill);
    }

}
