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
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * tag-command-pattern
 * <p>
 */
public class DisplayStatusForOption implements Option {
    private static final Logger LOGGER = LoggerFactory.getLogger(DisplayStatusForOption.class);
    private final Scanner scanner;

    DisplayStatusForOption(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void choose(Stations stations, StationType type) {
        final String option = scanner.next();
        LOGGER.debug(String.format("Displaying info for %s", option));
        try {
            final Station station = stations.findStation(option);
            System.out.println(station.asFormattedString());
        } catch (NotFoundException nfe) {
            System.out.println("TubeStation " + option + " not found.");
        }

    }

    @Override
    public String getCommandTitle(int commandCode) {
        return commandCode + ". Current Status for selected station.";
    }
}
