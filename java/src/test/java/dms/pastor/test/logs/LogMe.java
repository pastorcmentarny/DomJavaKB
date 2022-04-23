package dms.pastor.test.logs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dms.pastor.utils.StringUtils.swapCaseLettersInString;

/**
 * Author Dominik Symonowicz
 * Created 13/07/2017
 * WWW:	<a href="https://dominiksymonowicz.com/welcome">https://dominiksymonowicz.com/welcome</a>
 * IT BLOG:	<a href="https://dominiksymonowicz.blogspot.co.uk">https://dominiksymonowicz.blogspot.co.uk</a>
 * GitHub:	<a href="https://github.com/pastorcmentarny">https://github.com/pastorcmentarny</a>
 * Google Play:	<a href="https://play.google.com/store/apps/developer?id=Dominik+Symonowicz">https://play.google.com/store/apps/developer?id=Dominik+Symonowicz</a>
 * LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">https://www.linkedin.com/in/dominik-symonowicz</a>
 */
final class LogMe {
    private static final Logger LOG = LoggerFactory.getLogger(LogMe.class);

    private LogMe() {
    }

    @SuppressWarnings("SameParameterValue") //it is an example
    static String reverseCase(String text) {
        LOG.info("Reversing: " + text);
        return swapCaseLettersInString(text);
    }
}
