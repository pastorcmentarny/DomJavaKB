package dms.pastor.prototypes.map.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

/**
 * Author Dominik Symonowicz
 * Created 18/07/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@AllArgsConstructor
@EqualsAndHashCode
public class Coordinates {
    private static final int NO_VALUE = Integer.MIN_VALUE + 1;
    private final int height;
    private final int width;

    public static Coordinates noCoordination() {
        return new Coordinates(NO_VALUE, NO_VALUE);
    }

    public static Coordinates at(int height, int width) {
        return new Coordinates(height, width);
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
    public String toString() {
        return String.format("Coordinates{width=%d, height=%d}", width, height);
    }
}

