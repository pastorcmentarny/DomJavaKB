package dms.pastor.domain;

import static java.lang.Character.toUpperCase;

/**
 * Author Dominik Symonowicz
 * Created 09/06/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public enum Country {
    CHINA("China"),
    POLAND("Poland"),
    UNITED_KINGDOM("UK");

    private static final char WHITESPACE = ' ';
    private static final String EMPTY_STRING = "";

    private final String code;

    Country(String code) {
        this.code = code;
    }

    public static String getName(Country country) {
        validateInput(country);

        final String[] words = splitCountryNameIntoWords(country);

        StringBuilder name = new StringBuilder(EMPTY_STRING);
        for (String word : words) {
            name.append(word).append(WHITESPACE);
        }

        return name.substring(0, lastElement(name));
    }

    private static void validateInput(Country country) {
        if (country == null) {
            throw new IllegalArgumentException("Country cannot be null");
        }
    }

    private static int lastElement(StringBuilder name) {
        return name.length() - 1;
    }

    private static String[] splitCountryNameIntoWords(Country country) {
        final String[] words = country.name().split("_");
        for (int i = 0; i < words.length; i++) {
            words[i] = toUpperCase(words[i].charAt(0)) + words[i].toLowerCase().substring(1);
        }
        return words;
    }

    public String code() {
        return code;
    }
}
