package dms.pastor.tools.readtimer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dms.pastor.utils.ValidatorUtils.validateIfNotEmpty;
import static dms.pastor.utils.ValidatorUtils.validateIfPositiveNumber;

/**
 * Author Dominik Symonowicz
 * Created 26/12/2016
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
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
