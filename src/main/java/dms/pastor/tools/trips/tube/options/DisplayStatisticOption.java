package dms.pastor.tools.trips.tube.options;

import dms.pastor.tools.trips.common.options.Option;
import dms.pastor.tools.trips.tube.station.Stations;

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
    }

    private String countPercentageOfAllStationFor(int stationSize, long what) {
        return (what * 100 / stationSize) + "%)";
    }

}