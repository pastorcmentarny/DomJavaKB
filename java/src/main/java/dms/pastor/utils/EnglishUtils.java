package dms.pastor.utils;

import static dms.pastor.utils.CollectionsUtils.isCharInCharArray;
import static dms.pastor.utils.StringUtils.isStringBlank;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/welcome">...</a>
 * IT BLOG:	<a href="https://dominiksymonowicz.blogspot.co.uk">...</a>
 * GitHub:	<a href="https://github.com/pastorcmentarny">...</a>
 * Google Play:	<a href="https://play.google.com/store/apps/developer?id=Dominik+Symonowicz">...</a>
 * LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">...</a>
 */
public final class EnglishUtils {

    private static final char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};
    private static final char[] CONSONANTS = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
    private static final String[] STOP_WORDS = new String[]{"a", "an", "and", "are", "as", "at", "be", "but", "by", "for", "if", "in", "into", "is", "it", "no", "not", "of", "on", "or", "such", "that", "the", "their", "then", "there", "these", "they", "this", "to", "was", "will", "with"};

    private EnglishUtils() {
    }

    public static boolean isLetterVowelIncludingY(char letter) {
        char[] vowelsWithY = StringUtils.addCharToCharArray('y', VOWELS);
        for (char vowel : vowelsWithY) {
            if (Character.toLowerCase(letter) == vowel) {
                return true;
            }
        }
        return false;
    }

    public static boolean isLetterVowelExcludingY(char letter) {
        return isCharInCharArray(VOWELS, letter);
    }

    static boolean isLetterConsonant(char letter) {
        return isCharInCharArray(CONSONANTS, letter);
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

    public static String fromPolish(String polish) {
        if (StringUtils.isStringBlank(polish)) {
            return polish;
        }
        StringBuilder result = new StringBuilder();
        char[] characters = polish.toCharArray();
        for (char character : characters) {
            switch (character) {
                case 'ą' -> result.append('a');
                case 'Ą' -> result.append('A');
                case 'ć' -> result.append('c');
                case 'Ć' -> result.append('C');
                case 'ę' -> result.append('e');
                case 'Ę' -> result.append('E');
                case 'ń' -> result.append('n');
                case 'Ń' -> result.append('N');
                case 'ś' -> result.append('s');
                case 'Ś' -> result.append('S');
                case 'ó' -> result.append('o');
                case 'Ó' -> result.append('O');
                case 'ż', 'ź' -> result.append('z');
                case 'Ż', 'Ź' -> result.append('Z');
                default -> result.append(character);
            }
        }

        return result.toString();
    }

}

