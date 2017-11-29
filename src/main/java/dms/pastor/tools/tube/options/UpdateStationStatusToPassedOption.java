package dms.pastor.tools.tube.options;

import dms.pastor.domain.exception.NotFoundException;
import dms.pastor.tools.tube.Station;
import dms.pastor.tools.tube.Stations;
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
public class UpdateStationStatusToPassedOption implements Option {
    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateStationStatusToPassedOption.class);
    private final Scanner scanner;

    public UpdateStationStatusToPassedOption(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void choose(Stations stations) {
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
}