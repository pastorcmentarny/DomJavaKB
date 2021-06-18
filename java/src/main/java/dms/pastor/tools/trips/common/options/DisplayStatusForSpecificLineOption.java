package dms.pastor.tools.trips.common.options;

import dms.pastor.domain.exception.NotFoundException;
import dms.pastor.tools.trips.common.station.Station;
import dms.pastor.tools.trips.common.station.StationName;
import dms.pastor.tools.trips.common.station.StationType;
import dms.pastor.tools.trips.common.station.Stations;
import dms.pastor.tools.trips.tube.lines.Line;
import dms.pastor.tools.trips.tube.lines.Lines;
import dms.pastor.utils.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;

@SuppressWarnings("ClassCanBeRecord")
public class DisplayStatusForSpecificLineOption implements Option {
    private static final Logger LOGGER = LoggerFactory.getLogger(DisplayStatusForSpecificLineOption.class);
    private final Scanner scanner;

    DisplayStatusForSpecificLineOption(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void choose(Stations stations, StationType type) {
        System.out.print("Select line from :");
        Lines.displayAllLinesNames();
        System.out.println();
        final String searchTerm = scanner.next();
        LOGGER.debug(String.format("Displaying info for %s", searchTerm));
        try {
            final Line undergroundLine = Lines.findLine(searchTerm);
            System.out.println(undergroundLine.name() + " has " + undergroundLine.getSize() + " stations.");
            System.out.println(getStatsForLines(stations, undergroundLine));

            System.out.println("\nDetailed status for each station: ");
            undergroundLine.getStations().forEach(station -> System.out.println(stations.findStation(station.getStationName()).asFormattedString()));
        } catch (NotFoundException nfe) {
            System.out.println("Line " + searchTerm + " not found.");
        }
    }

    @Override
    public String getCommandTitle(int commandCode) {
        return commandCode + ". Current Status for selected line.";

    }

    private String getStatsForLines(Stations stations, Line undergroundLine) {
        var stringBuilder = new StringBuilder(EMPTY_STRING);
        int at_least_passed_station_count = 0;
        int visited_station_count = 0;
        final List<StationName> lineStationNames = undergroundLine.getStations();
        for (var lineStation : lineStationNames) {
            final Optional<Station> station = stations.getStation(lineStation.getStationName());
            if (station.isPresent() && (station.get().getStatus().equals(Status.PASSED) || station.get().getStatus().equals(Status.VISITED))) {
                at_least_passed_station_count++;
            }
            if (station.isPresent() && station.get().getStatus().equals(Status.VISITED)) {
                visited_station_count++;
            }
        }
        return stringBuilder.append("You cover ")
                .append(NumberUtils.getPercentage(at_least_passed_station_count, lineStationNames.size()))
                .append("% of the line.You visited ")
                .append(visited_station_count)
                .append(" stations (")
                .append(NumberUtils.getPercentage(visited_station_count, lineStationNames.size()))
                .append("%).")
                .toString();


    }
}
