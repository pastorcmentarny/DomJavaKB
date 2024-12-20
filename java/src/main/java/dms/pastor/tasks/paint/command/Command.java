package dms.pastor.tasks.paint.command;

import dms.pastor.tasks.paint.canvas.Canvas;

/**
 * Author Dominik Symonowicz
 * Created 14/07/2017
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public interface Command {

    String getSyntax();

    boolean isParamsRequired();

    void setParamsIfValid(String[] params);

    void execute(Canvas canvas);

}
