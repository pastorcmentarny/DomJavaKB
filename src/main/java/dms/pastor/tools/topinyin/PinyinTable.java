package dms.pastor.tools.topinyin;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;

/**
 * Author Dominik Symonowicz
 * Created 08/01/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public enum PinyinTable {
    A("a", "ā", "á", "ǎ", "à"),
    E("e", "ē", "é", "ě", "è"),
    O("o", "ō", "ó", "ǒ", "ò"),
    I("i", "ī", "í", "ǐ", "ì"),
    U("u", "ū", "ú", "ǔ", "ù");

    private final String neutralTone;
    private final String firstTone;
    private final String secondTone;
    private final String thirdTone;
    private final String fourthTone;

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
        switch (tone) {
            case 0:
                return value.getNeutralTone();
            case 1:
                return value.getFirstTone();
            case 2:
                return value.getSecondTone();
            case 3:
                return value.getThirdTone();
            case 4:
                return value.getFourthTone();
            default:
                throw new IllegalArgumentException("Wrong tone. There are only 4 tones in mandarin(and no tone)");
        }
    }
}
