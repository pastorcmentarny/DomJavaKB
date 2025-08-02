package dms.pastor.examples.java11;

import static dms.pastor.utils.html.HtmlUtils.HTML_SPACE;

/**
 * Author: Dominik Symonowicz
 * Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
 * LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
 * GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 * Created 29/04/2019
 */
public class StringNews {

    public static String stringRepeatMethod() {
        return HTML_SPACE.repeat(3);
    }

    @SuppressWarnings("ConstantValue") //this is an example only
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
