package dms.pastor.tools.trips.tube.station;

import java.util.List;
import java.util.Objects;

import static java.util.Collections.singletonList;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Line {
    private final String name;

    public Line(String name) {
        this.name = name;
    }

    public static List<Line> noLine() {
        return singletonList(new Line("none"));
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        return Objects.equals(name, line.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Line{" +
            "name='" + name + '\'' +
            '}';
    }
}
