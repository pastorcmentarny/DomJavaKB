package dms.pastor.examples;

/**
 * Author Dominik Symonowicz
 * Created 08/09/2017
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * tag-string-format
 */
public class StringFormatExamples {
    private final int width;

    public StringFormatExamples(int width) {
        this.width = width;
    }

    public String displayNumberAlignedToRightWithWidth20(int number) {
        return String.format("|%" + width + "d|", number);
    }

    public String displayNumberAlignedToLeftWithWidth20(int number) {
        return String.format("|%-" + width + "d|", number);
    }

    public String displayNumberAlignedToRightWithWidth20AndPadWithZeros(int number) {
        return String.format("|%0" + width + "d|", number); // prints: |00000000000000000093|
    }

    public String displayPlusForPositiveNumber(int number) {
        return String.format("|%+" + width + "d|", number);
    }

    public String displayNumberWithAmericanSeparator(int number) {
        return String.format("|%,d|", number);
    }

    public String displayFirstFewCharactersFor(String text, int length) {
        return String.format("|%." + length + "s|", text);

    }
}
