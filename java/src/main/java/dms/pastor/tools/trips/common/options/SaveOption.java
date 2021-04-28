package dms.pastor.tools.trips.common.options;

import dms.pastor.tools.trips.common.station.StationType;
import dms.pastor.tools.trips.common.station.Stations;

import static dms.pastor.tools.trips.tube.data.DataOperations.backup;
import static dms.pastor.tools.trips.tube.data.DataOperations.saveToFile;

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
public class SaveOption implements Option {
    @Override
    public void choose(Stations stations, StationType type) {
        //TODO set for TUBE and OVERGROUND
        backup();
        saveToFile(stations.getStationList());
    }

    @Override
    public String getCommandTitle(int commandCode) {
        return commandCode + ". Save changes (with Backup).";
    }
}
