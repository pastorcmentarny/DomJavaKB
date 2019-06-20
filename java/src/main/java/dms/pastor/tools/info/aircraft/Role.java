package dms.pastor.tools.info.aircraft;

public enum Role {
    SHORT_HAUL("short haul"),
    MEDIUM_HAUL("short haul"),
    SHORT_MEDIUM_HAUL("short to medium haul"),
    LONG_HAUL("short haul");

    private String description;

    Role(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
