package dms.pastor.tools.trips.overground.lines;

import dms.pastor.tools.trips.common.station.StationName;
import dms.pastor.tools.trips.common.station.StationType;

import java.util.ArrayList;
import java.util.List;

/**
 * Author Dominik Symonowicz
 * Created 08/06/2018
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public class Overground extends OvergroundLine {


    @Override
    public List<StationName> getStations() {
        var overgroundStations = new ArrayList<StationName>();
        final var allStations = StationName.values();
        for (StationName station : allStations) {
            if (StationType.isOvergroundType(station.getStationType())) {
                overgroundStations.add(station);
            }

        }
        return overgroundStations;
    }
}
