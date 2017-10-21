package dms.pastor.tools.chinese.validator;

import java.util.UUID;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;

/**
 * Author Dominik Symonowicz
 * Created 20/10/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
final class GuidGeneratorTool {

    private GuidGeneratorTool() {
    }

    static String generateGuid() {
        return UUID.randomUUID().toString().replaceAll("-", EMPTY_STRING);
    }
}
