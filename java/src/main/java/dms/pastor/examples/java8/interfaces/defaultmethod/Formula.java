package dms.pastor.examples.java8.interfaces.defaultmethod;

/**
 * Author: Dominik Symonowicz
 * Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
 * LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
 * GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 * Created 27/04/2019
 */
interface Formula {

    default double sqrt(int number) {
        return Math.sqrt(number);
    }
}