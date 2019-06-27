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
public class Metropolitan extends Line {


    @Override
    public List<Station> getStations() {
        var tubeStations = new ArrayList<Station>();
        tubeStations.add(Station.CHESHAM);
        tubeStations.add(Station.AMERSHAM);
        tubeStations.add(Station.CHALFONT_AND_LATIMER);
        tubeStations.add(Station.CHORLEYWOOD);
        tubeStations.add(Station.RICKMANSWORTH);
        tubeStations.add(Station.WATFORD);
        tubeStations.add(Station.CROXLEY);
        tubeStations.add(Station.MOOR_PARK);
        tubeStations.add(Station.NORTHWOOD);
        tubeStations.add(Station.NORTHWOOD_HILLS);
        tubeStations.add(Station.PINNER);
        tubeStations.add(Station.NORTH_HARROW);
        tubeStations.addAll(SharedStations.addUxbridgeToRaynersLane());
        tubeStations.add(Station.WEST_HARROW);
        tubeStations.add(Station.HARROW_ON_THE_HILL);
        tubeStations.add(Station.NORTHWICK_PARK);
        tubeStations.add(Station.PRESTON_ROAD);
        tubeStations.add(Station.WEMBLEY_PARK);
        tubeStations.add(Station.FINCHLEY_ROAD);
        tubeStations.addAll(SharedStations.addBakerStreetToLiverpoolStreet());
        tubeStations.add(Station.ALDGATE);

        return tubeStations;
    }
}
