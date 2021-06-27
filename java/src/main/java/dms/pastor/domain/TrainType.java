package dms.pastor.domain;

public enum TrainType {
    BEMU("Battery-Electric Multiple Unit"),
    EMU("Electric Multiple Unit"),
    DMU("Diesel Multiple Unit"),
    DEMU("Diesel-Electric Multiple Unit");

    private final String description;

    TrainType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
