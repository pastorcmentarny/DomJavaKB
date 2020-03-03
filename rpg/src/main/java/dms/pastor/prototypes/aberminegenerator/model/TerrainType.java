package dms.pastor.prototypes.aberminegenerator.model;

public enum TerrainType {
    GRASS("."),
    STONE("O"),
    WALL("#"),
    HERO("H"),
    UNKNOWN("·");

    private String tile;

    TerrainType(String tile) {
        this.tile = tile;
    }

    public String getTile(){
        return tile;
    }
}
