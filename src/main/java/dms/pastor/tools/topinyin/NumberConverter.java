package dms.pastor.tools.topinyin;

import static dms.pastor.tools.topinyin.PinyinTransformer.transformToPinyin;
import static dms.pastor.utils.StringUtils.isStringBlank;
import static dms.pastor.utils.StringUtils.isStringNotEmpty;

/**
 * Author Dominik Symonowicz
 * Created 29/12/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
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
        for (String word : sentence) {
            if (isStringNotEmpty(input)) {
                CharacterWithTone characterWithTone = CharacterWithTone.fromString(word);
                outputBuilder.append(transformToPinyin(characterWithTone));
                outputBuilder.append(SPACE);
            }
        }

        String pinyin = outputBuilder.toString();

        if (pinyin.charAt(pinyin.length() - 1) == ' ') {
            pinyin = pinyin.substring(0, pinyin.length() - 1);
        }

        return pinyin;
    }

}
