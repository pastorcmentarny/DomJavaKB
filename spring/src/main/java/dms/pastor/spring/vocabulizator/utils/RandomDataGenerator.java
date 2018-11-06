package dms.pastor.spring.vocabulizator.utils;

import java.util.Random;

/**
 * Author Dominik Symonowicz
 * Created 26/10/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class RandomDataGenerator {
    private static final Random random = new Random();

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final String ALPHABET_WITH_LOWER_AND_UPPER = ALPHABET.toUpperCase() + ALPHABET;
    private static final String ALPHABET_WITH_LOWER_UPPER_CASES_AND_NUMBERS = ALPHABET_WITH_LOWER_AND_UPPER + "0123456789";
    private static final int MAX_LARGE_VALUE = 4096;


    public static String generateString() {
        return generateString(random.nextInt(MAX_LARGE_VALUE + 1));
    }

    public static String generateString(int max) {

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < max; i++) {
            stringBuilder.append(getRandomCharacterFromAlphanumericValues());
        }
        return stringBuilder.toString();
    }

    public static Character getRandomCharacterFromAlphanumericValues() {
        return ALPHABET_WITH_LOWER_UPPER_CASES_AND_NUMBERS.toCharArray()[random.nextInt(ALPHABET_WITH_LOWER_UPPER_CASES_AND_NUMBERS.length())];
    }
}
