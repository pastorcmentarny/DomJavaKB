package dms.pastor.tools.trips.tube.lines;

import dms.pastor.tools.trips.common.station.StationName;

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
public class Bakerloo extends Line {


    @Override
    public List<StationName> getStations() {
        List<StationName> tubeStationNames = new ArrayList<>();
        tubeStationNames.add(StationName.HARROW_AND_WEALDSTONE);
        tubeStationNames.add(StationName.KENTON);
        tubeStationNames.add(StationName.SOUTH_KENTON);
        tubeStationNames.add(StationName.NORTH_WEMBLEY);
        tubeStationNames.add(StationName.WEMBLEY_CENTRAL);
        tubeStationNames.add(StationName.STONEBRIDGE_PARK);
        tubeStationNames.add(StationName.HARLESDEN);
        tubeStationNames.add(StationName.WILLESDEN_JUNCTION);
        tubeStationNames.add(StationName.KENSAL_GREEN);
        tubeStationNames.add(StationName.QUEENS_PARK);
        tubeStationNames.add(StationName.KILBURN_PARK);
        tubeStationNames.add(StationName.MAIDA_VALE);
        tubeStationNames.add(StationName.WARWICK_AVENUE);
        tubeStationNames.add(StationName.PADDINGTON);
        tubeStationNames.add(StationName.EDGWARE_ROAD);
        tubeStationNames.add(StationName.MARYLEBONE);
        tubeStationNames.add(StationName.BAKER_STREET);
        tubeStationNames.add(StationName.REGENTS_PARK);
        tubeStationNames.add(StationName.OXFORD_CIRCUS);
        tubeStationNames.add(StationName.PICCADILLY_CIRCUS);
        tubeStationNames.add(StationName.CHARING_CROSS);
        tubeStationNames.add(StationName.EMBANKMENT);
        tubeStationNames.add(StationName.WATERLOO);
        tubeStationNames.add(StationName.LAMBETH_NORTH);
        tubeStationNames.add(StationName.ELEPHANT_AND_CASTLE);
        return tubeStationNames;
    }
}
