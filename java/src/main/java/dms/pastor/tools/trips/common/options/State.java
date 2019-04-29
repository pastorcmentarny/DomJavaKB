package dms.pastor.tools.trips.common.options;

import dms.pastor.domain.exception.NotFoundException;

import java.util.Arrays;

import static dms.pastor.utils.ValidatorUtils.validateIfNotEmpty;

public enum State {
    ABANDONED("A"),
    OPEN("O"),
    CLOSED("C");

    private final String value;

    private String value() {
        return value;
    }


    State(String value) {
        this.value = value;
    }

    public static State fromValue(String statusShortcut) {
        validateIfNotEmpty(statusShortcut);

        return Arrays
            .stream(State.values())
            .filter(state -> state.value().equalsIgnoreCase(statusShortcut))
            .findFirst()
            .orElseThrow(() -> new NotFoundException("State"));
    }

}
