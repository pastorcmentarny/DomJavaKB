package dms.pastor.prototypes.aberminegenerator.ui.cli;

import dms.pastor.prototypes.aberminegenerator.model.Coordinates;
import dms.pastor.prototypes.aberminegenerator.model.Pixel;
import dms.pastor.utils.ValidatorUtils;

import java.util.Objects;

import static dms.pastor.prototypes.aberminegenerator.model.TerrainType.UNKNOWN;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.StringUtils.NEW_LINE;

public class CommandLineMapRender {

    private CommandLineMapRender() {
    }

    //TODO remove width and height
    public static String renderWorld(Pixel[][] map, int width, int height) {
        StringBuilder worldBuilder = new StringBuilder(EMPTY_STRING);
        if (width == 0 || height == 0) {
            return worldBuilder.toString();
        }
        for (int y = 0; y <= height; y++) {
            for (int x = 0; x <= width; x++) {
                if (Objects.nonNull(map[x][y])) {
                    worldBuilder.append(map[x][y].getType().getTile());
                }
            }
            worldBuilder.append(NEW_LINE);
        }
        return worldBuilder.toString();
    }

    public static String renderAreaWithVisionRangeOf(Pixel[][] map, Coordinates coordinates, int range) {
        StringBuilder worldBuilder = new StringBuilder(EMPTY_STRING);
        ValidatorUtils.validateIfPositiveNumber(range); //TODO add all validators
        for (int y = coordinates.getHeight() - range; y <= coordinates.getHeight() + range; y++) {
            for (int x = coordinates.getWidth() - range; x <= coordinates.getWidth() + range; x++) {
                try {
                    if (Objects.nonNull(map[x]) && Objects.nonNull(map[x][y])) {
                        worldBuilder.append(map[x][y].getType().getTile());
                    } else {
                        if (Objects.isNull(map[x]) || Objects.isNull(map[x][y])) {
                            worldBuilder.append(UNKNOWN.getTile());
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    worldBuilder.append(UNKNOWN.getTile());
                }
            }
            worldBuilder.append(NEW_LINE);
        }
        return worldBuilder.toString();
    }
}
