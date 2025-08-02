package dms.pastor.tasks.paint;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * Author Dominik Symonowicz
 * Created 13/07/2017
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
final class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    private static final String STARTING_APPLICATION_MESSAGE = "Starting application ...";
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Main().application();
    }

    void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    void application() {
        System.out.println(STARTING_APPLICATION_MESSAGE);
        LOGGER.info(STARTING_APPLICATION_MESSAGE);
        CommandLineUI ui = new CommandLineUI(scanner);
        ui.runApplication();
        System.out.println("Application will be terminated! Have a nice day!");
    }
}
