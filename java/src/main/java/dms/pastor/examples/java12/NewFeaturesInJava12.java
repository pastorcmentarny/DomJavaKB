package dms.pastor.examples.java12;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import static java.text.NumberFormat.Style.LONG;
import static java.text.NumberFormat.Style.SHORT;
import static java.text.NumberFormat.getCompactNumberInstance;

/**
 * Author: Dominik Symonowicz
 * Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
 * LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
 * GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a> * Created 28/04/2019
 */
public class NewFeaturesInJava12 {

    private NewFeaturesInJava12() {
    }

    public static String returnsClassForAnArrayType() {
        return "dominik".getClass().arrayType().toString();
    }

    public static String stringIntentMethod() {
        return "Dominik".indent(3);
    }

    public static String compactNumberFormat() {
        final Locale locale = Locale.UK;
        List<Integer> numbers = List.of(1000, 1000000);
        final var stringBuilder = new StringBuilder();
        numbers.forEach((integer) -> {
            NumberFormat shortNumberFormat = getCompactNumberInstance(locale, SHORT);
            NumberFormat longNumberFormat = getCompactNumberInstance(locale, LONG);
            String formattedShortNumber = shortNumberFormat.format(integer);
            String formattedLongNumber = longNumberFormat.format(integer);
            stringBuilder.append("short: ").append(formattedShortNumber).append(" long: ").append(formattedLongNumber).append("\n");
        });
        return stringBuilder.toString();
    }

}
