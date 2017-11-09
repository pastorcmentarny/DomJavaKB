package dms.pastor.tools.tube;

import java.util.List;

import static java.util.Collections.singletonList;

class Line {
    private final String name;

    private Line(String name) {
        this.name = name;
    }

    static List<Line> noLine() {
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

        return name != null ? name.equals(line.name) : line.name == null;
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
