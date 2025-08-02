package dms.pastor.tools.readtimer;

import java.util.Objects;

/**
 * Author: Dominik Symonowicz
 * Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
 * LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
 * GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public enum ReadSpeed {
    ADULT_SLOW(130),
    ADULT_AVERAGE(250);

    private final int speed;

    ReadSpeed(int speed) {
        this.speed = speed;
    }

    public static String getSpeedAsStringFor(ReadSpeed readSpeed) {
        return String.valueOf(Objects.requireNonNullElse(readSpeed, ADULT_AVERAGE).speed());
    }

    public int speed() {
        return speed;
    }
}
