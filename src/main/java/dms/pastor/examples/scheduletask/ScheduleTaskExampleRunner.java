package dms.pastor.examples.scheduletask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Timer;

/**
 * Author Dominik Symonowicz
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class ScheduleTaskExampleRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleTaskExampleRunner.class);

    public static void runScheduleTaskExample(String name) throws InterruptedException {
        LOGGER.debug("Running ScheduleTask Example");
        Timer timer = new Timer();
        timer.schedule(new Task(name), 50, 100);
        Thread.sleep(1000);
        LOGGER.debug("End of ScheduleTask Example");
        timer.cancel();

    }
}
