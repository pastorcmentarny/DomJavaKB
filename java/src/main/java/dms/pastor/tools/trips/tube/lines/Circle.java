package dms.pastor.tools.trips.tube.lines;

import dms.pastor.tools.trips.common.station.SharedStations;
import dms.pastor.tools.trips.common.station.StationName;

import java.util.ArrayList;
import java.util.List;

/**
 * Author Dominik Symonowicz
 * Created 08/06/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Circle extends Line {


    @Override
    public List<StationName> getStations() {
        var tubeStations = new ArrayList<StationName>();
        tubeStations.addAll(SharedStations.addHammersmithToEdwareSection());
        tubeStations.addAll(SharedStations.addBakerStreetToLiverpoolStreet());
        tubeStations.add(StationName.ALDGATE);
        tubeStations.addAll(SharedStations.addTowerHillToGloucesterRoad());
        tubeStations.addAll(SharedStations.addHighStreetKensingtonToBayswater());
        return tubeStations;

    }
}
