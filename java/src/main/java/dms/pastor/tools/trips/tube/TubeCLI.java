package dms.pastor.tools.trips.tube;

import dms.pastor.tools.trips.tube.options.OptionsFactory;
import dms.pastor.tools.trips.tube.station.Stations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
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
        options = OptionsFactory.getOptions(scanner);
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
                    options.selectOption(option, stations);

                }
            } catch (RuntimeException e) {
                System.out.println(INVALID_CHOICE_MESSAGE);
                LOGGER.warn("User typed gibberish." + e.getMessage(), e);
                scanner.next();
            }
        }
    }

}
