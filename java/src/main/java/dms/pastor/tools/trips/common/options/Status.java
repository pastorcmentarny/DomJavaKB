package dms.pastor.tools.trips.common.options;

import dms.pastor.domain.exception.NotFoundException;

import java.util.Arrays;

import static dms.pastor.utils.StringUtils.UNDERSCORE;
import static dms.pastor.utils.StringUtils.WHITESPACE;
import static dms.pastor.utils.ValidatorUtils.validateIfNotEmpty;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */

public enum Status {
    NOT_VISITED("X"),
    CHANGE("S"), // I use S from switch
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
