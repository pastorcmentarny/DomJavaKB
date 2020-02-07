package dms.pastor.tasks.paint.command;

import dms.pastor.tasks.paint.canvas.Canvas;
import dms.pastor.tasks.paint.canvas.Coordinates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dms.pastor.tasks.paint.canvas.Coordinates.noCoordination;
import static dms.pastor.tasks.paint.command.CommandValidator.validateParamsNumber;
import static dms.pastor.tasks.paint.command.CommandValidator.validatePositiveLength;

/**
 * Author Dominik Symonowicz
 * Created 15/07/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class CreateCanvasCommand implements Command {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateCanvasCommand.class);
    private Coordinates dimension = noCoordination();

    @Override
    public String getSyntax() {
        return "C";
    }

    @Override
    public boolean isParamsRequired() {
        return true;
    }

    @Override
    public void setParamsIfValid(String[] params) {
        validateParamsNumber(3, params);
        validatePositiveLength(params[1], "width");
        validatePositiveLength(params[2], "height");
        setParam(params);
    }

    private void setParam(String[] params) {
        dimension = new Coordinates(Integer.parseInt(params[1]), Integer.parseInt(params[2]));
    }

    @Override
    public void execute(Canvas canvas) {
        LOGGER.debug("Executing Create Canvas Command with dimensions: ({},{})", dimension.getWidth(), dimension.getHeight());
        canvas.recreateCanvas(dimension.getWidth(), dimension.getHeight());
    }

}
