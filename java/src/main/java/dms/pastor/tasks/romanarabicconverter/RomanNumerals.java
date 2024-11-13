package dms.pastor.tasks.romanarabicconverter;

/**
 * Author Dominik Symonowicz
 * Created 2015-06-22
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public enum RomanNumerals {
    I('I', 1),
    V('V', 5),
    X('X', 10),
    L('L', 50),
    C('C', 100),
    D('D', 500),
    M('M', 1000);

    private final char roman;
    private final int arabic;

    RomanNumerals(char roman, int arabic) {
        this.roman = roman;
        this.arabic = arabic;
    }

    public static int getArabicForRoman(char roman) {
        for (RomanNumerals numeral : RomanNumerals.values()) {
            if (numeral.roman == roman) {
                return numeral.arabic;
            }
        }
        throw new IllegalArgumentException(String.format("%s is not a valid roman character", roman));
    }

    public char roman() {
        return roman;
    }

    public int arabic() {
        return arabic;
    }
}
