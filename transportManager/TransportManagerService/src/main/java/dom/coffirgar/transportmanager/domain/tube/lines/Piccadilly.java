package dom.coffirgar.transportmanager.domain.tube.lines;



import dom.coffirgar.transportmanager.domain.stations.SharedStations;
import dom.coffirgar.transportmanager.domain.stations.StationName;

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
public class Piccadilly extends Line {


    @Override
    public List<StationName> getStations() {
        List<StationName> tubeStationNames = new ArrayList<>(SharedStations.addUxbridgeToRaynersLane());
        tubeStationNames.add(StationName.SOUTH_HARROW);
        tubeStationNames.add(StationName.SUDBURY_HILL);
        tubeStationNames.add(StationName.SUDBURY_TOWN);
        tubeStationNames.add(StationName.ALPERTON);
        tubeStationNames.add(StationName.PARK_ROYAL);
        tubeStationNames.add(StationName.NORTH_EALING);
        tubeStationNames.add(StationName.EALING_COMMON);
        tubeStationNames.add(StationName.HEATHROW_TERMINALS_1_2_3);
        tubeStationNames.add(StationName.HEATHROW_TERMINAL_4);
        tubeStationNames.add(StationName.HEATHROW_TERMINAL_5);
        tubeStationNames.add(StationName.HATTON_CROSS);
        tubeStationNames.add(StationName.HOUNSLOW_WEST);
        tubeStationNames.add(StationName.HOUNSLOW_CENTRAL);
        tubeStationNames.add(StationName.HOUNSLOW_EAST);
        tubeStationNames.add(StationName.OSTERLEY);
        tubeStationNames.add(StationName.BOSTON_MANOR);
        tubeStationNames.add(StationName.NORTHFIELDS);
        tubeStationNames.add(StationName.SOUTH_EALING);
        tubeStationNames.add(StationName.ACTON_TOWN);
        tubeStationNames.add(StationName.TURNHAM_GREEN);
        tubeStationNames.add(StationName.HAMMERSMITH);
        tubeStationNames.add(StationName.BARONS_COURT);
        tubeStationNames.add(StationName.EARLS_COURT);
        tubeStationNames.add(StationName.GLOUCESTER_ROAD);
        tubeStationNames.add(StationName.SOUTH_KENSINGTON);
        tubeStationNames.add(StationName.KNIGHTSBRIDGE);
        tubeStationNames.add(StationName.HYDE_PARK_CORNER);
        tubeStationNames.add(StationName.GREEN_PARK);
        tubeStationNames.add(StationName.PICCADILLY_CIRCUS);
        tubeStationNames.add(StationName.LEICESTER_SQUARE);
        tubeStationNames.add(StationName.COVENT_GARDEN);
        tubeStationNames.add(StationName.HOLBORN);
        tubeStationNames.add(StationName.RUSSELL_SQUARE);
        tubeStationNames.add(StationName.KINGS_CROSS_ST_PANCRAS);
        tubeStationNames.add(StationName.CALEDONIAN_ROAD);
        tubeStationNames.add(StationName.HOLLOWAY_ROAD);
        tubeStationNames.add(StationName.ARSENAL);
        tubeStationNames.add(StationName.FINSBURY_PARK);
        tubeStationNames.add(StationName.MANOR_HOUSE);
        tubeStationNames.add(StationName.TURNPIKE_LANE);
        tubeStationNames.add(StationName.WOOD_GREEN);
        tubeStationNames.add(StationName.BOUNDS_GREEN);
        tubeStationNames.add(StationName.ARNOS_GROVE);
        tubeStationNames.add(StationName.SOUTHGATE);
        tubeStationNames.add(StationName.OAKWOOD);
        tubeStationNames.add(StationName.COCKFOSTERS);
        return tubeStationNames;
    }
}
