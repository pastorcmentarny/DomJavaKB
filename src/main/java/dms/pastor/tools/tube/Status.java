package dms.pastor.tools.tube;

import dms.pastor.domain.exception.NotFoundException;

import java.util.Arrays;

import static dms.pastor.utils.ValidatorUtils.validateIfNotEmpty;

public enum Status {
    NOT_VISITED("X"),
    PASSED("P"),
    VISITED("V");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public static Status fromValue(String statusShortcut) {
        validateIfNotEmpty(statusShortcut);

        return Arrays
                .stream(Status.values())
                .filter(status -> status.value().equalsIgnoreCase(statusShortcut))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Status"));
    }
}
