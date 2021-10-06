package dms.pastor.tools.chinese.pinyin;

import static dms.pastor.tools.chinese.pinyin.PinyinConstants.*;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;

/**
 * Author Dominik Symonowicz
 * Created 08/01/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public enum PinyinTable {
    A(A_NEUTRAL, A_FIRST_NOTE, A_SECOND_TONE, A_THIRD_TONE, A_FOURTH_TONE),
    E(E_NEUTRAL, E_FIRST_NOTE, E_SECOND_TONE, E_THIRD_TONE, E_FOURTH_TONE),
    O(O_NEUTRAL, O_FIRST_NOTE, O_SECOND_TONE, O_THIRD_TONE, O_FOURTH_TONE),
    I(I_NEUTRAL, I_FIRST_NOTE, I_SECOND_TONE, I_THIRD_TONE, I_FOURTH_TONE),
    U(U_NEUTRAL, U_FIRST_NOTE, U_SECOND_TONE, U_THIRD_TONE, U_FOURTH_TONE);

    private final String neutralTone;
    private final String firstTone;
    private final String secondTone;
    private final String thirdTone;
    private final String fourthTone;

    PinyinTable(String neutralTone, String firstTone, String secondTone, String thirdTone, String fourthTone) {
        this.neutralTone = neutralTone;
        this.firstTone = firstTone;
        this.secondTone = secondTone;
        this.thirdTone = thirdTone;
        this.fourthTone = fourthTone;
    }

    public static String getPinyinCharacterFromLetterWithTone(char letter, int tone) {
        return getPinyinCharacterFromLetterWithTone(Character.toString(letter), tone);
    }

    public static String getPinyinCharacterFromLetterWithTone(String letter, int tone) {
        for (PinyinTable value : PinyinTable.values()) {
            if (value.name().equalsIgnoreCase(letter)) {
                return getPinyinCharacterFor(value, tone);
            }
        }
        return EMPTY_STRING;
    }

    private static String getPinyinCharacterFor(PinyinTable value, int tone) {
        return switch (tone) {
            case 0 -> value.getNeutralTone();
            case 1 -> value.getFirstTone();
            case 2 -> value.getSecondTone();
            case 3 -> value.getThirdTone();
            case 4 -> value.getFourthTone();
            default -> throw new IllegalArgumentException("Wrong tone. There are only 4 tones in mandarin(and no tone)");
        };
    }

    private String getNeutralTone() {
        return neutralTone;
    }

    private String getFirstTone() {
        return firstTone;
    }

    private String getSecondTone() {
        return secondTone;
    }

    private String getThirdTone() {
        return thirdTone;
    }

    private String getFourthTone() {
        return fourthTone;
    }
}
