package dms.pastor.tools.readtimer;

import java.util.Objects;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
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
