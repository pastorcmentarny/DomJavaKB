package dms.pastor.tools.readtimer;

import java.util.ArrayList;

import static dms.pastor.domain.Message.INPUT_CANNOT_BE_EMPTY;
import static dms.pastor.utils.StringUtils.hasNonAlphanumericCharactersOnly;
import static dms.pastor.utils.StringUtils.isContainSpace;
import static dms.pastor.utils.StringUtils.isStringNotEmpty;
import static java.util.Arrays.asList;

/**
 * Author Dominik Symonowicz
 * Created 22/03/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
class WordCounter {
    static int countFullWords(String[] words) {
        validateIfWordsAreNotEmpty(words);

        int counter = 0;
        ArrayList<String> allWords = new ArrayList<>(asList(words));
        for (String word : allWords) {
            if (isAWord(word)) {
                counter++;
            }
        }
        return counter;
    }

    private static void validateIfWordsAreNotEmpty(String[] words) {
        if (words == null || words.length == 0) {
            throw new IllegalArgumentException(INPUT_CANNOT_BE_EMPTY);
        }
    }

    private static boolean isAWord(String word) {
        return isStringNotEmpty(word) && !isContainSpace(word) && !hasNonAlphanumericCharactersOnly(word);
    }
}
