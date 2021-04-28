package dms.pastor.tools.trips.tube.lines;

import dms.pastor.tools.trips.common.station.StationName;

import java.util.ArrayList;
import java.util.List;

/**
 * Author Dominik Symonowicz
 * Created 06/06/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class WaterlooAndCity extends Line {

    @Override
    public List<StationName> getStations() {
        List<StationName> tubeStationNames = new ArrayList<>();
        tubeStationNames.add(StationName.WATERLOO);
        tubeStationNames.add(StationName.BANK);
        return tubeStationNames;
    }

}
