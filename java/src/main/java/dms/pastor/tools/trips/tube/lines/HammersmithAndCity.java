package dms.pastor.tools.trips.tube.lines;

import dms.pastor.tools.trips.tube.station.SharedStations;
import dms.pastor.tools.trips.tube.station.Station;

import java.util.ArrayList;
import java.util.List;

/**
 * Author Dominik Symonowicz
 * Created 08/06/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class HammersmithAndCity extends Line {


    @Override
    public List<Station> getStations() {
        var stationList = new ArrayList<Station>();
        stationList.addAll(SharedStations.addHammersmithToEdwareSection());
        stationList.addAll(SharedStations.addBakerStreetToLiverpoolStreet());
        stationList.addAll(SharedStations.addAldgateEastToBarking());
        return stationList;
    }
}
