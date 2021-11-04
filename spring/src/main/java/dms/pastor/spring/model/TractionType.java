package dms.pastor.spring.model;

public enum TractionType {
    EMU("electric multiple unit"),
    DMU("diesel multiple unit"),
    DEMU("diesel electric multiple unit");

    private final String tractionTypeDescription;

    TractionType(String tractionTypeDescription) {
        this.tractionTypeDescription = tractionTypeDescription;
    }
}
