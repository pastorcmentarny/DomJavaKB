package dms.pastor.tasks.exercises.numbers;

import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
class MultiplicationExercise {

    private MultiplicationExercise() {
    }

    static String generateMultiplicationSquareTable(int number) {
        StringBuilder stringBuilder = new StringBuilder("");
        for (int x = 1; x <= number; x++) {
            for (int y = 1; y <= number; y++) {
                stringBuilder.append(format("%5d", x * y));
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }

}
