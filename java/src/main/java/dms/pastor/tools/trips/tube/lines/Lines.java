package dms.pastor.tools.trips.tube.lines;

import dms.pastor.domain.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import static dms.pastor.utils.StringUtils.isStringEmpty;

/**
 * Author Dominik Symonowicz
 * Created 08/06/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@Slf4j
public class Lines {

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

    //TODO add 2 character shortcut to search
    public static Line findLine(String searchFor) {
        final NotFoundException notFoundException = new NotFoundException("tube line: " + searchFor);
        if (isStringEmpty(searchFor)) {
            log.warn(String.format("Unable to find line as search query is invalid. User typed: %s", searchFor));
            throw notFoundException;
        }


        return getLines().stream()
                .filter(station -> station.getClass().getSimpleName().equalsIgnoreCase(searchFor))
                .findFirst()
                .orElseThrow(() -> notFoundException);
    }

    public static void displayAllLinesNames(){
        getLines().forEach(line -> System.out.print(line.name() + " "));
    }
}
