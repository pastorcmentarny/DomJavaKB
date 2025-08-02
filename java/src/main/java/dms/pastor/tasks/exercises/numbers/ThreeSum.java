package dms.pastor.tasks.exercises.numbers;

/**
 * Author Dominik Symonowicz
 * Created 2014-10-11 at 16.56
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
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
