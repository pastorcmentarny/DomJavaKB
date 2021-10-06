package dms.pastor.utils.randoms;

import dms.pastor.utils.ValidatorUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;

/**
 * Author Dominik Symonowicz
 * Created 16/04/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class PersonalDataGenerator {

    private static final List<String> FIRST_NAME;
    private static final List<String> SURNAME;
    private static final Random RANDOM = new Random();

    static {
        FIRST_NAME = new ArrayList<>();
        FIRST_NAME.add("William");
        FIRST_NAME.add("Richard");
        FIRST_NAME.add("Walter");
        FIRST_NAME.add("Henry");
        FIRST_NAME.add("Clarence");
        FIRST_NAME.add("Louis");
        FIRST_NAME.add("Martha");
        FIRST_NAME.add("Florence");
        FIRST_NAME.add("Bertha");
        FIRST_NAME.add("Sarah");
        SURNAME = new ArrayList<>();
        SURNAME.add("Breeden");
        SURNAME.add("Cabbage");
        SURNAME.add("Oakes");
        SURNAME.add("Summer");
        SURNAME.add("Sunshine");
        SURNAME.add("Tattersall");
        SURNAME.add("Thornton");
        SURNAME.add("Rusty");
        SURNAME.add("Wheaton");
        SURNAME.add("Winterbottom");
        SURNAME.add("Wordsworth");
    }

    private PersonalDataGenerator() {
    }

    public static String generateFirstName() {
        return FIRST_NAME.get(RANDOM.nextInt(FIRST_NAME.size()));
    }

    public static String generateSurname() {
        return SURNAME.get(RANDOM.nextInt(SURNAME.size()));
    }


    public static String generatePhoneNumberForPattern(String pattern) {
        validatePatternForPhone(pattern);

        StringBuilder result = new StringBuilder(EMPTY_STRING);
        final char[] chars = pattern.toCharArray();
        for (char character : chars) {
            if (character == 'X') {
                result.append(new Random().nextInt(10));
            } else {
                throwExceptionIfContainsIllegalCharacter(pattern, character);
                result.append(character);
            }
        }

        return result.toString();
    }

    private static void throwExceptionIfContainsIllegalCharacter(String pattern, char character) {
        if (containsIllegalCharacter(character)) {
            throw new IllegalArgumentException("Pattern for phone contains illegal character(s). Pattern provided: " + pattern);
        }
    }

    private static boolean containsIllegalCharacter(char character) {
        return !"0123456789()-+xX".contains(String.valueOf(character));
    }

    private static void validatePatternForPhone(String pattern) {
        ValidatorUtils.validateIfObjectValueIsNotNull(pattern);
        Pattern regex = Pattern.compile("[0-9()-+xX]+$");
        Matcher matcher = regex.matcher(pattern);

        if (pattern.isEmpty()) {
            return;
        }

        if (!matcher.find()) {
            throw new IllegalArgumentException("Pattern for phone contains illegal character(s). Pattern provided: " + pattern);
        }
    }

    public static String generateName() {
        return generateFirstName() + " " + generateSurname();
    }
}
