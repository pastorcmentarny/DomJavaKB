package dms.pastor.examples.java11;

import static dms.pastor.utils.html.HtmlUtils.HTML_SPACE;

/**
 * Author Dominik Symonowicz
 * Created 29/04/2019
 * WWW:	https://dominiksymonowicz.com/
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class StringNews {

    public static String stringRepeatMethod() {
        return HTML_SPACE.repeat(3);
    }

    public static boolean stringIsBlankMethod() {
        return " ".isBlank();
    }

    public static String stringStripMethod() {
        return "  Dominik  ".strip();
    }

    public static long stringLinesMethod() {
        var sentence = "Dom" + System.lineSeparator() + "is" + System.lineSeparator() + "hungry";
        return sentence.lines().count();
    }
}
