package dms.pastor.tools.chinese.validator;

import dms.pastor.utils.string.ContainsInStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.StringUtils.isStringEmpty;
import static dms.pastor.utils.ValidatorUtils.validateIfObjectValueIsNotNull;
import static dms.pastor.utils.string.ContainsInStringUtils.containsAnyAlphanumericCharacter;
import static dms.pastor.utils.string.ContainsInStringUtils.containsPinyinCharacter;
import static java.util.Objects.isNull;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
final class WordValidator {
    private static final Logger LOGGER = LoggerFactory.getLogger(Word.class);
    private static final List<String> allowedChineseWordsWithEnglishCharactersList = List.of("T恤", "Java 开发人员");

    private WordValidator() {
    }

    static boolean isWordValid(Word word) {
        validateIfObjectValueIsNotNull(word, "Word");

        if (word.getId() <= 0) {
            LOGGER.error("id is invalid.value:" + word.getId());
            return false;
        }

        if (isNotValidStroke(word)) {
            LOGGER.error(generateErrorMessage(word.getId(), "Strokes", "Invalid number of strokes."));
            return false;
        }

        if (isNotValidChineseCharacter(word)) {
            if (isStringEmpty(word.getChineseCharacter()) || isContainsAllowedWords(word.getChineseCharacter())) {
                LOGGER.error(generateErrorMessage(word.getId(), "Chinese character", "It does't contain chinese character,"));
                return false;
            }
        }

        if (isNotValidPinyin(word)) {
            LOGGER.error(generateErrorMessage(word.getId(), "Pinyin", "Pinyin should not contain upper case letters."));
            return false;
        }

        if (isNotValidEnglishWord(word)) {
            LOGGER.error(generateErrorMessage(word.getId(), "English word", "English meaning should not be empty or contain pinyin character."));
            return false;
        }

        if (isNull(word.getNotes())) {
            LOGGER.error(generateErrorMessage(word.getId(), "Notes", "Notes should not be null."));
            return false;
        }

        if (word.getGroups().length == 0) {
            LOGGER.error(generateErrorMessage(word.getId(), "Groups", "It should be assign to at least 1 group."));
            return false;
        }

        if (isNotInRange(word)) {
            LOGGER.error(generateErrorMessage(word.getId(), "Difficulty", "value " + word.getDifficulty() + " is not in range."));
            return false;
        }

        return true;
    }

    private static boolean isContainsAllowedWords(String word) {

        for (String allowedWord : allowedChineseWordsWithEnglishCharactersList) {
            if (allowedWord.equalsIgnoreCase(word)) {
                return false;
            }
        }

        return true;

    }

    private static boolean isNotValidChineseCharacter(Word word) {
        return isStringEmpty(word.getChineseCharacter()) || containsAnyAlphanumericCharacter(word.getChineseCharacter()) || containsPinyinCharacter(word.getChineseCharacter());
    }

    private static boolean isNotValidStroke(Word word) {
        return word.getStrokes() < -1 || word.getStrokes() == 0;
    }

    //pinyin should be lowered case only
    private static boolean isNotValidPinyin(Word word) {
        return isStringEmpty(word.getPinyin()) || ContainsInStringUtils.containsUpperCase(word.getPinyin());
    }

    private static boolean isNotValidEnglishWord(Word word) {
        return isStringEmpty(word.getWordInEnglish()) || containsPinyinCharacter(word.getWordInEnglish());
    }

    private static boolean isNotInRange(Word word) {
        return word.getDifficulty() > 8 || word.getDifficulty() < 1;
    }

    private static String generateErrorMessage(int id, String what, String reason) {
        return String.format("%s is invalid for word id: %d. %s", what, id, getReason(reason));
    }

    private static String getReason(String reason) {
        return reason != null ? reason : EMPTY_STRING;
    }
}
