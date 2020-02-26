package dms.pastor.prototypes.aberminegenerator;

import dms.pastor.prototypes.aberminegenerator.model.World;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class Generator {

    public static void main(String[] args) {
        int width = 0;
        int height = 0;
        if (args.length == 0) {
            log.info("Running with default settings...");
            width = 10;
            height = 10;
        }
        final World world = new World(width, height);
        log.info(world.toString());
    }
}
