package dms.pastor.examples.scheduletask;

import org.slf4j.Logger;

import java.time.LocalDate;
import java.util.TimerTask;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Author: Dominik Symonowicz
 * Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
 * LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
 * GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
class Task extends TimerTask {
    private static final Logger LOGGER = getLogger(Task.class);

    private final String name;

    public Task(String name) {
        this.name = name;
    }

    public void run() {
        LOGGER.info("{} running {} at {}.", Thread.currentThread(), this.name, LocalDate.now());
    }
}
