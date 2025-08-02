package dms.pastor.tools.trips.common.options;

import dms.pastor.tools.trips.common.Constants;
import dms.pastor.tools.trips.common.station.StationType;
import dms.pastor.tools.trips.common.station.Stations;

/**
 * Author Dominik Symonowicz
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public class DisplayAllStationsNameOption implements Option {
    @Override
    public void choose(Stations stations, StationType type) {
        stations.stationList().forEach(station -> System.out.println(station.getName()));
        displayWarningIfTotalStationNumberIsWrong(stations, type);
    }

    private void displayWarningIfTotalStationNumberIsWrong(Stations stations, StationType type) {

        final int totalNumber = Constants.getAllStationsNumberFor(type);
        if (stations.totalNumber() != totalNumber) {
            System.out.println("WARNING! Total number should be " + totalNumber + " but file contains only " + stations.totalNumber());
        }
    }

    @Override
    public String getCommandTitle(int commandCode) {
        return commandCode + ". Display list of all stations.";
    }
}
