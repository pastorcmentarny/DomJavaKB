package dms.pastor.tasks.paint.command;

import dms.pastor.tasks.paint.canvas.Canvas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dms.pastor.tasks.paint.command.CommandValidator.validateParamsNumber;

/**
 * Author Dominik Symonowicz
 * Created 17/08/2017
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class RedoCommand implements Command {
    private static final Logger LOGGER = LoggerFactory.getLogger(Canvas.class);

    @Override
    public String getSyntax() {
        return "R";
    }

    @Override
    public boolean isParamsRequired() {
        return false;
    }

    @Override
    public void setParamsIfValid(String[] params) {
        validateParamsNumber(1, params);
    }

    @Override
    public void execute(Canvas canvas) {
        LOGGER.info("Executing Redo Command");
        canvas.redo();
        LOGGER.debug("Image after redo:" + canvas.getCanvasAsString());
    }
}
