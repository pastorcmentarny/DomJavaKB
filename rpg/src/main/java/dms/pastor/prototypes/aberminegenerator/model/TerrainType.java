package dms.pastor.prototypes.aberminegenerator.model;

public enum TerrainType {
    GRASS(","),
    ROAD("."),
    STONE("O"),
    WALL("#"),
    HERO("H"),
    UNKNOWN("·");

    private final String tile;

    TerrainType(String tile) {
        this.tile = tile;
    }

    public String getTile(){
        return tile;
    }
}
