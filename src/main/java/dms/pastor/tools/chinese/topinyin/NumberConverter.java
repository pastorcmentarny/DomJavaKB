package dms.pastor.tools.chinese.topinyin;

import static dms.pastor.tools.chinese.topinyin.PinyinTransformer.transformToPinyin;
import static dms.pastor.utils.StringUtils.*;

/**
 * Author Dominik Symonowicz
 * Created 29/12/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class NumberConverter implements Converter {

    private static final String SPACE = " ";
    private static final String EMPTY_STRING = "";

    @Override
    public String convertToPinyin(String input) {
        if (isStringBlank(input)) {
            return EMPTY_STRING;
        }

        String[] sentence = input.split(SPACE);

        StringBuilder outputBuilder = new StringBuilder(EMPTY_STRING);

        transformWordsInSentenceToPinyin(input, sentence, outputBuilder);

        String pinyin = outputBuilder.toString();

        return removeWhitespaceIfExistsInLastElement(pinyin);
    }

    private void transformWordsInSentenceToPinyin(String input, String[] sentence, StringBuilder outputBuilder) {
        for (String word : sentence) {
            transformWordToPinyin(input, outputBuilder, word);
        }
    }

    private void transformWordToPinyin(String input, StringBuilder outputBuilder, String word) {
        if (isStringNotEmpty(input)) {
            CharacterWithTone characterWithTone = CharacterWithTone.fromString(word);
            outputBuilder.append(transformToPinyin(characterWithTone));
            outputBuilder.append(SPACE);
        }
    }

    private String removeWhitespaceIfExistsInLastElement(String pinyin) {
        if (pinyin.charAt(pinyin.length() - 1) == WHITESPACE_CHAR) {
            pinyin = pinyin.substring(0, pinyin.length() - 1);
        }
        return pinyin;
    }

}
