package dms.pastor.tools.guid;

import dms.pastor.utils.ValidatorUtils;

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
public class MultiGuidGenerator {

    @SuppressWarnings("ConstantConditions")
    public static void main(String[] args) {
        int quantity = 0; // SET quantity
        if (quantity > 0) {
            generateGuids(Integer.valueOf(args[0]));
        } else {
            ValidatorUtils.validateIfArrayHasSizeOf(1, args, "Args");
            parseNullSafeIntegerAsString(args[0], 1);
        }
    }

    private static void generateGuids(Integer quantity) {
        IntStream.rangeClosed(1, quantity).forEach(counter -> System.out.println(randomUUID()));
    }
}
