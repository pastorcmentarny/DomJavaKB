package dms.pastor.tools.trips.tube.station;

import dms.pastor.domain.exception.NotFoundException;

import java.util.Arrays;

import static dms.pastor.utils.StringUtils.UNDERSCORE;
import static dms.pastor.utils.StringUtils.WHITESPACE;
import static dms.pastor.utils.ValidatorUtils.validateIfNotEmpty;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */

public enum Status {
    NOT_VISITED("X"),
    PASSED("P"),
    VISITED("V");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    public static Status fromValue(String statusShortcut) {
        validateIfNotEmpty(statusShortcut);

        return Arrays
                .stream(Status.values())
                .filter(status -> status.value().equalsIgnoreCase(statusShortcut))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Status"));
    }

    public String value() {
        return value;
    }

    public String asName() {
        return name().toLowerCase().replaceAll(UNDERSCORE, WHITESPACE);
    }
}
