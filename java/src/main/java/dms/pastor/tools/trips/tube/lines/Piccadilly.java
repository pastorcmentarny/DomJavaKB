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
public class Piccadilly extends Line {


    @Override
    public List<Station> getStations() {
        List<Station> tubeStations = new ArrayList<>();
        tubeStations.add(Station.UXBRIDGE);
        tubeStations.add(Station.HILLINGDON);
        tubeStations.add(Station.ICKENHAM);
        tubeStations.add(Station.RUISLIP);
        tubeStations.add(Station.RUISLIP_MANOR);
        tubeStations.add(Station.EASTCOTE);
        tubeStations.add(Station.RAYNERS_LANE);
        tubeStations.add(Station.SOUTH_HARROW);
        tubeStations.add(Station.SUDBURY_HILL);
        tubeStations.add(Station.SUDBURY_TOWN);
        tubeStations.add(Station.ALPERTON);
        tubeStations.add(Station.PARK_ROYAL);
        tubeStations.add(Station.NORTH_EALING);
        tubeStations.add(Station.EALING_COMMON);
        tubeStations.add(Station.HEATHROW_TERMINALS_1_2_3);
        tubeStations.add(Station.HEATHROW_TERMINAL_4);
        tubeStations.add(Station.HEATHROW_TERMINAL_5);
        tubeStations.add(Station.HATTON_CROSS);
        tubeStations.add(Station.HOUNSLOW_WEST);
        tubeStations.add(Station.HOUNSLOW_CENTRAL);
        tubeStations.add(Station.HOUNSLOW_EAST);
        tubeStations.add(Station.OSTERLEY);
        tubeStations.add(Station.BOSTON_MANOR);
        tubeStations.add(Station.NORTHFIELDS);
        tubeStations.add(Station.SOUTH_EALING);
        tubeStations.add(Station.ACTON_TOWN);
        tubeStations.add(Station.TURNHAM_GREEN);
        tubeStations.add(Station.HAMMERSMITH);
        tubeStations.add(Station.BARONS_COURT);
        tubeStations.add(Station.EARLS_COURT);
        tubeStations.add(Station.GLOUCESTER_ROAD);
        tubeStations.add(Station.SOUTH_KENSINGTON);
        tubeStations.add(Station.KNIGHTSBRIDGE);
        tubeStations.add(Station.HYDE_PARK_CORNER);
        tubeStations.add(Station.GREEN_PARK);
        tubeStations.add(Station.PICCADILLY_CIRCUS);
        tubeStations.add(Station.LEICESTER_SQUARE);
        tubeStations.add(Station.COVENT_GARDEN);
        tubeStations.add(Station.HOLBORN);
        tubeStations.add(Station.RUSSELL_SQUARE);
        tubeStations.add(Station.KINGS_CROSS_ST_PANCRAS);
        tubeStations.add(Station.CALEDONIAN_ROAD);
        tubeStations.add(Station.HOLLOWAY_ROAD);
        tubeStations.add(Station.ARSENAL);
        tubeStations.add(Station.FINSBURY_PARK);
        tubeStations.add(Station.MANOR_HOUSE);
        tubeStations.add(Station.TURNPIKE_LANE);
        tubeStations.add(Station.WOOD_GREEN);
        tubeStations.add(Station.BOUNDS_GREEN);
        tubeStations.add(Station.ARNOS_GROVE);
        tubeStations.add(Station.SOUTHGATE);
        tubeStations.add(Station.OAKWOOD);
        tubeStations.add(Station.COCKFOSTERS);
        return tubeStations;
    }
}
