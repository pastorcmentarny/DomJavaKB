package dms.pastor.tools.trips.common.options;

import dms.pastor.tools.trips.common.station.StationType;
import dms.pastor.tools.trips.common.station.Stations;
import dms.pastor.tools.trips.common.station.Station;

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
public class DisplayStatusForAllStationsOption implements Option {
    @Override
    public void choose(Stations stations, StationType type) {
        stations.getTubeStationList().stream()
                .map(Station::asFormattedString)
                .forEach(System.out::println);

    }

    @Override
    public String getCommandTitle(int commandCode) {
        return commandCode + ". Current Status for all station.";
    }
}
