package dms.pastor.spring.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//import static org.apache.kafka.test.TestUtils.RANDOM;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * Generate random data for personal use
 */
public class RandomDataGenerator {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final String ALPHABET_WITH_LOWER_AND_UPPER = ALPHABET.toUpperCase() + ALPHABET;
    private static final String ALPHABET_WITH_LOWER_UPPER_CASES_AND_NUMBERS = ALPHABET_WITH_LOWER_AND_UPPER + "0123456789";
    private static final String NON_ALPHANUMERIC = "~#&@£$^'`\".,:;*–+=(){}[]<>?!\\|/";
    private static final int NOT_SPECIFIED = -1;
    private static final int MAX_SMALL_VALUE = 10;
    private static final int MAX_LARGE_VALUE = 4096;

    private static final List<String> firstName;
    private static final List<String> surname;

    private static final Random random = new Random();

    static {
        firstName = new ArrayList<>();
        firstName.add("William");
        firstName.add("Richard");
        surname = new ArrayList<>();
        surname.add("Cabbage");
        surname.add("Winterbottom");
        surname.add("Sunshine");
        surname.add("Rusty");
    }

    private RandomDataGenerator() {
    }

    private static String getRandomText(int length) {
        if (length == NOT_SPECIFIED) {
            length = MAX_LARGE_VALUE;
        }
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < random.nextInt(length); i++) {
            addRandomCharacterToStringBuilder(text);
        }
        return text.toString();
    }

    private static void addRandomCharacterToStringBuilder(StringBuilder text) {
        int character = (int) (Math.random() * 62);
        text.append(ALPHABET_WITH_LOWER_UPPER_CASES_AND_NUMBERS, character, character + 1);
    }

    public static String getRandomText() {
        return getRandomText(NOT_SPECIFIED);
    }

    public static int[] generateRandomIntValues(int qty) {
        int[] values = new int[qty];
        for (int i = 0; i < values.length; i++) {
            values[i] = random.nextInt(Integer.MAX_VALUE - 1);
        }
        return values;
    }

    private static Character getRandomCharacterFromAlphabet() {
        return ALPHABET.toCharArray()[random.nextInt(ALPHABET.length())];
    }

    public static String getRandomCharacterAsString() {
        return getRandomCharacterFromAlphabet().toString();
    }

    public static String generateString() {
        return generateString(random.nextInt(MAX_LARGE_VALUE + 1));
    }

    public static String generateString(int max) {
        return generateString(0, max);
    }

    public static String generateString(int min, int max) {
        if (min > max || min < 0 || max <= 0) {
            throw new IllegalArgumentException("Value must be higher than zero and min value must be smaller is larger than max value");
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = min; i <= max; i++) {
            stringBuilder.append(getRandomCharacterFromAlphabet());
        }
        return stringBuilder.toString();
    }

    public static int randomInteger() {
        return randomInteger(Integer.MAX_VALUE);
    }

    public static int randomInteger(int maxValue) {
        return random.nextInt(maxValue);
    }


}
