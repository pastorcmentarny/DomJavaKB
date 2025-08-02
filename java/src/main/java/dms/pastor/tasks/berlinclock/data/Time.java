package dms.pastor.tasks.berlinclock.data;

/**
 * Author: Dominik Symonowicz
 * Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
 * LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
 * GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 * Created 2013-07-24 at 21:36:16
 */

public record Time(int hours, int minutes, int seconds) {

    @Override
    public String toString() {
        return  String.format("%02d", hours) + ':' + String.format("%02d", minutes) + ':' + String.format("%02d", seconds);
    }
}
