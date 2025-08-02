package dms.pastor.tools.trips.common.options;

import dms.pastor.domain.exception.NotFoundException;
import dms.pastor.tools.trips.common.station.Station;
import dms.pastor.tools.trips.common.station.StationType;
import dms.pastor.tools.trips.common.station.Stations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * Author Dominik Symonowicz
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 * <p>
 * tag-command-pattern
 * <p>
 */
public class DisplayStatusForSelectedStationOption implements Option {
    private static final Logger LOGGER = LoggerFactory.getLogger(DisplayStatusForSelectedStationOption.class);
    private final Scanner scanner;

    DisplayStatusForSelectedStationOption(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void choose(Stations stations, StationType type) {
        System.out.println("Select station");
        final String option = scanner.next();
        LOGGER.debug("Displaying info for {}", option);
        try {
            final Station station = stations.findStation(option);
            System.out.println(station.asFormattedString());
        } catch (NotFoundException nfe) {
            System.out.println("Station " + option + " not found.");
        }

    }

    @Override
    public String getCommandTitle(int commandCode) {
        return commandCode + ". Current Status for selected station.";
    }
}
