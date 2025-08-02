package dms.pastor.examples.java8.interfaces.defaultmethod;

/**
 * Author: Dominik Symonowicz
 * Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
 * LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
 * GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 * Created 27/04/2019
 */
public class CubicFormula implements Formula {

    public double calculate(final int number) {
        return sqrt(number) * number;

    }
}
