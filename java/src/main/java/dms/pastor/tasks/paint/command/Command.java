package dms.pastor.tasks.paint.command;

import dms.pastor.tasks.paint.canvas.Canvas;

/**
 * Author Dominik Symonowicz
 * Created 14/07/2017
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public interface Command {

    String getSyntax();

    boolean isParamsRequired();

    void setParamsIfValid(String[] params);

    void execute(Canvas canvas);

}
