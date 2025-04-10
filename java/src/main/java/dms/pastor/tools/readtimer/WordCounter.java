package dms.pastor.tools.readtimer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import static dms.pastor.utils.EnglishUtils.isNotStopWord;
import static dms.pastor.utils.StringUtils.hasNonAlphanumericCharactersOnly;
import static dms.pastor.utils.StringUtils.isStringNotEmpty;
import static dms.pastor.utils.ValidatorUtils.validateIfStringArrayIsNotEmpty;
import static dms.pastor.utils.string.ContainsInStringUtils.isContainSpace;
import static java.util.Arrays.asList;

/**
 * Author Dominik Symonowicz
 * Created 22/03/2017
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
final class WordCounter {

    private static final Logger LOGGER = LoggerFactory.getLogger(WordCounter.class);

    private WordCounter() {
    }

    static int countFullWords(String[] words) {
        validateIfStringArrayIsNotEmpty(words);

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

    private static boolean isAWord(String word) {
        return isStringNotEmpty(word) && !isContainSpace(word) && !hasNonAlphanumericCharactersOnly(word);
    }
}
