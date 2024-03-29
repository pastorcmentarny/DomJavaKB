package dms.pastor.examples.scheduletask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Timer;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
final class ScheduleTaskExampleRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleTaskExampleRunner.class);

    private ScheduleTaskExampleRunner() {
    }

    public static void runScheduleTaskExample(String name) throws InterruptedException {
        LOGGER.debug("Running ScheduleTask Example");
        Timer timer = new Timer();
        timer.schedule(new Task(name), 100, 100);
        Thread.sleep(1000);
        LOGGER.debug("End of ScheduleTask Example");
        timer.cancel();

    }
}
