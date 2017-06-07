package dms.pastor.tools.chinese.topinyin;

import static dms.pastor.utils.EnglishUtils.isLetterVowelExcludingY;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;

/**
 * Author Dominik Symonowicz
 * Created 07/04/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
class PinyinTransformer {

    public static String transformToPinyin(CharacterWithTone word) {
        StringBuilder stringBuilder = new StringBuilder(EMPTY_STRING);
        if (word == null) {
            return EMPTY_STRING;
        }

        for (char character : word.getWord().toCharArray()) {
            if (isLetterVowelExcludingY(character)) {
                stringBuilder.append(PinyinTable.getPinyinCharacterFromLetterWithTone(character, word.getTone()));
            } else {
                stringBuilder.append(character);
            }
        }
        return stringBuilder.toString();
    }

}
