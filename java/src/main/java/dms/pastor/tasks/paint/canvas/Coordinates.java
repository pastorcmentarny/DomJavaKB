package dms.pastor.tasks.paint.canvas;

import java.util.Objects;

/**
 * Author: Dominik Symonowicz
 * Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
 * LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
 * GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 * Created 18/07/2017
 */
public record Coordinates(int width, int height) {
    private static final int NO_VALUE = -1;

    public static Coordinates noCoordination() {
        return new Coordinates(NO_VALUE, NO_VALUE);
    }

    public boolean isCoordinatesSet() {
        return height != NO_VALUE && width != NO_VALUE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinates(int width1, int height1))) return false;
        return width() == width1 &&
                height() == height1;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width(), height());
    }

    @Override
    public String toString() {
        return String.format("Coordinates{width=%d, height=%d}", width, height);
    }
}
