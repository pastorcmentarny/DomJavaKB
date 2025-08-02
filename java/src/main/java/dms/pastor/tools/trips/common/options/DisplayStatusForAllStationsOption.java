package dms.pastor.tools.trips.common.options;

import dms.pastor.tools.trips.common.station.Station;
import dms.pastor.tools.trips.common.station.StationType;
import dms.pastor.tools.trips.common.station.Stations;

/**
 * Author Dominik Symonowicz
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 * <p>
 * tag-command-pattern
 * <p>
 */
public class DisplayStatusForAllStationsOption implements Option {
    @Override
    public void choose(Stations stations, StationType type) {
        stations.stationList().stream()
                .map(Station::asFormattedString)
                .forEach(System.out::println);

    }

    @Override
    public String getCommandTitle(int commandCode) {
        return commandCode + ". Current Status for all station.";
    }
}
