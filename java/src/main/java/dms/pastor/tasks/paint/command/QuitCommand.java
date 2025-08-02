package dms.pastor.tasks.paint.command;

import dms.pastor.domain.exception.SomethingWentWrongException;
import dms.pastor.tasks.paint.canvas.Canvas;

import static dms.pastor.tasks.paint.command.CommandValidator.validateParamsNumber;

/**
 * Author: Dominik Symonowicz
 * Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
 * LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
 * GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 * Created 15/07/2017
 */
public class QuitCommand implements Command {

    @Override
    public String getSyntax() {
        return "Q";
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
        throw new SomethingWentWrongException("Bug detected. execute method in quit command should not be called.");
    }
}
