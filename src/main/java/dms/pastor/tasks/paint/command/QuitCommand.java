package dms.pastor.tasks.paint.command;

import dms.pastor.domain.exception.SomethingWentWrongException;
import dms.pastor.tasks.paint.canvas.Canvas;

import static dms.pastor.tasks.paint.command.CommandValidator.validateParamsNumber;

/**
 * Author Dominik Symonowicz
 * Created 15/07/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
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
        throw new SomethingWentWrongException("execute in quit command should not be called.");
    }
}
