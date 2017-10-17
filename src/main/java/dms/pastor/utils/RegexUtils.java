package dms.pastor.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;

import static dms.pastor.utils.StringUtils.isStringNotEmpty;
import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
 * Created 15/07/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public final class RegexUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(RegexUtils.class);

    private RegexUtils() {
    }

    public static int countOccurrencesOf(String what, String text) {
        LOGGER.debug("counting occurrence of " + what + " in " + text);
        if (isStringNotEmpty(what) && isStringNotEmpty(text)) {
            try {
                return Pattern.compile(what)
                        .split(text)
                        .length - 1;
            } catch (RuntimeException exception) {
                LOGGER.error(format("Unable to calculate occurrence of %s in %s due expression's syntax is invalid", what, text), exception);
            }
        }
        return 0;
    }
}
