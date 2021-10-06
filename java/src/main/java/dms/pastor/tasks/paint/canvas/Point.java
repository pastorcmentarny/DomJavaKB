package dms.pastor.tasks.paint.canvas;

import java.util.Objects;

/**
 * Author Dominik Symonowicz
 * Created 12/12/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Point {
    private final Coordinates coordinates;
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

    public String getFill() {
        return fill;
    }

    public int getHeight() {
        return coordinates.getHeight();
    }

    public int getWidth() {
        return coordinates.getWidth();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
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
