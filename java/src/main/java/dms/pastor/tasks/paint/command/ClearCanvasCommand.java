package dms.pastor.tasks.paint.command;

import dms.pastor.tasks.paint.canvas.Canvas;

import static dms.pastor.tasks.paint.command.CommandValidator.validateParamsNumber;

/**
 * Author Dominik Symonowicz
 * Created 07/08/2017
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public class ClearCanvasCommand implements Command {
    @Override
    public String getSyntax() {
        return "C";
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
        canvas.recreateCanvas(canvas.getWidth(), canvas.getHeight());
    }
}
