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
public class HammesmithAndCity extends Line {


    @Override
    public List<Station> getStations() {
        var stationList = new ArrayList<Station>();
        stationList.add(Station.HAMMERSMITH);
        stationList.add(Station.GOLDHAWK_ROAD);
        stationList.add(Station.SHEPHERDS_BUSH_MARKET);
        stationList.add(Station.WOOD_LANE);
        stationList.add(Station.LATIMER_ROAD);
        stationList.add(Station.LADBROKE_GROVE);
        stationList.add(Station.WESTBOURNE_PARK);
        stationList.add(Station.ROYAL_OAK);
        stationList.add(Station.PADDINGTON);
        stationList.add(Station.EDGWARE_ROAD);
        stationList.add(Station.BAKER_STREET);
        stationList.add(Station.GREAT_PORTLAND_STREET);
        stationList.add(Station.EUSTON_SQUARE);
        stationList.add(Station.KINGS_CROSS_ST_PANCRAS);
        stationList.add(Station.FARRINGDON);
        stationList.add(Station.BARBICAN);
        stationList.add(Station.MOORGATE);
        stationList.add(Station.LIVERPOOL_STREET);
        stationList.add(Station.BARKING);
        stationList.add(Station.EAST_HAM);
        stationList.add(Station.UPTON_PARK);
        stationList.add(Station.PLAISTOW);
        stationList.add(Station.WEST_HAM);
        stationList.add(Station.BROMLEY_BY_BOW);
        stationList.add(Station.BOW_ROAD);
        stationList.add(Station.MILE_END);
        stationList.add(Station.STEPNEY_GREEN);
        stationList.add(Station.WHITECHAPEL);
        stationList.add(Station.ALDGATE_EAST);
        return stationList;
    }
}
