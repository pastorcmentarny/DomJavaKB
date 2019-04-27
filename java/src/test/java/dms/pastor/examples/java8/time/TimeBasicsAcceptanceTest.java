package dms.pastor.examples.java8.time;

import dms.pastor.ExampleRunner;
import org.junit.Test;

/**
 * Author Dominik Symonowicz
 * Created 27/04/2019
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class TimeBasicsAcceptanceTest implements ExampleRunner {

    @Test
    @Override
    public void runExamples()   {
        TimeBasics.getCurrentTimeAsString();
        TimeBasics.gettingCurrentDateTimeInJava();
        TimeBasics.displayTimeInLondonWroclawBeijing();
        TimeBasics.getCurrentTimeWithOffset();
        TimeBasics.displayAllTimeZone(false);
    }
}