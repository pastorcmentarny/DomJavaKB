package dms.pastor.tools.trips.overground.lines;

import java.util.ArrayList;
import java.util.List;

/**
 * Author Dominik Symonowicz
 * Created 08/06/2018
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class AllOvergroundLines {

    public static List<OvergroundLine> getLines() {
        var lines = new ArrayList<OvergroundLine>();
        lines.add(new Overground());
        return lines;
    }
}
