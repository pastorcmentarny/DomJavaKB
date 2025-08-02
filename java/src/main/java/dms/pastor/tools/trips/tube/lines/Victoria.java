package dms.pastor.tools.trips.tube.lines;

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
public class Victoria extends Line {


    @Override
    public List<StationName> getStations() {
        var tubeStations = new ArrayList<StationName>();
        tubeStations.add(StationName.BRIXTON);
        tubeStations.add(StationName.STOCKWELL);
        tubeStations.add(StationName.VAUXHALL);
        tubeStations.add(StationName.PIMLICO);
        tubeStations.add(StationName.VICTORIA);
        tubeStations.add(StationName.GREEN_PARK);
        tubeStations.add(StationName.OXFORD_CIRCUS);
        tubeStations.add(StationName.WARREN_STREET);
        tubeStations.add(StationName.EUSTON);
        tubeStations.add(StationName.KINGS_CROSS_ST_PANCRAS);
        tubeStations.add(StationName.HIGHBURY_AND_ISLINGTON);
        tubeStations.add(StationName.FINSBURY_PARK);
        tubeStations.add(StationName.SEVEN_SISTERS);
        tubeStations.add(StationName.TOTTENHAM_HALE);
        tubeStations.add(StationName.BLACKHORSE_ROAD);
        tubeStations.add(StationName.WALTHAMSTOW_CENTRAL);
        return tubeStations;
    }
}
