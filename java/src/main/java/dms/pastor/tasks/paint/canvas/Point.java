package dms.pastor.tasks.paint.canvas;

import lombok.Getter;

import java.util.Objects;

/**
 * Author Dominik Symonowicz
 * Created 12/12/2017
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public class Point {
    private final Coordinates coordinates;
    @Getter
    private final String fill;

    public Point(Coordinates coordinates, String fill) {
        this.coordinates = coordinates;
        this.fill = fill;
    }

    public static Point of(int width, int height, String fill) {
        return new Point(new Coordinates(width, height), fill);
    }

    public static Point withReplacedWidth(int newWidth, Point point) {
        return new Point(new Coordinates(newWidth, point.getHeight()), point.getFill());
    }

    public static Point withReplacedHeight(int newHeight, Point point) {
        return new Point(new Coordinates(point.getWidth(), newHeight), point.getFill());
    }

    private Coordinates getCoordinates() {
        return coordinates;
    }

    public int getHeight() {
        return coordinates.height();
    }

    public int getWidth() {
        return coordinates.width();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point point)) return false;
        return Objects.equals(getCoordinates(), point.getCoordinates()) &&
                Objects.equals(getFill(), point.getFill());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCoordinates(), getFill());
    }

    @Override
    public String toString() {
        return "Point{" +
                "coordinates=" + coordinates +
                ", fill='" + fill + '\'' +
                '}';
    }
}
