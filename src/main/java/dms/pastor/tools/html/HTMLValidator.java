package dms.pastor.tools.html;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dms.pastor.utils.StringUtils.isStringBlank;
import static dms.pastor.utils.ValidatorUtils.validateIfNotNull;

/**
 * Author Dominik Symonowicz
 * Created 16/03/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
class HTMLValidator {
    private static final Logger LOGGER = LoggerFactory.getLogger(HTMLValidator.class);
    private static final String NOT_HTML_TYPE_ERROR_MESSAGE = "WHOOPS!\n\tIt is not a html file.Unable to read non-html file.";

    static void validateContentType(String type) {
        validateIfNotNull(type);
        if (type.compareTo("text/html") != 0) {
            LOGGER.error(NOT_HTML_TYPE_ERROR_MESSAGE);
            throw new IllegalArgumentException(NOT_HTML_TYPE_ERROR_MESSAGE);             // only html are here
        }
        //TODO if(type.compareTo("application/json") )
    }

    static void validateUrl(String urlStr) {
        if (isStringBlank(urlStr)) {
            throw new IllegalArgumentException("It must be valid url");
        }
    }
}
