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
        tubeStations.add(Station.UXBRIDGE);
        tubeStations.add(Station.HILLINGDON);
        tubeStations.add(Station.ICKENHAM);
        tubeStations.add(Station.RUISLIP);
        tubeStations.add(Station.RUISLIP_MANOR);
        tubeStations.add(Station.EASTCOTE);
        tubeStations.add(Station.RAYNERS_LANE);
        tubeStations.add(Station.WEST_HARROW);
        tubeStations.add(Station.HARROW_ON_THE_HILL);
        tubeStations.add(Station.NORTHWICK_PARK);
        tubeStations.add(Station.PRESTON_ROAD);
        tubeStations.add(Station.WEMBLEY_PARK);
        tubeStations.add(Station.FINCHLEY_ROAD);
        tubeStations.add(Station.BAKER_STREET);
        tubeStations.add(Station.GREAT_PORTLAND_STREET);
        tubeStations.add(Station.EUSTON_SQUARE);
        tubeStations.add(Station.KINGS_CROSS_ST_PANCRAS);
        tubeStations.add(Station.FARRINGDON);
        tubeStations.add(Station.BARBICAN);
        tubeStations.add(Station.MOORGATE);
        tubeStations.add(Station.LIVERPOOL_STREET);
        tubeStations.add(Station.ALDGATE);

        return tubeStations;
    }
}
