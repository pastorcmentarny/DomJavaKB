package dms.pastor.tools.tube;

import dms.pastor.domain.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

import static dms.pastor.tools.tube.DataOperations.*;

class TubeCLI {
    private static final Logger LOGGER = LoggerFactory.getLogger(TubeCLI.class);
    private static final String INVALID_CHOICE_MESSAGE = "Invalid choice. Try again";

    private Stations stations;
    private Scanner scanner = new Scanner(System.in);


    public TubeCLI(Stations stations, Scanner scanner) {
        this.stations = stations;
        this.scanner = scanner;
    }

    public void main() {
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("0. Stats");
            System.out.println("1. Current Status for all station");
            System.out.println("2. Current Status for selected station");
            System.out.println("3. Update Status to Passed for station");
            System.out.println("4. Update Status to Visited for station");
            System.out.println("6. Save changes (with Backup)");
            System.out.println("7. Discard unsaved changes");
            System.out.println("8. Display list of all stations");
            System.out.println("9. Exit");
            try {
                final int option = scanner.nextInt();
                scanner.nextLine();
                switch (option) {
                    case 0:
                        displayStatistic();
                        break;
                    case 1:
                        displayStatusForAllStations();
                        break;
                    case 2:
                        displayStatusFor();
                        break;
                    case 3:
                        updateStationStatusToPassed();
                        break;
                    case 4:
                        updateStationStatusToVisited();
                        break;
                    case 6:
                        save();
                        break;
                    case 7:
                        reset();
                        break;
                    case 8:
                        stations.getStationList().forEach(station -> System.out.println(station.getName()));
                        break;
                    case 9:
                        showMenu = false;
                        break;
                    default:
                        System.out.println(INVALID_CHOICE_MESSAGE);
                        break;
                }
            } catch (RuntimeException e) {
                System.out.println(INVALID_CHOICE_MESSAGE);
                LOGGER.warn("User typed gibberish." + e.getMessage(), e);
                scanner.next();
            }
        }
    }

    private void save() {
        backup();
        saveToFile(stations.getStationList());
    }

    private void reset() {
        System.out.println("Reload data without saving.. All changes in the session will be discarded");
        loadFromFile();
    }

    private void updateStationStatusToVisited() {
        System.out.println("What station did you visit?");

        final String option = scanner.nextLine();
        LOGGER.debug(String.format("Updating status to visited for %s", option));
        try {
            final Station station = stations.findStation(option);
            stations.setVisitedFor(station);
            final Station updatedStation = stations.findStation(station.getName());
            System.out.println("You set " + updatedStation.getName() + " status to " + updatedStation.getStatus().asName() + ".");
        } catch (NotFoundException nfe) {
            System.out.println("Station " + option + " not found.");
            scanner.next();
        }
    }

    private void updateStationStatusToPassed() {
        System.out.println("What station did you passed?");

        final String option = scanner.nextLine();
        LOGGER.debug(String.format("Updating status to passed for %s", option));
        try {
            final Station station = stations.findStation(option);
            stations.setPassedFor(station);
            final Station updatedStation = stations.findStation(station.getName());
            System.out.println("You set " + updatedStation.getName() + " status to " + updatedStation.getStatus().asName() + ".");
        } catch (NotFoundException nfe) {
            System.out.println("Station " + option + " not found.");
        }
    }

    private void displayStatusFor() {
        final String option = scanner.next();
        LOGGER.debug(String.format("Displaying info for %s", option));
        try {
            final Station station = stations.findStation(option);
            System.out.println(station.asFormattedString());
        } catch (NotFoundException nfe) {
            System.out.println("Station " + option + " not found.");
        }
    }

    private void displayStatusForAllStations() {
        stations.getStationList().stream()
                .map(Station::asFormattedString)
                .forEach(System.out::println);
    }

    private void displayStatistic() {
        System.out.println("You visited " + stations.countStationVisited() + " station(s). (" +
                countPercentageOfAllStationFor(stations.countStationVisited()));
        System.out.println("You passed " + stations.countStationPassed() + " station(s). (" +
                countPercentageOfAllStationFor(stations.countStationPassed()));

        //TODO how many station blog about it
        //TODO i am ahead or behind posting stations

        displayWarningIfTotalStationNumberIsWrong();
    }

    private String countPercentageOfAllStationFor(long what) {
        return (what * 100 / stations.getStationList().size()) + "%)";
    }

    private void displayWarningIfTotalStationNumberIsWrong() {
        final int totalNumber = 269; //it is 270 as there are 2 Edgware road stations
        if (stations.totalNumber() != totalNumber) {
            System.out.println("WARNING! Total number should be " + totalNumber + " but file contains only " + stations.totalNumber());
        }
    }
}
