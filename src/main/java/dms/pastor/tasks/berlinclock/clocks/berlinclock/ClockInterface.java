package dms.pastor.tasks.berlinclock.clocks.berlinclock;

import dms.pastor.tasks.berlinclock.data.Time;

/**
 * @author Pastor
 *         Created 2013-07-24 at 21:15:25
 */
interface ClockInterface {

    /**
     * @param time as String in format hh::mm:ss
     * @return String representation of the Berlin Clock for a given time
     */
    String showTime(String time);

    String getTimeAsString(int hour, int minutes, int seconds);

    Time validateTime(String time);
}
