package dms.pastor.tools.guid;

import java.util.stream.IntStream;

import static dms.pastor.utils.NumberUtils.parseNullSafeIntegerAsString;
import static java.util.UUID.randomUUID;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class MultiGuidGenerator {

    private MultiGuidGenerator() {
    }

    @SuppressWarnings("ConstantConditions")
    public static void main(String[] args) {
        int quantity = 2; // SET quantity
        if (args != null && args.length == 1) {
            generateGuids(parseNullSafeIntegerAsString(args[0], quantity));
        } else {
            generateGuids(quantity);
        }
    }

    private static void generateGuids(Integer quantity) {
        IntStream.rangeClosed(1, quantity).forEach(counter -> System.out.println(randomUUID()));
    }
}
