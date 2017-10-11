package dms.pastor.tools.chinese.validator;

import dms.pastor.utils.string.ContainsInStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.StringUtils.isStringEmpty;
import static dms.pastor.utils.ValidatorUtils.validateIfNotNull;
import static dms.pastor.utils.string.ContainsInStringUtils.containsAnyAlphanumericCharacter;
import static dms.pastor.utils.string.ContainsInStringUtils.containsPinyinCharacter;

/**
 * Author Dominik Symonowicz
 * Created 07/10/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class WordValidator {
    private static final Logger LOGGER = LoggerFactory.getLogger(Word.class);

    public static boolean validateWord(Word word) {
        validateIfNotNull(word, "Word");

        if (word.getId() <= 0) {
            LOGGER.error("id is invalid.value:" + word.getId());
            return false;
        }

        if (word.getStrokes() < -1 || word.getStrokes() == 0) {
            LOGGER.error(generateErrorMessage(word.getId(), "Strokes", "Invalid number of strokes."));
            return false;
        }

        if (isStringEmpty(word.getChineseCharacter()) || containsAnyAlphanumericCharacter(word.getChineseCharacter()) || containsPinyinCharacter(word.getChineseCharacter())) {
            LOGGER.error(generateErrorMessage(word.getId(), "Chinese character", "It does't contain chinese character,"));
            return false;
        }

        //pinyin should be lowered case only
        if (isStringEmpty(word.getPinyin()) || ContainsInStringUtils.containsUpperCase(word.getPinyin())) {
            LOGGER.error(generateErrorMessage(word.getId(), "Pinyin", "Pinyin should not contain upper case letters."));
            return false;
        }

        if (isStringEmpty(word.getWordInEnglish()) || containsPinyinCharacter(word.getWordInEnglish())) {
            LOGGER.error(generateErrorMessage(word.getId(), "English word", "English meaning should not be empty or contain pinyin character."));
            return false;
        }

        if (Objects.isNull(word.getNotes())) {
            LOGGER.error(generateErrorMessage(word.getId(), "Notes", "Notes should not be null."));
            return false;
        }

        if (word.getGroups().length == 0) {
            LOGGER.error(generateErrorMessage(word.getId(), "Groups", "It should be assign to at least 1 group."));
            return false;
        }

        if (word.getDifficulty() > 8 || word.getDifficulty() < 1) {
            LOGGER.error(generateErrorMessage(word.getId(), "Difficulty", "value " + word.getDifficulty() + " is not in range."));
            return false;
        }

        return true;
    }

    private static String generateErrorMessage(int id, String what, String reason) {
        return String.format("%s is invalid for word id: %d. %s", what, id, getReason(reason));
    }

    private static String getReason(String reason) {
        return reason != null ? reason : EMPTY_STRING;
    }
}
