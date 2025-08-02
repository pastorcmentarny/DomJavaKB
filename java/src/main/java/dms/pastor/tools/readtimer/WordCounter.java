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
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
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

        LOGGER.debug("Words:{}\n\tAccepted: {}\n\tNot a Word: {}\n\tRejected Stop Words:{}", allWords.size(), counter, notAWord, rejectedStopWords);
        return counter;
    }

    private static boolean isAWord(String word) {
        return isStringNotEmpty(word) && !isContainSpace(word) && !hasNonAlphanumericCharactersOnly(word);
    }
}
