package dms.pastor.examples.scheduletask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Timer;

/**
 * Author: Dominik Symonowicz
 * Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
 * LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
 * GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
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
