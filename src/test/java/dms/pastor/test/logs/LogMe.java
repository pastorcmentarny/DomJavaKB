package dms.pastor.test.logs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dms.pastor.utils.StringUtils.swapCaseLettersInString;

/**
 * Author Dominik Symonowicz
 * Created 13/07/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
final class LogMe {
    private static final Logger LOG = LoggerFactory.getLogger(LogMe.class);

    private LogMe() {
    }

    static String reverseCase(String text) {
        LOG.info("Reversing: " + text);
        return swapCaseLettersInString(text);
    }
}
