package dom.coffirgar.transportmanager.domain.stations;

import com.fasterxml.jackson.annotation.JsonCreator;
import dom.coffirgar.transportmanager.exceptions.NotFoundException;

import java.util.Arrays;

import static dom.coffirgar.transportmanager.common.Utils.*;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */

public enum Status {
    NOT_VISITED("X"),
    CHANGE("S"), // I use S from switch
    PASSED("P"),
    VISITED("V"),
    UNKNOWN("U");
    private final String value;

    Status(String value) {
        this.value = value;
    }

    @JsonCreator
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
