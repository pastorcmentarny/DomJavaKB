package dms.pastor.learn.basics;

/**
 * Author Dominik Symonowicz
 * Created 08/09/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * tag-string-format
 */
class StringFormatExamples {
    private final int width;

    StringFormatExamples(int width) {
        this.width = width;
    }


    String displayNumberAlignedToRightWithWidth20(int number) {
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

    //TODO improve name
    public String displayTextOfLength(String text, int length) {
        return String.format("|%." + length + "s|", text);

    }
}
