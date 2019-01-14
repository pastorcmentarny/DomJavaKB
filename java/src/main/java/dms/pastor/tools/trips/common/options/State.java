package dms.pastor.tools.trips.common.options;

public enum State {
    ABANDONED("A"),
    OPEN("O"),
    CLOSED("C");

    private final String value;

    State(String value) {
        this.value = value;
    }

}
