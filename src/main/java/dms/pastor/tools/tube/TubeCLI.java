package dms.pastor.tools.tube;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

class TubeCLI {
    private static final Logger LOGGER = LoggerFactory.getLogger(TubeCLI.class);
    private static final String INVALID_CHOICE_MESSAGE = "Invalid choice. Try again";

    private final Stations stations;
    private Scanner scanner = new Scanner(System.in);


    public TubeCLI(Stations stations, Scanner scanner) {
        this.stations = stations;
        this.scanner = scanner;
    }

    public void main() {
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("0. Stats.");
            System.out.println("1. Current Status for all station.");
            System.out.println("2. Current Status for selected station.");
            System.out.println("3. Update Status to Passed for station.");
            System.out.println("4. Update Status to Visited for station.");
            System.out.println("9. Exit.");
            try {
                final int option = scanner.nextInt();
                switch (option) {
                    case 0:
                        displayStatistic();
                        break;
                    case 1:
                        stations.getStationList().forEach(System.out::println);
                        break;
                    case 9:
                        showMenu = false;
                        break;
                    default:
                        System.out.println(INVALID_CHOICE_MESSAGE);
                }
            } catch (RuntimeException e) {
                System.out.println(INVALID_CHOICE_MESSAGE);
                LOGGER.warn("User typed gibberish." + e.getMessage(), e);
            }
        }

    }

    public void displayStatistic() {
        System.out.println("You visited " + stations.countStationVisited() + " station(s).");
        System.out.println("You passed " + stations.countStationPassed() + " station(s).");
    }
}
