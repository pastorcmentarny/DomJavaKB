package dms.pastor.tasks.berlinclock;

import dms.pastor.tasks.berlinclock.data.Time;

/**
 * Author Dominik Symonowicz
 * Created 2013-07-24 at 21:15:25
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
interface ClockInterface {

    String showTime(String time);

    String getTimeAsString(int hour, int minutes, int seconds);

    Time validateTime(String time);
}
