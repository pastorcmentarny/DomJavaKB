package dms.pastor.tasks.exercises.numbers;

/**
 * Author Dominik Symonowicz
 * Created 2014-10-11 at 16.56
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * Counts how many triples sum gives zero.
 */
class ThreeSum {

    int brutalForceCounter(int[] values) {
        int counter = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1; j < values.length; j++) {
                for (int k = j + 1; k < values.length; k++) {
                    if (values[i] + values[j] + values[k] == 0) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

}
