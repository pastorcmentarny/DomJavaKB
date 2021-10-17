package dom.coffirgar.transportmanager.common;

import java.util.Random;

/*
Yeah , I know utils
 */
public class Utils {
    private static final Random RANDOM = new Random(System.nanoTime());
    public static final String EMPTY_STRING = "";
    public static final String TAB = "    ";
    public static final String DASH = "-";
    public static final String WHITESPACE = " ";
    public static final char WHITESPACE_CHAR = ' ';
    public static final String NEW_LINE = System.lineSeparator();
    public static final CharSequence CHAR_SEQUENCE_NEW_LINE = "\n";
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static final String ALPHANUMERIC = ALPHABET.toUpperCase() + ALPHABET + "0123456789";
    public static final String COMMA = ",";
    public static final String UNDERSCORE = "_";
    public static final String COLUMN_SEPARATOR = ";;";
    static final String NON_ALPHANUMERIC = "~#&@£$^'`\".,:;*–+=(){}[]<>?!\\|/";
    private static final String ALPHABET_BOTH_CASE = ALPHABET + ALPHABET.toUpperCase();
    private static final String ALPHANUMERIC_REGEX = "[^a-zA-Z0-9]";
    private static final String DEFAULT_VALUE_NAME = "Value";
    private static final int MAX_LARGE_VALUE_RANGE = 4096;

    public static void validateIfNotEmpty(String value) {
        throwExceptionIfEmpty(value, DEFAULT_VALUE_NAME);
    }

    @Deprecated(forRemoval = true)//
    public static boolean isStringEmpty(String string) {
        return string == null || string.isEmpty();
    }

    public static String generateString() {
        return generateString(0, RANDOM.nextInt(MAX_LARGE_VALUE_RANGE) + 1);
    }

    private static void throwExceptionIfEmpty(String object, String objectName) {
        if (object == null || object.isEmpty()) {
            throw new IllegalArgumentException(getErrorMessage(objectName));
        }
    }

    private static Character getRandomCharacterFrom(String array) {
        return array.toCharArray()[RANDOM.nextInt(ALPHABET.length())];
    }

    public static String generateString(int min, int max) {
        if (min > max || min < 0 || max <= 0) {
            throw new IllegalArgumentException("Value must be higher than zero and min value must be smaller is larger than max value");
        }
        int sizeOfString = min + RANDOM.nextInt(max - min);
        StringBuilder stringBuilder = new StringBuilder(EMPTY_STRING);
        for (int index = 0; index <= sizeOfString; index++) {
            stringBuilder.append(getRandomCharacterFromAlphabet());
        }
        return stringBuilder.toString();
    }

    public static Character getRandomCharacterFromAlphabet() {
        return getRandomCharacterFrom(ALPHABET);
    }


    private static String getErrorMessage(String what) {
        return what + " cannot be null or empty.";
    }

}