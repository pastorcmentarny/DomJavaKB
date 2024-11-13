package dms.pastor.tasks.romanarabicconverter;

/**
 * Author Dominik Symonowicz
 * Created 2015-06-22
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * This class has method that allows you to check
 */
final class RomanNumberValidator {

    private static final int MAX_ROMAN_NUMBER_IN_ARABIC = 4000;

    private RomanNumberValidator() {
    }

    public static boolean isValidRomanNumber(String romanNumber) {
        return isNotEmpty(romanNumber) && romanNumber.matches("[IVXLCDM]*");
    }

    public static boolean isNotValidRomanNumber(String romanNumber) {
        return !isValidRomanNumber(romanNumber);
    }

    public static boolean isIntCanBeRomanNumber(int arabicNumber) {
        return arabicNumber > 0 && arabicNumber < MAX_ROMAN_NUMBER_IN_ARABIC;
    }

    private static boolean isNotEmpty(String romanNumber) {
        return !(romanNumber == null || romanNumber.isEmpty());
    }

}
