package dms.pastor.utils.string;

import dms.pastor.tools.chinese.pinyin.PinyinUtils;

import java.util.List;

import static dms.pastor.utils.StringUtils.*;
import static dms.pastor.utils.ValidatorUtils.validateIfListIsNotEmpty;
import static dms.pastor.utils.ValidatorUtils.validateIfNotEmpty;

/**
 * Author Dominik Symonowicz
 * Created 08/10/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ContainsInStringUtils {

    public static boolean containsOnly(String text, char[] characters) {
        if (isStringBlank(text) || characters == null || characters.length == 0) {
            return false;
        }

        char[] textArray = text.toCharArray();
        for (char characterFromArray : textArray) {
            boolean characterFound = false;
            for (char character : characters) {
                if (characterFromArray == character) {
                    characterFound = true;
                }
            }
            if (!characterFound) {
                return false;
            }
        }
        return true;
    }

    public static boolean isContainSpace(String word) {
        if (isStringEmpty(word)) {
            return false;
        }

        final char[] chars = word.toCharArray();
        for (char character : chars) {
            if (isNotWhitespaceCharacter(character)) {
                return false;
            }
        }
        return true;
    }

    public static boolean containsAnyAlphanumericCharacter(String string) {
        if (isStringEmpty(string)) {
            return false;
        }
        char[] charArray = string.toCharArray();
        for (char character : charArray) {
            for (char letterOrNumber : ALPHANUMERIC.toCharArray()) {
                if (character == letterOrNumber) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isTextContainsAllKeywordsExists(List<String> keywords, String text) {
        validateIfListIsNotEmpty(keywords, "Keywords");
        validateIfNotEmpty(text, "text");
        return keywords.stream().anyMatch(text::contains);
    }

    public static boolean containsPinyinCharacter(String word) {
        if (isStringEmpty(word)) {
            return false;
        }

        final char[] chars = word.toCharArray();
        for (char character : chars) {
            if (PinyinUtils.getAllPinyinFromFirstToFourthToneWithoutNeutralTone().contains(String.valueOf(character))) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsUpperCase(String word) {
        if (isStringEmpty(word)) {
            return false;
        }

        final char[] chars = word.toCharArray();
        for (char character : chars) {
            if (Character.isUpperCase(character)) {
                return true;
            }
        }
        return false;
    }
}
