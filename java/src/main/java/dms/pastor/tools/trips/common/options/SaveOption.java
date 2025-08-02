package dms.pastor.tools.trips.common.options;

import dms.pastor.tools.trips.common.station.StationType;
import dms.pastor.tools.trips.common.station.Stations;

import static dms.pastor.tools.trips.tube.data.DataOperations.backup;
import static dms.pastor.tools.trips.tube.data.DataOperations.saveToFile;

/**
 * Author Dominik Symonowicz
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 * <p>
 * tag-command-pattern
 * <p>
 */
public class SaveOption implements Option {
    @Override
    public void choose(Stations stations, StationType type) {
        //TODO set for TUBE and OVERGROUND
        backup();
        saveToFile(stations.stationList());
    }

    @Override
    public String getCommandTitle(int commandCode) {
        return commandCode + ". Save changes (with Backup).";
    }
}
