package dms.pastor.tools.trips.common.options;

import dms.pastor.tools.trips.common.station.StationType;
import dms.pastor.tools.trips.common.station.Stations;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
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
public class DisplayOvergroundStatisticOption implements Option {

    @Override
    public void choose(Stations stations, StationType type) {
        final var countStationVisitedThisYear = stations.countStationVisitedThisYear();
        final var countStationVisited = stations.countStationVisited();
        final var countStationPassed = stations.countStationPassed();

        System.out.println("I visited " + countStationVisitedThisYear + " " + getWordIfPlural("station", countStationVisitedThisYear) + " this year(" +
                countPercentageOfAllStationFor(stations.getStationList().size(), countStationVisitedThisYear) + ".");

        System.out.println("I visited " + countStationVisited + " " + getWordIfPlural("station", countStationVisited) + " (" +
                countPercentageOfAllStationFor(stations.getStationList().size(), stations.countStationVisited()) + ".");

        System.out.println("I passed " + countStationPassed + " " + getWordIfPlural("station", countStationPassed) + " (" +
                countPercentageOfAllStationFor(stations.getStationList().size(), countStationPassed) + ".");
        System.out.println(displayStationsBlogged(stations));
    }

    private String displayStationsBlogged(Stations stations) {
        var result = new StringBuilder(EMPTY_STRING);
        result.append("{");
        stations.displayAllStationsBlogged().forEach(station -> result.append(station).append(","));
        result.deleteCharAt(result.length() - 1);
        result.append("I blogged about ")
                .append(stations.countStationsBlogged())
                .append(" ")
                .append(getWordIfPlural("station", stations.countStationsBlogged() + 1))//FIXME remove 1 when I blog about overground station
                .append(" so far.");
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
