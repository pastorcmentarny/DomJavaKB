package dms.pastor.prototypes.aberminegenerator.ui;

import dms.pastor.prototypes.aberminegenerator.model.Pixel;

import java.util.Objects;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.StringUtils.NEW_LINE;

public class CommandLineMapRender {

    private CommandLineMapRender (){}

    //TODO remove width and height
    public static String render(Pixel[][] map, int width, int height) {
        StringBuilder worldBuilder = new StringBuilder(EMPTY_STRING);
        if (width == 0 || height == 0) {
            return worldBuilder.toString();
        }
        for (int y = 0; y <= height; y++) {
            for (int x = 0; x <= width; x++) {
                if (Objects.nonNull(map[x][y])) {
                    worldBuilder.append(map[x][y].getType().name().charAt(0));
                }
            }
            worldBuilder.append(NEW_LINE);
        }
        return worldBuilder.toString();
    }
}
