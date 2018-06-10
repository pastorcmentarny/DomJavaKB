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
public class Circle extends Line {


    @Override
    public List<Station> getStations() {
        var tubeStations = new ArrayList<Station>();
        tubeStations.add(Station.HAMMERSMITH);
        tubeStations.add(Station.GOLDHAWK_ROAD);
        tubeStations.add(Station.SHEPHERDS_BUSH_MARKET);
        tubeStations.add(Station.WOOD_LANE);
        tubeStations.add(Station.WHITE_CITY);
        tubeStations.add(Station.LATIMER_ROAD);
        tubeStations.add(Station.LADBROKE_GROVE);
        tubeStations.add(Station.WESTBOURNE_PARK);
        tubeStations.add(Station.ROYAL_OAK);
        tubeStations.add(Station.PADDINGTON);
        tubeStations.add(Station.EDGWARE_ROAD);
        tubeStations.add(Station.BAKER_STREET);
        tubeStations.add(Station.GREAT_PORTLAND_STREET);
        tubeStations.add(Station.EUSTON_SQUARE);
        tubeStations.add(Station.KINGS_CROSS_ST_PANCRAS);
        tubeStations.add(Station.FARRINGDON);
        tubeStations.add(Station.BARBICAN);
        tubeStations.add(Station.MOORGATE);
        tubeStations.add(Station.LIVERPOOL_STREET);
        tubeStations.add(Station.ALDGATE);
        tubeStations.add(Station.TOWER_HILL);
        tubeStations.add(Station.MONUMENT);
        tubeStations.add(Station.CANNON_STREET);
        tubeStations.add(Station.MANSION_HOUSE);
        tubeStations.add(Station.BLACKFRIARS);
        tubeStations.add(Station.TEMPLE);
        tubeStations.add(Station.EMBANKMENT);
        tubeStations.add(Station.WESTMINSTER);
        tubeStations.add(Station.ST_JAMESS_PARK);
        tubeStations.add(Station.VICTORIA);
        tubeStations.add(Station.SLOANE_SQUARE);
        tubeStations.add(Station.SOUTH_KENSINGTON);
        tubeStations.add(Station.GLOUCESTER_ROAD);
        tubeStations.add(Station.HIGH_STREET_KENSINGTON);
        tubeStations.add(Station.NOTTING_HILL_GATE);
        tubeStations.add(Station.BAYSWATER);
        return tubeStations;

    }
}
