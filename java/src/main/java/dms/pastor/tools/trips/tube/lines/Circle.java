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
public class Circle extends Line {


    @Override
    public List<Station> getStations() {
        var tubeStations = new ArrayList<Station>();
        tubeStations.addAll(SharedStations.addHammersmithToEdwareSection());
        tubeStations.addAll(SharedStations.addBakerStreetToLiverpoolStreet());
        tubeStations.add(Station.ALDGATE);
        tubeStations.addAll(SharedStations.addTowerHillToGloucesterRoad());
        tubeStations.addAll(SharedStations.addHighStreetKensingtonToBayswater());
        return tubeStations;

    }
}
