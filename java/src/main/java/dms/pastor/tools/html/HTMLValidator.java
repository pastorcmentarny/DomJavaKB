package dms.pastor.tools.html;

import dms.pastor.utils.ValidatorUtils;
import dms.pastor.utils.html.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dms.pastor.utils.StringUtils.isStringBlank;

/**
 * Author Dominik Symonowicz
 * Created 16/03/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
final class HTMLValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(HTMLValidator.class);
    private static final String NOT_HTML_TYPE_ERROR_MESSAGE = "WHOOPS!\n\tIt is not a html file.Unable to read non-html file.";

    private HTMLValidator() {
    }

    static void validateContentType(String type) {
        ValidatorUtils.validateIfObjectValueIsNotNull(type);
        if (type.compareTo(ContentType.TEXT) != 0) {
            LOGGER.error(NOT_HTML_TYPE_ERROR_MESSAGE);
            throw new IllegalArgumentException(NOT_HTML_TYPE_ERROR_MESSAGE);             // only html are here
        }
    }

    //TODD improve it
    static void validateUrl(String urlStr) {
        if (isStringBlank(urlStr)) {
            throw new IllegalArgumentException("It must be valid url");
        }
    }
}
