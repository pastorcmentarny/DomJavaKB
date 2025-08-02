package dms.pastor.tools.trips.common.options;

import dms.pastor.tools.trips.common.station.StationType;
import dms.pastor.tools.trips.common.station.Stations;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.TextUtils.getWordIfPlural;

/**
 * Author Dominik Symonowicz
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 * <p>
 * tag-command-pattern
 * <p>
 */
public class DisplayOvergroundStatisticOption implements Option {

    @Override
    public void choose(Stations stations, StationType type) {
        final var countStationVisitedThisYear = stations.countStationVisitedThisYear();
        final var countStationVisited = stations.countStationVisited();
        final var countStationPassed = stations.countStationPassed();
        System.out.println("There are " + stations.totalNumber() + " stations on the Overground as " + LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
        System.out.println("I visited " + countStationVisitedThisYear + " " + getWordIfPlural("station", countStationVisitedThisYear) + " this year(" +
                countPercentageOfAllStationFor(stations.stationList().size(), countStationVisitedThisYear) + ".");

        System.out.println("I visited " + countStationVisited + " " + getWordIfPlural("station", countStationVisited) + " (" +
                countPercentageOfAllStationFor(stations.stationList().size(), stations.countStationVisited()) + ".");

        System.out.println("I passed " + countStationPassed + " " + getWordIfPlural("station", countStationPassed) + " (" +
                countPercentageOfAllStationFor(stations.stationList().size(), countStationPassed) + ".");
        System.out.println(displayStationsBlogged(stations));
    }

    private String displayStationsBlogged(Stations stations) {
        var result = new StringBuilder(EMPTY_STRING);
        result.append("I blogged about ")
                .append(stations.countStationsBlogged())
                .append(" ")
                .append(getWordIfPlural("station", stations.countStationsBlogged() + 1))//FIXME remove 1 when I blog about overground station
                .append(" so far. ");
        stations.displayAllStationsBlogged().forEach(station -> result.append(station).append(","));
        result.deleteCharAt(result.length() - 1);

        return result.toString();
    }

    private String countPercentageOfAllStationFor(long stationSize, long what) {
        return (what * 100 / stationSize) + "%)";
    }


    @Override
    public String getCommandTitle(int commandCode) {
        return commandCode + ". Stats.";
    }


}
