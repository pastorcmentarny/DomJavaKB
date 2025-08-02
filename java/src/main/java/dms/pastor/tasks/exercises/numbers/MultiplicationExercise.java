package dms.pastor.tasks.exercises.numbers;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.StringUtils.NEW_LINE;
import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
final class MultiplicationExercise {

    private MultiplicationExercise() {
    }

    static String generateMultiplicationSquareTable(int number) {
        if (number <= 0) {
            return EMPTY_STRING;
        }
        StringBuilder stringBuilder = new StringBuilder(EMPTY_STRING); //* read comment above
        for (int x = 1; x <= number; x++) {
            createRow(number, stringBuilder, x);
            stringBuilder.append(NEW_LINE);
        }
        return stringBuilder.toString();
    }

    private static void createRow(int number, StringBuilder stringBuilder, int x) {
        for (int y = 1; y <= number; y++) {
            stringBuilder.append(format("%5d", x * y));
        }
    }

}
