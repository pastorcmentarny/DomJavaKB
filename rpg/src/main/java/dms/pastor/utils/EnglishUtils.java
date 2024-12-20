package dms.pastor.utils;

import static dms.pastor.utils.CollectionsUtils.isCharInCharArray;
import static dms.pastor.utils.StringUtils.isStringBlank;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
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

}

