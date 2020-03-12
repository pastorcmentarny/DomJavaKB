package dms.pastor.prototypes.aberminegenerator;

import dms.pastor.prototypes.aberminegenerator.model.Coordinates;
import dms.pastor.prototypes.aberminegenerator.model.Pixel;
import dms.pastor.prototypes.aberminegenerator.model.PixelUtils;
import dms.pastor.prototypes.aberminegenerator.model.World;
import dms.pastor.prototypes.aberminegenerator.model.generators.WorldGenerator;
import lombok.Getter;

import static dms.pastor.prototypes.aberminegenerator.ui.cli.CommandLineMapRender.renderAreaWithVisionRangeOf;
import static dms.pastor.prototypes.aberminegenerator.ui.cli.CommandLineMapRender.renderWorld;
import static java.lang.String.format;

@Getter
public class Activity {
    private Wanderer wanderer;
    private World world;

    public Activity(Wanderer wanderer, World world) {
        this.wanderer = wanderer;
        this.world = world;
    }

    public String getMap() {
        final var map = PixelUtils.clone2DArrayOfInts(world.getWorld());
        final var width = wanderer.getCoordinates().getWidth();
        final var height = wanderer.getCoordinates().getHeight();
        map[width][height] = Pixel.getHeroAt(width, height);
        return renderAreaWithVisionRangeOf(map, wanderer.getCoordinates(), 3);
    }

    public String getWholeWorld() {
        final var map = PixelUtils.clone2DArrayOfInts(world.getWorld());
        return renderWorld(map, world.getWidth(), world.getHeight());
    }


    public void walkSouth() {
        final var coordinates = wanderer.getCoordinates();
        Coordinates walkEastCoordinates = new Coordinates(coordinates.getWidth(), coordinates.getHeight() + 1);
        walk(walkEastCoordinates, "south");
    }

    public void walkEast() {
        final var coordinates = wanderer.getCoordinates();
        Coordinates walkEastCoordinates = new Coordinates(coordinates.getWidth() + 1, coordinates.getHeight());
        walk(walkEastCoordinates, "east");
    }

    public void walkNorth() {
        final var coordinates = wanderer.getCoordinates();
        Coordinates walkEastCoordinates = new Coordinates(coordinates.getWidth(), coordinates.getHeight() - 1);
        walk(walkEastCoordinates, "north");
    }

    public void walkWest() {
        final var coordinates = wanderer.getCoordinates();
        Coordinates walkEastCoordinates = new Coordinates(coordinates.getWidth() - 1, coordinates.getHeight());
        walk(walkEastCoordinates, "west");
    }

    private void walk(Coordinates newCoordinates, String direction) {
        if (world.canGoTo(newCoordinates)) {
            wanderer.setCurrentCoordinateTo(newCoordinates);
            System.out.println(format("Going %s", direction));
        } else {
            System.out.println(format("Cannot go %s", direction));
        }

    }

    public void regenerateWorld() {
        wanderer = Wanderer.withRandomNameAtTestStartPoint();
        world = WorldGenerator.generateTestWorld();
    }
}
