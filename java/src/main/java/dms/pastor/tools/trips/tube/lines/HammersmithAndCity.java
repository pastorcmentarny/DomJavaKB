package dms.pastor.tools.trips.tube.lines;

import dms.pastor.tools.trips.common.station.SharedStations;
import dms.pastor.tools.trips.common.station.StationName;

import java.util.ArrayList;
import java.util.List;

/**
 * Author Dominik Symonowicz
 * Created 08/06/2018
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public class HammersmithAndCity extends Line {


    @Override
    public List<StationName> getStations() {
        var stationList = new ArrayList<StationName>();
        stationList.addAll(SharedStations.addHammersmithToEdwareSection());
        stationList.addAll(SharedStations.addBakerStreetToLiverpoolStreet());
        stationList.addAll(SharedStations.addAldgateEastToBarking());
        return stationList;
    }
}
