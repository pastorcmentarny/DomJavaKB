package dms.pastor.tools.lotto;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
 * Created 11/03/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class HotPicksStatsApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(HotPicksStatsApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Running application: " + HotPicksStatsApplication.class.getName());

        try {
            new HotPicksStatsGenerator().generateNumbersToPlay();
        } catch (IOException e) {
            LOGGER.error(format("Application crashes because: %s", e.getMessage()),e);
        }
        LOGGER.info("Application ends his life peacefully. Until next time!");
    }
}
