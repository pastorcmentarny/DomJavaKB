package dms.pastor.spring;


import java.util.Random;

import static java.lang.String.format;

/**
 * THIS IS TEMPORARY CLASS COPIED FROM JAVA PROJECT DUE TO GRADLE IMPORT MODULE ISSUE
 * //FIXME replace it with import java module to spring
 */
public final class DomUtils {
    public static final String EMPTY_STRING = "";
    private static final String ERROR_MESSAGE_VALUE_CANNOT_BE_NEGATIVE = " must be positive value.";
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final int MAX_LARGE_VALUE_RANGE = 4096;
    private static final Random RANDOM = new Random(System.nanoTime());
    private static final String ALPHABET_WITH_LOWER_AND_UPPER = ALPHABET.toUpperCase() + ALPHABET;
    private static final String ALPHABET_WITH_ALL_CASES_AND_NUMBERS = ALPHABET_WITH_LOWER_AND_UPPER + "0123456789";
    private static final String COMMA = ",";
    private static final String OPEN_ARRAY = "[";
    private static final char CLOSE_ARRAY = ']';
    public static final String DASH = "-";
    public static final int NO_VALUE = -1;
    public static final char WHITESPACE_CHAR = ' ';
    private static final String OPEN_ARRAY_WITH_SPACE = OPEN_ARRAY + WHITESPACE_CHAR;
    private static final String[] STOP_WORDS = new String[]{"a", "an", "and", "are", "as", "at", "be", "but", "by", "for", "if", "in", "into", "is", "it", "no", "not", "of", "on", "or", "such", "that", "the", "their", "then", "there", "these", "they", "this", "to", "was", "will", "with"};

    private DomUtils() {
    }

    public static Character getRandomCharacterFromAlphabet() {
        return getRandomCharacterFrom();
    }

    private static Character getRandomCharacterFrom() {
        return DomUtils.ALPHABET.toCharArray()[RANDOM.nextInt(ALPHABET.length())];
    }

    public static String generateString() {
        return generateString(RANDOM.nextInt(MAX_LARGE_VALUE_RANGE) + 1);
    }

    public static String generateString(int max) {
        return generateString(0, max);
    }

    public static String generateString(int min, int max) {
        if (min > max || min < 0 || max <= 0) {
            throw new IllegalArgumentException("Value must be higher than zero and min value must be smaller is larger than max value");
        }
        int sizeOfString = min + RANDOM.nextInt(max - min);
        StringBuilder stringBuilder = new StringBuilder(EMPTY_STRING);
        for (int i = 0; i <= sizeOfString; i++) {
            stringBuilder.append(getRandomCharacterFromAlphabet());
        }
        return stringBuilder.toString();
    }

    public static int randomPositiveInteger() {
        return RANDOM.nextInt(Integer.MAX_VALUE - 1) + 1;
    }

    public static void validateIfPositiveNumber(int number) {
        validateIfPositiveNumber(number, "value");
    }

    public static void validateIfPositiveNumber(int number, String valueName) {
        if (number <= 0) {
            throw new IllegalArgumentException(valueName + " {" + number + "} " + ERROR_MESSAGE_VALUE_CANNOT_BE_NEGATIVE);
        }
    }

    public static boolean isStopWord(String word) {
        if (isStringBlank(word)) {
            return false;
        }
        for (String stopWord : STOP_WORDS) {
            if (word.equalsIgnoreCase(stopWord)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNotStopWord(String word) {
        return !isStopWord(word);
    }

    public static boolean isValueInRange(int min, int max, int number) {
        validateMinValueIsSmallerThanMaxValue(min, max);
        return number >= min && number <= max;
    }

    public static void validateMinValueIsSmallerThanMaxValue(int minValue, int maxValue) {
        if (minValue >= maxValue) {
            throw new IllegalArgumentException(format("MinValue (%d) must be lower than MaxValue(%d)", minValue, maxValue));
        }
    }

    public static void validateValueIsSmallerOrEqualsThatOtherValue(int value, int otherValue) {
        if (value > otherValue) {
            throw new IllegalArgumentException(format("Value (%d) must be lower or equals to than Other Value(%d)", value, otherValue));
        }
    }

    public static boolean isStringBlank(String string) {
        return string == null || string.trim().isEmpty();
    }
}
