package dms.pastor.tools.trips.common.options;

import dms.pastor.tools.trips.common.station.StationType;
import dms.pastor.tools.trips.common.station.Stations;
import dms.pastor.tools.trips.common.station.Station;

public class ClearThisYearOption implements Option {
    @Override
    public void choose(Stations stations, StationType type) {
        stations.getTubeStationList().forEach(Station::clearVisitedThisYear);
    }

    @Override
    public String getCommandTitle(int commandCode) {
        return commandCode + ". Clear this year.";
    }
}
