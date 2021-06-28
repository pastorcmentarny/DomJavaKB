package dms.pastor.tools.trips.overground;

import dms.pastor.tools.trips.common.options.OptionsFactory;
import dms.pastor.tools.trips.common.station.Stations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

import static dms.pastor.tools.trips.common.station.StationType.OVERGROUND;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
class OvergroundCLI {
    private static final Logger LOGGER = LoggerFactory.getLogger(OvergroundCLI.class);
    private static final String INVALID_CHOICE_MESSAGE = "Invalid choice. Try again";

    static {
        new Scanner(System.in);
    }

    private final Stations stations;
    private final OptionsFactory options;
    private final Scanner scanner;


    OvergroundCLI(Stations stations, Scanner scanner) {
        this.stations = stations;
        this.scanner = scanner;
        options = OptionsFactory.getOvergroundOptions(scanner);
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
                    options.selectOption(option, stations, OVERGROUND);

                }
            } catch (RuntimeException e) {
                System.out.println(INVALID_CHOICE_MESSAGE);
                LOGGER.warn("User typed gibberish." + e.getMessage(), e);
                scanner.next();
            }
        }
    }

}
