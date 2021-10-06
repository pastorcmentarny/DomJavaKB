package dms.pastor.tools.trips.common.options;

import dms.pastor.tools.trips.common.Constants;
import dms.pastor.tools.trips.common.station.StationType;
import dms.pastor.tools.trips.common.station.Stations;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class DisplayAllStationsNameOption implements Option {
    @Override
    public void choose(Stations stations, StationType type) {
        stations.getStationList().forEach(station -> System.out.println(station.getName()));
        displayWarningIfTotalStationNumberIsWrong(stations,type);
    }

    private void displayWarningIfTotalStationNumberIsWrong(Stations stations,StationType type) {

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
