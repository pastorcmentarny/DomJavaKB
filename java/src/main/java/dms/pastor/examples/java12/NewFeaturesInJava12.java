package dms.pastor.examples.java12;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 * Author Dominik Symonowicz
 * Created 28/04/2019
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
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
            NumberFormat shortNumberFormat = NumberFormat.getCompactNumberInstance(locale, NumberFormat.Style.SHORT);
            NumberFormat longNumberFormat = NumberFormat.getCompactNumberInstance(locale, NumberFormat.Style.LONG);
            String formattedShortNumber = shortNumberFormat.format(integer);
            String formattedLongNumber = longNumberFormat.format(integer);
            stringBuilder.append("short: ").append(formattedShortNumber).append(" long: ").append(formattedLongNumber).append("\n");
        });
        return stringBuilder.toString();
    }

    //TODO return "Dominik".transform(null);
}
