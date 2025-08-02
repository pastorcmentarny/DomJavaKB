package dms.pastor.tasks.fifinder;

/**
 * Author: Dominik Symonowicz
 * Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
 * LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
 * GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a> * Created 31/10/2016
 */

record Name(String first, String middles, String last) {

    @Override
    public String toString() {
        return "Name{first='%s', middles='%s', last='%s'}".formatted(first, middles, last);
    }
}
