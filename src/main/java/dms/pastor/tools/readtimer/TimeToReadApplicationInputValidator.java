package dms.pastor.tools.readtimer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author Dominik Symonowicz
 * Created 26/12/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
class TimeToReadApplicationInputValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimeToReadApplicationInputValidator.class);
    private static final String ERROR_MESSAGE = "You can run this application without arguments,so it will run in demo mode or you need specified 2 arguments:\n\tfirst one is a text,\n\tsecond is a speed of reading";

    static void validateInputArgs(String[] args) {
        LOGGER.info("Validating input .. ");

        if (args != null && args.length == 2) {
            checkIfTextIsNotEmpty(args[0]);

            final int readSpeed = getReadSpeed(args[1]);
            checkIfReadSpeedIsPositiveNumber(readSpeed);
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

    private static void checkIfReadSpeedIsPositiveNumber(int readSpeed) {
        if (readSpeed < 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private static void checkIfTextIsNotEmpty(String arg) {
        if (arg == null || arg.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
