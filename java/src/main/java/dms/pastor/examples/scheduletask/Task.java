package dms.pastor.examples.scheduletask;

import org.slf4j.Logger;

import java.time.LocalDate;
import java.util.TimerTask;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
class Task extends TimerTask {
    private static final Logger LOGGER = getLogger(Task.class);

    private final String name;

    public Task(String name) {
        this.name = name;
    }

    public void run() {
        LOGGER.info(Thread.currentThread() + " running " +
                this.name + " at " +
                LocalDate.now() + ".");
    }
}
