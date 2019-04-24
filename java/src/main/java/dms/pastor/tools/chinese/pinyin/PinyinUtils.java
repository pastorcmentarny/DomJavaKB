package dms.pastor.tools.chinese.pinyin;

import static dms.pastor.tools.chinese.pinyin.PinyinConstants.*;

/**
 * Author Dominik Symonowicz
 * Created 08/10/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class PinyinUtils {

    private PinyinUtils() {
    }

    public static String getAllPinyinFromFirstToFourthToneWithoutNeutralTone() {
        return A_FIRST_NOTE + A_SECOND_TONE + A_THIRD_TONE + A_FOURTH_TONE +
            E_FIRST_NOTE + E_SECOND_TONE + E_THIRD_TONE + E_FOURTH_TONE +
            O_FIRST_NOTE + O_SECOND_TONE + O_THIRD_TONE + O_FOURTH_TONE +
            I_FIRST_NOTE + I_SECOND_TONE + I_THIRD_TONE + I_FOURTH_TONE +
            U_FIRST_NOTE + U_SECOND_TONE + U_THIRD_TONE + U_FOURTH_TONE;
    }
}
