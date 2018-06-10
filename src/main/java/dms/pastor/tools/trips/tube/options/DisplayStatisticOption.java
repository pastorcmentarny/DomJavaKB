package dms.pastor.tools.trips.tube.options;

import dms.pastor.tools.trips.common.options.Option;
import dms.pastor.tools.trips.tube.lines.Line;
import dms.pastor.tools.trips.tube.lines.Lines;
import dms.pastor.tools.trips.tube.station.Station;
import dms.pastor.tools.trips.tube.station.Stations;
import dms.pastor.tools.trips.tube.station.Status;
import dms.pastor.tools.trips.tube.station.TubeStation;
import dms.pastor.utils.NumberUtils;

import java.util.List;
import java.util.Optional;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.StringUtils.NEW_LINE;

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
    public void choose(Stations stations) {
        System.out.println("You visited " + stations.countStationVisitedThisYear() + " station(s) this year. (" +
                countPercentageOfAllStationFor(stations.getTubeStationList().size(), stations.countStationVisitedThisYear()));
        System.out.println("You visited " + stations.countStationVisited() + " station(s). (" +
                countPercentageOfAllStationFor(stations.getTubeStationList().size(), stations.countStationVisited()));
        System.out.println("You passed " + stations.countStationPassed() + " station(s). (" +
                countPercentageOfAllStationFor(stations.getTubeStationList().size(), stations.countStationPassed()));
        System.out.println(getStatsForLines(stations));
    }

    private String countPercentageOfAllStationFor(int stationSize, long what) {
        return (what * 100 / stationSize) + "%)";
    }

    //find all stations that on the line
    // check if station was passed
    private String getStatsForLines(Stations stations) {
        var stringBuilder = new StringBuilder(EMPTY_STRING);
        final List<Line> lines = Lines.getLines();
        for (var line : lines) {
            int count = 0;
            final List<Station> lineStations = line.getStations();
            for (var lineStation : lineStations) {
                final Optional<TubeStation> station = stations.getStation(lineStation.getStationName());
                if (station.isPresent() && (station.get().getStatus().equals(Status.PASSED) || station.get().getStatus().equals(Status.VISITED))) {
                    count++;
                }
            }
            stringBuilder.append(line.name()).append(' ').append(NumberUtils.getPercentage(count, lineStations.size())).append(NEW_LINE);
        }
        return stringBuilder.toString();
    }

}
