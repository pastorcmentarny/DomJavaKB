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
public class Northern extends Line {

    @Override
    public List<Station> getStations() {
        List<Station> tubeStations = new ArrayList<>();
        tubeStations.add(Station.MORDEN);
        tubeStations.add(Station.SOUTH_WIMBLEDON);
        tubeStations.add(Station.COLLIERS_WOOD);
        tubeStations.add(Station.TOOTING_BROADWAY);
        tubeStations.add(Station.TOOTING_BEC);
        tubeStations.add(Station.BALHAM);
        tubeStations.add(Station.CLAPHAM_SOUTH);
        tubeStations.add(Station.CLAPHAM_COMMON);
        tubeStations.add(Station.CLAPHAM_NORTH);
        tubeStations.add(Station.STOCKWELL);
        tubeStations.add(Station.OVAL);
        tubeStations.add(Station.KENNINGTON);
        tubeStations.add(Station.WATERLOO);
        tubeStations.add(Station.EMBANKMENT);
        tubeStations.add(Station.CHARING_CROSS);
        tubeStations.add(Station.LEICESTER_SQUARE);
        tubeStations.add(Station.TOTTENHAM_COURT_ROAD);
        tubeStations.add(Station.GOODGE_STREET);
        tubeStations.add(Station.WARREN_STREET);
        tubeStations.add(Station.EUSTON);
        tubeStations.add(Station.MORNINGTON_CRESCENT);
        tubeStations.add(Station.CAMDEN_TOWN);
        tubeStations.add(Station.CHALK_FARM);
        tubeStations.add(Station.BELSIZE_PARK);
        tubeStations.add(Station.HAMPSTEAD);
        tubeStations.add(Station.GOLDERS_GREEN);
        tubeStations.add(Station.BRENT_CROSS);
        tubeStations.add(Station.HENDON_CENTRAL);
        tubeStations.add(Station.COLINDALE);
        tubeStations.add(Station.BURNT_OAK);
        tubeStations.add(Station.EDGWARE);
        tubeStations.add(Station.MILL_HILL_EAST);
        tubeStations.add(Station.HIGH_BARNET);
        tubeStations.add(Station.TOTTERIDGE_AND_WHETSTONE);
        tubeStations.add(Station.WOODSIDE_PARK);
        tubeStations.add(Station.WEST_FINCHLEY);
        tubeStations.add(Station.FINCHLEY_CENTRAL);
        tubeStations.add(Station.EAST_FINCHLEY);
        tubeStations.add(Station.HIGHGATE);
        tubeStations.add(Station.ARCHWAY);
        tubeStations.add(Station.TUFNELL_PARK);
        tubeStations.add(Station.KENTISH_TOWN);
        tubeStations.add(Station.KINGS_CROSS_ST_PANCRAS);
        tubeStations.add(Station.ANGEL);
        tubeStations.add(Station.OLD_STREET);
        tubeStations.add(Station.MOORGATE);
        tubeStations.add(Station.BANK);
        tubeStations.add(Station.LONDON_BRIDGE);
        tubeStations.add(Station.BOROUGH);
        tubeStations.add(Station.ELEPHANT_AND_CASTLE);
        return tubeStations;

    }
}
