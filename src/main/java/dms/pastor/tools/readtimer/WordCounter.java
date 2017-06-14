package dms.pastor.tools.readtimer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import static dms.pastor.domain.Message.INPUT_CANNOT_BE_EMPTY;
import static dms.pastor.utils.EnglishUtils.isNotStopWord;
import static dms.pastor.utils.StringUtils.*;
import static java.util.Arrays.asList;

/**
 * Author Dominik Symonowicz
 * Created 22/03/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
class WordCounter {
    private static final Logger LOGGER = LoggerFactory.getLogger(WordCounter.class);

    static int countFullWords(String[] words) {
        validateIfWordsAreNotEmpty(words);

        int counter = 0;
        int rejectedStopWords = 0;
        int notAWord = 0;
        ArrayList<String> allWords = new ArrayList<>(asList(words));
        for (String word : allWords) {
            if (isAWord(word)) {
                if (isNotStopWord(word)) {
                    counter++;
                } else {
                    rejectedStopWords++;
                }
            } else {
                notAWord++;
            }
        }

        LOGGER.debug("Words:" + allWords.size() +
                "\n\tAccepted: " + counter +
                "\n\tNot a Word: " + notAWord +
                "\n\tRejected Stop Words:" + rejectedStopWords);
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
