package dms.pastor.tools.lotto.hotpick;

import dms.pastor.domain.exception.SomethingWentWrongException;
import dms.pastor.tools.lotto.hotpick.generators.HotPicksNumberToPlay2018Generator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
final class HotPicksStatsApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(HotPicksStatsApplication.class);
    private static final String NO_PATH_ERROR_MESSAGE = "Path not provided. Please add path to file as argument when you run this program.";

    private HotPicksStatsApplication() {
    }

    public static void main(String[] args) {
        LOGGER.info("Running application: " + HotPicksStatsApplication.class.getName());
        validateUserInput(args);

        try {
            final List<HotPickDraw> hotPickDrawList = new HotPicksFileUploader().loadDrawHistoryFile(args[0]).getDrawList();
            new HotPicksNumberToPlay2018Generator(hotPickDrawList).generateNumbersToPlay();
        } catch (SomethingWentWrongException e) {
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
