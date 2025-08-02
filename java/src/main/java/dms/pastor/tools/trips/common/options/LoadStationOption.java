package dms.pastor.tools.trips.common.options;

import dms.pastor.tools.trips.common.station.StationType;
import dms.pastor.tools.trips.common.station.Stations;

import static dms.pastor.tools.trips.tube.data.DataOperations.loadFromFile;

/**
 * Author Dominik Symonowicz
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 * <p>
 * tag-command-pattern
 * <p>
 */
public class LoadStationOption implements Option {
    @Override
    public void choose(Stations stations, StationType type) {
        System.out.println("Reload data without saving.. All changes in the session will be discarded");
        loadFromFile();
    }

    @Override
    public String getCommandTitle(int commandCode) {
        return commandCode + ". Discard unsaved changes.";
    }
}
