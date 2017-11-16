package dms.pastor.tools.tube;

import dms.pastor.domain.exception.NotFoundException;
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
            System.out.println("8. Display list of all stations.");
            System.out.println("9. Exit.");
            try {
                final int option = scanner.nextInt();
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

    private void updateStationStatusToVisited() {
        final String option = scanner.next();
        LOGGER.debug(String.format("Updating status to visited for %s", option));
        try {
            final Station station = stations.findStation(option);
            stations.setVisitedFor(station);
            final Station updatedStation = stations.findStation(station.getName());
            System.out.println("You set " + updatedStation.getName() + " status to " + updatedStation.getStatus().asName() + ".");
        } catch (NotFoundException nfe) {
            System.out.println("Station " + option + " not found.");
        }
    }

    private void updateStationStatusToPassed() {
        final String option = scanner.next();
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

    public void displayStatistic() {
        System.out.println("You visited " + stations.countStationVisited() + " station(s).");
        System.out.print("It is a " + stations.countStationVisited() / stations.getStationList().size());
        System.out.println("You passed " + stations.countStationPassed() + " station(s).");
        displayWarningIfTotalStationNumberIsWrong();
    }

    private void displayWarningIfTotalStationNumberIsWrong() {
        final int totalNumber = 269; //it is 270 as there are 2 Edgware road stations
        if (stations.totalNumber() != totalNumber) {
            System.out.println("WARNING! Total number should be " + totalNumber + " but file contains only " + stations.totalNumber());
        }
    }
}
