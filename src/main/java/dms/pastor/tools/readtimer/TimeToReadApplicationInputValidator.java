package dms.pastor.tools.readtimer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dms.pastor.utils.ValidatorUtils.validateIfNotEmpty;
import static dms.pastor.utils.ValidatorUtils.validateIfPositiveNumber;

/**
 * Author Dominik Symonowicz
 * Created 26/12/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
final class TimeToReadApplicationInputValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimeToReadApplicationInputValidator.class);
    private static final String ERROR_MESSAGE = "You can run this application without arguments,so it will run in demo mode or you need specified 2 arguments:\n\tfirst one is a text,\n\tsecond is a speed of reading";

    private TimeToReadApplicationInputValidator() {
    }

    static void validateInputArgs(String[] args) {
        LOGGER.info("Validating input .. ");

        if (args != null && args.length == 2) {
            validateIfNotEmpty(args[0], "Input");
            final int readSpeed = getReadSpeed(args[1]);
            validateIfPositiveNumber(readSpeed, "Read speed");
        } else {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private static int getReadSpeed(String readSpeed) {
        try {
            return Integer.parseInt(readSpeed);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_MESSAGE, e);
        }
    }

}
