package dms.pastor.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;

import static dms.pastor.utils.StringUtils.isStringNotEmpty;
import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class RegexUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(RegexUtils.class);
    private static final String BLANK_LINE = "^(?:[\\t ]*(?:\\r?\\n|\\r))+\n";
    private static final String MORE_THAN_ONE_SPACE_BETWEEN_WORDS = "\\w([ ]{1,})\\w";

    private RegexUtils() {
    }

    //    private static final String regex
    //            .*(55).*

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
