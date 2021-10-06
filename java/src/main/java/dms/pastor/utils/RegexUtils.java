package dms.pastor.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import static dms.pastor.utils.StringUtils.isStringNotEmpty;
import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class RegexUtils {
    public static final String GUID_REGEX = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    private static final Logger LOGGER = LoggerFactory.getLogger(RegexUtils.class);
    private static final String NUMBERS_WITH_PLUS_AND_MINUS = "[\\d +-]+";

    private RegexUtils() {
    }


    public static int countOccurrencesOf(String what, String text) {
        LOGGER.debug("counting occurrence of " + what + " in " + text);
        if (isStringNotEmpty(what) && isStringNotEmpty(text)) {
            try {
                return Pattern.compile(what)
                        .split(text)
                        .length - 1;
            } catch (PatternSyntaxException exception) {
                LOGGER.error(format("Unable to calculate occurrence of %s in %s due expression's syntax is invalid", what, text), exception);
            }
        }
        return 0;
    }

    public static boolean hasOnlyNumbersAndPlusAndMinusSign(String text) {
        return Pattern.matches(NUMBERS_WITH_PLUS_AND_MINUS, text);
    }
}
