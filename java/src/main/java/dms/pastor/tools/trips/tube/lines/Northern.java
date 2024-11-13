package dms.pastor.tools.trips.tube.lines;

import dms.pastor.tools.trips.common.station.StationName;

import java.util.ArrayList;
import java.util.List;

/**
 * Author Dominik Symonowicz
 * Created 08/06/2018
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Northern extends Line {

    @Override
    public List<StationName> getStations() {
        List<StationName> tubeStationNames = new ArrayList<>();
        tubeStationNames.add(StationName.MORDEN);
        tubeStationNames.add(StationName.SOUTH_WIMBLEDON);
        tubeStationNames.add(StationName.COLLIERS_WOOD);
        tubeStationNames.add(StationName.TOOTING_BROADWAY);
        tubeStationNames.add(StationName.TOOTING_BEC);
        tubeStationNames.add(StationName.BALHAM);
        tubeStationNames.add(StationName.CLAPHAM_SOUTH);
        tubeStationNames.add(StationName.CLAPHAM_COMMON);
        tubeStationNames.add(StationName.CLAPHAM_NORTH);
        tubeStationNames.add(StationName.STOCKWELL);
        tubeStationNames.add(StationName.OVAL);
        tubeStationNames.add(StationName.KENNINGTON);
        tubeStationNames.add(StationName.WATERLOO);
        tubeStationNames.add(StationName.EMBANKMENT);
        tubeStationNames.add(StationName.CHARING_CROSS);
        tubeStationNames.add(StationName.LEICESTER_SQUARE);
        tubeStationNames.add(StationName.TOTTENHAM_COURT_ROAD);
        tubeStationNames.add(StationName.GOODGE_STREET);
        tubeStationNames.add(StationName.WARREN_STREET);
        tubeStationNames.add(StationName.EUSTON);
        tubeStationNames.add(StationName.MORNINGTON_CRESCENT);
        tubeStationNames.add(StationName.CAMDEN_TOWN);
        tubeStationNames.add(StationName.CHALK_FARM);
        tubeStationNames.add(StationName.BELSIZE_PARK);
        tubeStationNames.add(StationName.HAMPSTEAD);
        tubeStationNames.add(StationName.GOLDERS_GREEN);
        tubeStationNames.add(StationName.BRENT_CROSS);
        tubeStationNames.add(StationName.HENDON_CENTRAL);
        tubeStationNames.add(StationName.COLINDALE);
        tubeStationNames.add(StationName.BURNT_OAK);
        tubeStationNames.add(StationName.EDGWARE);
        tubeStationNames.add(StationName.MILL_HILL_EAST);
        tubeStationNames.add(StationName.HIGH_BARNET);
        tubeStationNames.add(StationName.TOTTERIDGE_AND_WHETSTONE);
        tubeStationNames.add(StationName.WOODSIDE_PARK);
        tubeStationNames.add(StationName.WEST_FINCHLEY);
        tubeStationNames.add(StationName.FINCHLEY_CENTRAL);
        tubeStationNames.add(StationName.EAST_FINCHLEY);
        tubeStationNames.add(StationName.HIGHGATE);
        tubeStationNames.add(StationName.ARCHWAY);
        tubeStationNames.add(StationName.TUFNELL_PARK);
        tubeStationNames.add(StationName.KENTISH_TOWN);
        tubeStationNames.add(StationName.KINGS_CROSS_ST_PANCRAS);
        tubeStationNames.add(StationName.ANGEL);
        tubeStationNames.add(StationName.OLD_STREET);
        tubeStationNames.add(StationName.MOORGATE);
        tubeStationNames.add(StationName.BANK);
        tubeStationNames.add(StationName.LONDON_BRIDGE);
        tubeStationNames.add(StationName.BOROUGH);
        tubeStationNames.add(StationName.ELEPHANT_AND_CASTLE);
        return tubeStationNames;

    }
}
