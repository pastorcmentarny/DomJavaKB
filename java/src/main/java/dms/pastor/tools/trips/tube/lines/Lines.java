package dms.pastor.tools.trips.tube.lines;

import java.util.ArrayList;
import java.util.List;

/**
 * Author Dominik Symonowicz
 * Created 08/06/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Lines {
    List<Line> lines = getLines();

    public static List<Line> getLines() {
        var lines = new ArrayList<Line>();
        lines.add(new Bakerloo());
        lines.add(new Central());
        lines.add(new Circle());
        lines.add(new District());
        lines.add(new HammersmithAndCity());
        lines.add(new Jubilee());
        lines.add(new Metropolitan());
        lines.add(new Northern());
        lines.add(new Piccadilly());
        lines.add(new Victoria());
        lines.add(new WaterlooAndCity());
        return lines;
    }
}