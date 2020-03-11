package dms.pastor.prototypes.aberminegenerator.model;

import java.util.Arrays;

public enum TerrainType {
    GRASS(","),
    ROAD("."),
    STONE("O"),
    WALL("#"),
    HERO("H"),
    TREE("T"),
    SAND("░"),
    DOOR("∩"),
    TRACK_HORIZONTAL("═"),
    UNKNOWN("·");

    private final String tile;

    TerrainType(String tile) {
        this.tile = tile;
    }

    public String getTile() {
        return tile;
    }

    public static TerrainType getTerrainFromChar(char character) {
        return Arrays.stream(TerrainType.values()).filter(type -> type.getTile().equalsIgnoreCase(Character.toString(character))).findFirst().orElse(UNKNOWN);
    }
}
