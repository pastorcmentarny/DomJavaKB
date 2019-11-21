package dms.pastor.prototypes.map.model;


import dms.pastor.utils.ValidatorUtils;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
public class WorldMap {
    private int worldHeight;
    private int worldWidth;
    private List<Point> map;

    private WorldMap(int worldHeight, int worldWidth) {
        this.worldHeight = worldHeight;
        this.worldWidth = worldWidth;
        map = new ArrayList<>();
    }

    public static WorldMap newWorldMap(int height, int width) {
        validateCoordinates(height, width);
        return new WorldMap(height, width);
    }

    public void setPointTo(Point point) {
        validateIfCoordinatesAreInWorldRange(point);
        map.add(point);
    }

    public Optional<Point> getPointAt(int height, int width) {
        validateCoordinates(height, width);
        return map.stream().filter(point -> point.getCoordinates().getHeight() == height && point.getCoordinates().getWidth() == width).findFirst();
    }

    private void validateIfCoordinatesAreInWorldRange(Point point) {
        ValidatorUtils.validateIfValueIsInRange(0, worldHeight, point.getCoordinates().getHeight());
        ValidatorUtils.validateIfValueIsInRange(0, worldWidth, point.getCoordinates().getWidth());
    }

    private static void validateCoordinates(int height, int width) {
        ValidatorUtils.validateIfPositiveNumber(height);
        ValidatorUtils.validateIfPositiveNumber(width);
    }

}
