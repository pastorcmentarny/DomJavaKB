package dms.pastor.tools.trips.common.options;

import dms.pastor.tools.trips.common.station.Station;
import dms.pastor.tools.trips.common.station.StationName;
import dms.pastor.tools.trips.common.station.StationType;
import dms.pastor.tools.trips.common.station.Stations;
import dms.pastor.tools.trips.tube.lines.Line;
import dms.pastor.tools.trips.tube.lines.Lines;
import dms.pastor.utils.NumberUtils;

import java.util.List;
import java.util.Optional;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.StringUtils.NEW_LINE;
import static dms.pastor.utils.TextUtils.getWordIfPlural;

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
public class DisplayStatisticOption implements Option {

    @Override
    public void choose(Stations stations, StationType type) {
        final var countStationVisitedThisYear = stations.countStationVisitedThisYear();
        final var countStationVisited = stations.countStationVisited();
        final var countStationPassed = stations.countStationPassed();

        System.out.println("I visited " + countStationVisitedThisYear + " " + getWordIfPlural("station", countStationVisitedThisYear) + " this year. (" +
                countPercentageOfAllStationFor(stations.getStationList().size(), countStationVisitedThisYear));

        System.out.println("I visited " + countStationVisited + " " + getWordIfPlural("station", countStationVisited) + ". (" +
                countPercentageOfAllStationFor(stations.getStationList().size(), stations.countStationVisited()));

        System.out.println("I passed " + countStationPassed + " " + getWordIfPlural("station", countStationPassed) + ". (" +
                countPercentageOfAllStationFor(stations.getStationList().size(), countStationPassed));
        System.out.println(getStatsForLines(stations));
        System.out.println(displayStationsBlogged(stations));
    }

    private String displayStationsBlogged(Stations stations) {
        final List<Station> stationList = stations.getStationList();
        var result = new StringBuilder(EMPTY_STRING);
        result.append("{");
        stations.displayAllStationsBlogged().forEach(station -> result.append(station).append(","));
        result.deleteCharAt(result.length() - 1);
        result.append(") ");
        result.append("(Total station blogged: ").append(countPercentageOfAllStationFor(stationList.size(), stations.countStationsBlogged()));
        return result.toString();
    }

    private String countPercentageOfAllStationFor(long stationSize, long what) {
        return (what * 100 / stationSize) + "%)";
    }

    private String getStatsForLines(Stations stations) {
        var stringBuilder = new StringBuilder(EMPTY_STRING);
        final List<Line> lines = Lines.getLines();
        for (var line : lines) {
            int count = 0;
            final List<StationName> lineStationNames = line.getStations();
            for (var lineStation : lineStationNames) {
                final Optional<Station> station = stations.getStation(lineStation.getStationName());
                if (station.isPresent() && (station.get().getStatus().equals(Status.PASSED) || station.get().getStatus().equals(Status.VISITED))) {
                    count++;
                }
            }
            stringBuilder.append(line.name()).append(' ').append(NumberUtils.getPercentage(count, lineStationNames.size())).append("%").append(NEW_LINE);
        }
        return stringBuilder.toString();
    }

    @Override
    public String getCommandTitle(int commandCode) {
        return commandCode + ". Stats.";
    }


}
