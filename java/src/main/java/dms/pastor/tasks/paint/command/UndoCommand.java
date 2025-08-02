package dms.pastor.tasks.paint.command;

import dms.pastor.tasks.paint.canvas.Canvas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dms.pastor.tasks.paint.command.CommandValidator.validateParamsNumber;

/**
 * Author Dominik Symonowicz
 * Created 17/08/2017
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public class UndoCommand implements Command {
    private static final Logger LOGGER = LoggerFactory.getLogger(UndoCommand.class);

    @Override
    public String getSyntax() {
        return "U";
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
        LOGGER.info("Executing Undo Command");
        canvas.undo();
    }
}
