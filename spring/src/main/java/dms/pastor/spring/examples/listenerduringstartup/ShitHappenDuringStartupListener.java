package dms.pastor.spring.examples.listenerduringstartup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;

import java.util.Random;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ShitHappenDuringStartupListener implements ApplicationListener<ApplicationPreparedEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShitHappenDuringStartupListener.class);
    private static final String NAME = ShitHappenDuringStartupListener.class.getSimpleName();

    @Override
    public void onApplicationEvent(ApplicationPreparedEvent event) {
        LOGGER.info("Checking are you lucky while running " + NAME);
        checkingIfShitHappens();
        LOGGER.info("Nothing happen ...");
    }

    private void checkingIfShitHappens() {
        final int totalNumberOfOutcomes = 1000;
        final int numberOfTimesItCanHappen = 13;
        if (new Random().nextInt(totalNumberOfOutcomes) < numberOfTimesItCanHappen) {
            LOGGER.error("WHAT A LUCK!  You will run Failure analyzer example ..");
            throw new ShitHappensException("Shit happens in " + NAME + "(" + numberOfTimesItCanHappen + ")");
        }
    }
}
