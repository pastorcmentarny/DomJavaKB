package dms.pastor.utils.vaildators;

import dms.pastor.utils.RegexUtils;
import dms.pastor.utils.StringUtils;

import java.util.Set;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.StringUtils.WHITESPACE;

/**
 * Information based on
 * https://en.wikipedia.org/wiki/Telephone_numbers_in_the_United_Kingdom
 */
public class UKMobileNumberValidator {

    private static final Set<String> UK_NUMBER_PATTERN = Set.of("071", "072", "073", "074", "075", "07624", "077", "078", "079",
            "+4471", " +4472", " +4473", " +4474", " +4475", " +447624, +4477", " +4478", "+4479",
            "71", " 72", " 73", " 74", " 75", " 7624, 77", " 78", "79",
            "4471", " 4472", " 4473", " 4474", " 4475", " 447624, 4477", " 4478", "4479",
            "0071", " 0072", " 0073", " 0074", " 0075", " 007624, 0077", " 0078", "0079");

    private UKMobileNumberValidator() {
    }

    private static boolean startWithMobilePhonePattern(String phoneNumber) {
        return UK_NUMBER_PATTERN.stream()
                .anyMatch(phoneNumber::startsWith);
    }

    public static boolean validate(String number) {
        if (StringUtils.isStringEmpty(number)) {
            return false;
        }

        number = number.replaceAll(WHITESPACE, EMPTY_STRING).trim();

        if (hasNotExpectedLength(number) || !RegexUtils.hasOnlyNumbersAndPlusAndMinusSign(number)) {
            return false;
        }

        return startWithMobilePhonePattern(number);
    }


    private static boolean hasNotExpectedLength(String number) {
        return !(number.length() == 10 || number.length() == 11 || number.length() == 13);
    }
}
