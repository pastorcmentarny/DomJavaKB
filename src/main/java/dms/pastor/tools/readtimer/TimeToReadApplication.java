package dms.pastor.tools.readtimer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

import static dms.pastor.tools.readtimer.TimeToReadApplicationInputValidator.validateInputArgs;

/**
 * Author Dominik Symonowicz
 * Created 25/12/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class TimeToReadApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimeToReadApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Starting application.. at " + LocalDateTime.now().toString());

        validateInputArgs(args);

        ReadTimeCalculator readTimeCalculator = new ReadTimeCalculator(args[0],Integer.parseInt(args[1]));
        readTimeCalculator.displayTimeNeededToRead();

        LOGGER.info("RIP .. at " + LocalDateTime.now().toString());
    }
}