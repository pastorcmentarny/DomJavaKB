package dms.pastor.tools.trips.tube.options;

import dms.pastor.tools.trips.common.options.Option;
import dms.pastor.tools.trips.tube.station.Stations;

import static dms.pastor.tools.trips.tube.data.DataOperations.loadFromFile;

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
public class LoadStationOption implements Option {
    @Override
    public void choose(Stations stations) {
        System.out.println("Reload data without saving.. All changes in the session will be discarded");
        loadFromFile();
    }

    @Override
    public String getCommandTitle(int commandCode) {
        return commandCode + ". Discard unsaved changes.";
    }
}
