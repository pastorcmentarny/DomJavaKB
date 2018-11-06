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
public class Central extends Line {


    @Override
    public List<Station> getStations() {
        List<Station> tubeStations = new ArrayList<>();
        tubeStations.add(Station.WEST_RUISLIP);
        tubeStations.add(Station.RUISLIP_GARDENS);
        tubeStations.add(Station.SOUTH_RUISLIP);
        tubeStations.add(Station.NORTHOLT);
        tubeStations.add(Station.GREENFORD);
        tubeStations.add(Station.PERIVALE);
        tubeStations.add(Station.HANGER_LANE);
        tubeStations.add(Station.EALING_BROADWAY);
        tubeStations.add(Station.WEST_ACTON);
        tubeStations.add(Station.NORTH_ACTON);
        tubeStations.add(Station.EAST_ACTON);
        tubeStations.add(Station.WHITE_CITY);
        tubeStations.add(Station.SHEPHERDS_BUSH);
        tubeStations.add(Station.HOLLAND_PARK);
        tubeStations.add(Station.NOTTING_HILL_GATE);
        tubeStations.add(Station.QUEENSWAY);
        tubeStations.add(Station.LANCASTER_GATE);
        tubeStations.add(Station.MARBLE_ARCH);
        tubeStations.add(Station.BOND_STREET);
        tubeStations.add(Station.OXFORD_CIRCUS);
        tubeStations.add(Station.TOTTENHAM_COURT_ROAD);
        tubeStations.add(Station.HOLBORN);
        tubeStations.add(Station.CHANCERY_LANE);
        tubeStations.add(Station.ST_PAULS);
        tubeStations.add(Station.BANK);
        tubeStations.add(Station.LIVERPOOL_STREET);
        tubeStations.add(Station.BETHNAL_GREEN);
        tubeStations.add(Station.MILE_END);
        tubeStations.add(Station.STRATFORD);
        tubeStations.add(Station.LEYTON);
        tubeStations.add(Station.LEYTONSTONE);
        tubeStations.add(Station.WANSTEAD);
        tubeStations.add(Station.REDBRIDGE);
        tubeStations.add(Station.GANTS_HILL);
        tubeStations.add(Station.NEWBURY_PARK);
        tubeStations.add(Station.BARKINGSIDE);
        tubeStations.add(Station.FAIRLOP);
        tubeStations.add(Station.HAINAULT);
        tubeStations.add(Station.GRANGE_HILL);
        tubeStations.add(Station.CHIGWELL);
        tubeStations.add(Station.RODING_VALLEY);
        tubeStations.add(Station.SNARESBROOK);
        tubeStations.add(Station.SOUTH_WOODFORD);
        tubeStations.add(Station.WOODFORD);
        tubeStations.add(Station.BUCKHURST_HILL);
        tubeStations.add(Station.LOUGHTON);
        tubeStations.add(Station.DEBDEN);
        tubeStations.add(Station.THEYDON_BOIS);
        tubeStations.add(Station.EPPING);
        return tubeStations;
    }
}
