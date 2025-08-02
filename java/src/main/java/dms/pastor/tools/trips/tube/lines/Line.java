package dms.pastor.tools.trips.tube.lines;

import dms.pastor.tools.trips.common.station.StationName;

import java.util.List;

/**
 * Author Dominik Symonowicz
 * Created 06/06/2018
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public abstract class Line {
    private final List<StationName> tubeStationNames = getStations();

    public String name() {
        return getClass().getSimpleName();
    }

    public int getSize() {
        return tubeStationNames.size();
    }

    public abstract List<StationName> getStations();


}
