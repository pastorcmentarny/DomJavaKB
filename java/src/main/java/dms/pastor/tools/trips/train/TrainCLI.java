package dms.pastor.tools.trips.train;

import dms.pastor.tools.trips.train.options.OptionsFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * Author Dominik Symonowicz
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
class TrainCLI {
    private static final Logger LOGGER = LoggerFactory.getLogger(TrainCLI.class);
    private static final String INVALID_CHOICE_MESSAGE = "Invalid choice. Try again";

    static {
        new Scanner(System.in);
    }

    private final OptionsFactory options;
    private final Scanner scanner;


    public TrainCLI(Scanner scanner) {
        this.scanner = scanner;
        options = OptionsFactory.getOptions();
    }

    void mainMenu() {
        boolean showMenu = true;
        while (showMenu) {
            options.displayAllAvailable();
            try {
                final int option = scanner.nextInt();
                scanner.nextLine();
                if (option == 9) {
                    showMenu = false;
                    scanner.close();
                } // else  options.selectOption(option, stations);
            } catch (RuntimeException e) {
                System.out.println(INVALID_CHOICE_MESSAGE);
                LOGGER.warn("User typed gibberish.{}", e.getMessage(), e);
                scanner.next();
            }
        }
    }

}
