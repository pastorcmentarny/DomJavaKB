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
public class Central extends Line {


    @Override
    public List<StationName> getStations() {
        List<StationName> tubeStationNames = new ArrayList<>();
        tubeStationNames.add(StationName.WEST_RUISLIP);
        tubeStationNames.add(StationName.RUISLIP_GARDENS);
        tubeStationNames.add(StationName.SOUTH_RUISLIP);
        tubeStationNames.add(StationName.NORTHOLT);
        tubeStationNames.add(StationName.GREENFORD);
        tubeStationNames.add(StationName.PERIVALE);
        tubeStationNames.add(StationName.HANGER_LANE);
        tubeStationNames.add(StationName.EALING_BROADWAY);
        tubeStationNames.add(StationName.WEST_ACTON);
        tubeStationNames.add(StationName.NORTH_ACTON);
        tubeStationNames.add(StationName.EAST_ACTON);
        tubeStationNames.add(StationName.WHITE_CITY);
        tubeStationNames.add(StationName.SHEPHERDS_BUSH);
        tubeStationNames.add(StationName.HOLLAND_PARK);
        tubeStationNames.add(StationName.NOTTING_HILL_GATE);
        tubeStationNames.add(StationName.QUEENSWAY);
        tubeStationNames.add(StationName.LANCASTER_GATE);
        tubeStationNames.add(StationName.MARBLE_ARCH);
        tubeStationNames.add(StationName.BOND_STREET);
        tubeStationNames.add(StationName.OXFORD_CIRCUS);
        tubeStationNames.add(StationName.TOTTENHAM_COURT_ROAD);
        tubeStationNames.add(StationName.HOLBORN);
        tubeStationNames.add(StationName.CHANCERY_LANE);
        tubeStationNames.add(StationName.ST_PAULS);
        tubeStationNames.add(StationName.BANK);
        tubeStationNames.add(StationName.LIVERPOOL_STREET);
        tubeStationNames.add(StationName.BETHNAL_GREEN);
        tubeStationNames.add(StationName.MILE_END);
        tubeStationNames.add(StationName.STRATFORD);
        tubeStationNames.add(StationName.LEYTON);
        tubeStationNames.add(StationName.LEYTONSTONE);
        tubeStationNames.add(StationName.WANSTEAD);
        tubeStationNames.add(StationName.REDBRIDGE);
        tubeStationNames.add(StationName.GANTS_HILL);
        tubeStationNames.add(StationName.NEWBURY_PARK);
        tubeStationNames.add(StationName.BARKINGSIDE);
        tubeStationNames.add(StationName.FAIRLOP);
        tubeStationNames.add(StationName.HAINAULT);
        tubeStationNames.add(StationName.GRANGE_HILL);
        tubeStationNames.add(StationName.CHIGWELL);
        tubeStationNames.add(StationName.RODING_VALLEY);
        tubeStationNames.add(StationName.SNARESBROOK);
        tubeStationNames.add(StationName.SOUTH_WOODFORD);
        tubeStationNames.add(StationName.WOODFORD);
        tubeStationNames.add(StationName.BUCKHURST_HILL);
        tubeStationNames.add(StationName.LOUGHTON);
        tubeStationNames.add(StationName.DEBDEN);
        tubeStationNames.add(StationName.THEYDON_BOIS);
        tubeStationNames.add(StationName.EPPING);
        return tubeStationNames;
    }
}
