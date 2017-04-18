package dms.pastor.utils;

import static dms.pastor.utils.StringUtils.isStringBlank;

/**
 * Author Dominik Symonowicz
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public final class EnglishUtils {
    private static final char[] vowels = {'a', 'e', 'i', 'o', 'u'};
    private static final char[] consonants = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
    private static final String[] STOP_WORDS = new String[]{"a", "an", "and", "are", "as", "at", "be", "but", "by", "for", "if", "in", "into", "is", "it", "no", "not", "of", "on", "or", "such", "that", "the", "their", "then", "there", "these", "they", "this", "to", "was", "will", "with"};

    private EnglishUtils() {
    }

    public static boolean isLetterVowelIncludingY(char letter) {
        char[] vowelsWithY = StringUtils.addCharToCharArray('y', vowels);
        for (char vowel : vowelsWithY) {
            if (Character.toLowerCase(letter) == vowel) {
                return true;
            }
        }
        return false;
    }

    public static boolean isLetterVowelExcludingY(char letter) {

        for (char vowel : vowels) {
            if (Character.toLowerCase(letter) == vowel) {
                return true;
            }
        }
        return false;
    }


    static boolean isLetterConsonant(char letter) {
        for (char consonant : consonants) {
            if (Character.toLowerCase(letter) == consonant) {
                return true;
            }
        }
        return false;
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

