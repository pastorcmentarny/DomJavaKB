package dms.pastor.tools.trips.train;

import dms.pastor.domain.exception.NotFoundException;

import java.util.Arrays;

import static dms.pastor.utils.StringUtils.UNDERSCORE;
import static dms.pastor.utils.StringUtils.WHITESPACE;
import static dms.pastor.utils.ValidatorUtils.validateIfNotEmpty;

/**
 * Author Dominik Symonowicz
 * Created 29/04/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public enum Status {
    NOT_VISITED("X"),
    PASSED("P"),
    STOPPED("S"),
    CHANGED("C"),
    EXITED_ENTERED("E");
    private final String code;

    Status(String code) {
        this.code = code;
    }

    public static dms.pastor.tools.trips.tube.station.Status fromValue(String statusShortcut) {
        validateIfNotEmpty(statusShortcut);

        return Arrays
                .stream(dms.pastor.tools.trips.tube.station.Status.values())
                .filter(status -> status.value().equalsIgnoreCase(statusShortcut))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Status"));
    }

    public String code() {
        return code;
    }

    public String asName() {
        return name().toLowerCase().replaceAll(UNDERSCORE, WHITESPACE);
    }
}
