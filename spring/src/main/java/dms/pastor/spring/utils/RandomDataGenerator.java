package dms.pastor.spring.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    private static Character getRandomCharacterFromAlphabet() {
        return ALPHABET.toCharArray()[random.nextInt(ALPHABET.length())];
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

    public static int randomInteger(int maxValue) {
        return random.nextInt(maxValue);
    }

}
