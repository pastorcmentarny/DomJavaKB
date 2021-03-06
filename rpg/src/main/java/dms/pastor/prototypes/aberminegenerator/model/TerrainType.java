package dms.pastor.prototypes.aberminegenerator.model;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum TerrainType {
    GRASS(",", true),
    ROAD(".", true),
    STONE("O", false),
    WALL("#", false),
    HERO("H", false),
    TREE("T", false),
    SAND("░", true),
    CITY_WALL_NORTH("▄", false),
    CITY_WALL_EAST("▐", false),
    CITY_WALL_SOUTH("▀", false),
    CITY_WALL_WEST("▌", false),
    DOOR("∩", true),
    WATER("~", false),
    TRACK_HORIZONTAL("═", true),
    UNKNOWN("·", false);

    private final String tile;
    private final boolean penetrableByDefault;

    TerrainType(String tile, boolean penetrableByDefault) {
        this.tile = tile;
        this.penetrableByDefault = penetrableByDefault;
    }

    public static TerrainType getTerrainFromChar(char character) {
        return Arrays.stream(TerrainType.values()).filter(type -> type.getTile().equalsIgnoreCase(Character.toString(character))).findFirst().orElse(UNKNOWN);
    }
}
