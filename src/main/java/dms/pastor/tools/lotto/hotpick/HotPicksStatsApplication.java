package dms.pastor.tools.lotto.hotpick;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
 * Created 11/03/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class HotPicksStatsApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(HotPicksStatsApplication.class);
    private static final String NO_PATH_ERROR_MESSAGE = "Path not provided. Please add path to file as argument when you run this program.";

    public static void main(String[] args) {
        LOGGER.info("Running application: " + HotPicksStatsApplication.class.getName());
        validateUserInput(args);

        try {
            new HotPicksStatsGenerator(args[0]).generateNumbersToPlay();
        } catch (IOException e) {
            LOGGER.error(format("Application crashes because: %s", e.getMessage()), e);
        }
        LOGGER.info("Application ends his life peacefully. Until next time!");
    }

    private static void validateUserInput(String[] args) {
        if (args == null || args.length != 1) {
            LOGGER.error(NO_PATH_ERROR_MESSAGE);
            throw new IllegalArgumentException(NO_PATH_ERROR_MESSAGE);
        }
    }
}
