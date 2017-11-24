package dms.pastor.tasks.exercises.numbers;

import static dms.pastor.utils.StringUtils.NEW_LINE;
import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
final class MultiplicationExercise {

    private MultiplicationExercise() {
    }

    /*
    new StringBuilder(String.valueOf(NEW_LINE)) looks weird?
    well..
     as it turns out char is cast to int by stringBuilder
     int in constructor is treated as ... initial capacity which is not what i want.
     */
    static String generateMultiplicationSquareTable(int number) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(NEW_LINE)); //* read comment above
        for (int x = 1; x <= number; x++) {
            createRow(number, stringBuilder, x);
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }

    private static void createRow(int number, StringBuilder stringBuilder, int x) {
        for (int y = 1; y <= number; y++) {
            stringBuilder.append(format("%5d", x * y));
        }
    }

}
