package dms.pastor.tools.trips.tube;

import dms.pastor.tools.trips.common.options.OptionsFactory;
import dms.pastor.tools.trips.common.station.Stations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

import static dms.pastor.tools.trips.common.station.StationType.TUBE;

/**
 * Author Dominik Symonowicz
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
class TubeCLI {
    private static final Logger LOGGER = LoggerFactory.getLogger(TubeCLI.class);
    private static final String INVALID_CHOICE_MESSAGE = "Invalid choice. Try again";

    static {
        new Scanner(System.in);
    }

    private final Stations stations;
    private final OptionsFactory options;
    private final Scanner scanner;


    TubeCLI(Stations stations, Scanner scanner) {
        this.stations = stations;
        this.scanner = scanner;
        options = OptionsFactory.getUndergroundOptions(scanner);
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
                } else {
                    options.selectOption(option, stations, TUBE);

                }
            } catch (RuntimeException exception) {
                System.out.println(INVALID_CHOICE_MESSAGE);
                LOGGER.warn("User typed gibberish.{}", exception.getMessage(), exception);
                scanner.next();
            }
        }
    }

}
