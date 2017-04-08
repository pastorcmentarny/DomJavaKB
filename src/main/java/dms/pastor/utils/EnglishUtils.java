package dms.pastor.utils;

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

    public static boolean isLetterVowelIncludingY(char letter) {
        char[] vowelsWithY = StringUtils.addCharToCharArray('y', vowels);
        for (char vowel : vowels) {
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


}

