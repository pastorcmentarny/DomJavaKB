package dms.pastor.tasks.romanarabicconverter;

/**
 * Author Dominik Symonowicz
 * Created 2015-06-22
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 * <p>
 * This class has method that allows you to check
 */
class RomanNumberValidator {

    public static boolean isValidRomanNumber(String romanNumber) {
        return isNotEmpty(romanNumber) && romanNumber.matches("[IVXLCDM]*");
    }

    public static boolean isNotValidRomanNumber(String romanNumber) {
        return !isValidRomanNumber(romanNumber);
    }

    public static boolean isIntCanBeRomanNumber(int arabicNumber) {
        return arabicNumber > 0 && arabicNumber < 4000;
    }

    private static boolean isNotEmpty(String romanNumber) {
        return !(romanNumber == null || romanNumber.isEmpty());
    }


}
