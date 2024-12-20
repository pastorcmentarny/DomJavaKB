package dms.pastor.tools;

import java.util.UUID;
import java.util.stream.IntStream;

import static dms.pastor.utils.NumberUtils.parseNullSafeIntegerAsString;
import static dms.pastor.utils.StringUtils.DASH;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;

/**
 * Author Dominik Symonowicz
 * Created 19/04/2018
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class GuidTools {

    private GuidTools() {
    }

    static String generateGuid() {
        return UUID.randomUUID().toString();
    }

    static String generateGuidWithoutDash() {
        return UUID.randomUUID().toString().replaceAll(DASH, EMPTY_STRING);
    }


    static String generateShortGuid() {
        return UUID.randomUUID().toString().replaceAll(DASH, EMPTY_STRING).substring(0, 8);
    }

    public static void main(String[] args) {
        int quantity = 2; // SET quantity
        if (args != null && args.length == 1) {
            generateGuids(parseNullSafeIntegerAsString(args[0], quantity));
        } else {
            generateGuids(quantity);
        }
    }

    private static void generateGuids(Integer quantity) {
        IntStream.rangeClosed(1, quantity).forEach(counter -> System.out.println(generateGuid()));
    }
}
