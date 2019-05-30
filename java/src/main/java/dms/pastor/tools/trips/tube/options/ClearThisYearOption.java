package dms.pastor.tools.trips.tube.options;

import dms.pastor.tools.trips.common.options.Option;
import dms.pastor.tools.trips.tube.station.Stations;
import dms.pastor.tools.trips.tube.station.TubeStation;

public class ClearThisYearOption implements Option {
    @Override
    public void choose(Stations stations) {
        stations.getTubeStationList().forEach(TubeStation::clearVisitedThisYear);
    }

    @Override
    public String getCommandTitle(int commandCode) {
        return commandCode + ". Clear this year.";
    }
}
