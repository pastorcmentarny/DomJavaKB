package dms.pastor.exercises.numbers;

import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
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
