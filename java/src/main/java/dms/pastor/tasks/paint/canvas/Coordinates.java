package dms.pastor.tasks.paint.canvas;

import java.util.Objects;

/**
 * Author Dominik Symonowicz
 * Created 18/07/2017
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Coordinates {
    private static final int NO_VALUE = -1;
    private final int width;
    private final int height;

    public Coordinates(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static Coordinates noCoordination() {
        return new Coordinates(NO_VALUE, NO_VALUE);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isCoordinatesSet() {
        return height != NO_VALUE && width != NO_VALUE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinates)) return false;
        Coordinates that = (Coordinates) o;
        return getWidth() == that.getWidth() &&
                getHeight() == that.getHeight();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWidth(), getHeight());
    }

    @Override
    public String toString() {
        return String.format("Coordinates{width=%d, height=%d}", width, height);
    }
}
