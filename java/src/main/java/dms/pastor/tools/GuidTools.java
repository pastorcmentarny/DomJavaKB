package dms.pastor.tools;

import java.util.UUID;
import java.util.stream.IntStream;

import static dms.pastor.utils.NumberUtils.parseNullSafeIntegerAsString;
import static dms.pastor.utils.StringUtils.DASH;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;

/**
 * Author Dominik Symonowicz
 * Created 19/04/2018
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
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
