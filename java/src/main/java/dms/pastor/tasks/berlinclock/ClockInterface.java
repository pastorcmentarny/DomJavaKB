package dms.pastor.tasks.berlinclock;

import dms.pastor.tasks.berlinclock.data.Time;

/**
 * Author Dominik Symonowicz
 * Created 2013-07-24 at 21:15:25
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
interface ClockInterface {

    String showTime(String time);

    String getTimeAsString(int hour, int minutes, int seconds);

    Time validateTime(String time);
}
