package dms.pastor.tools.trips.overground.lines;

import java.util.ArrayList;
import java.util.List;

/**
 * Author Dominik Symonowicz
 * Created 08/06/2018
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public class AllOvergroundLines {

    public static List<OvergroundLine> getLines() {
        var lines = new ArrayList<OvergroundLine>();
        lines.add(new Overground());
        return lines;
    }
}
