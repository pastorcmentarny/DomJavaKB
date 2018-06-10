package dms.pastor.tools.trips.tube.lines;

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
public class Victoria extends Line {


    @Override
    public List<Station> getStations() {
        var tubeStations = new ArrayList<Station>();
        tubeStations.add(Station.BRIXTON);
        tubeStations.add(Station.STOCKWELL);
        tubeStations.add(Station.VAUXHALL);
        tubeStations.add(Station.PIMLICO);
        tubeStations.add(Station.VICTORIA);
        tubeStations.add(Station.GREEN_PARK);
        tubeStations.add(Station.OXFORD_CIRCUS);
        tubeStations.add(Station.WARREN_STREET);
        tubeStations.add(Station.EUSTON);
        tubeStations.add(Station.KINGS_CROSS_ST_PANCRAS);
        tubeStations.add(Station.HIGHBURY_AND_ISLINGTON);
        tubeStations.add(Station.FINSBURY_PARK);
        tubeStations.add(Station.SEVEN_SISTERS);
        tubeStations.add(Station.TOTTENHAM_HALE);
        tubeStations.add(Station.BLACKHORSE_ROAD);
        tubeStations.add(Station.WALTHAMSTOW_CENTRAL);
        return tubeStations;
    }
}
