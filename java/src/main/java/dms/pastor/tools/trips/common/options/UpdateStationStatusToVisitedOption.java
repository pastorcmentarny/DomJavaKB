package dms.pastor.tools.trips.common.options;

import dms.pastor.tools.trips.common.station.StationType;
import dms.pastor.tools.trips.common.station.StationUpdater;
import dms.pastor.tools.trips.common.station.Stations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

import static dms.pastor.tools.trips.common.station.Action.VISITED;

/**
 * Author Dominik Symonowicz
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 * <p>
 * tag-command-pattern
 * <p>
 */
public class UpdateStationStatusToVisitedOption implements Option {
    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateStationStatusToVisitedOption.class);
    private final Scanner scanner;

    UpdateStationStatusToVisitedOption(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void choose(Stations stations, StationType type) {
        System.out.println("What station did you visit?");

        final String option = scanner.nextLine();
        LOGGER.debug("Updating status to visited for {}", option);
        StationUpdater.updateStationTo(stations, option, VISITED);
    }

    @Override
    public String getCommandTitle(int commandCode) {
        return commandCode + ". Update Status to Visited for station.";
    }
}
