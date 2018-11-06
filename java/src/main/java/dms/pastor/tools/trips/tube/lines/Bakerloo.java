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
public class Bakerloo extends Line {


    @Override
    public List<Station> getStations() {
        List<Station> tubeStations = new ArrayList<>();
        tubeStations.add(Station.HARROW_AND_WEALDSTONE);
        tubeStations.add(Station.KENTON);
        tubeStations.add(Station.SOUTH_KENTON);
        tubeStations.add(Station.NORTH_WEMBLEY);
        tubeStations.add(Station.WEMBLEY_CENTRAL);
        tubeStations.add(Station.STONEBRIDGE_PARK);
        tubeStations.add(Station.HARLESDEN);
        tubeStations.add(Station.WILLESDEN_JUNCTION);
        tubeStations.add(Station.KENSAL_GREEN);
        tubeStations.add(Station.QUEENS_PARK);
        tubeStations.add(Station.KILBURN_PARK);
        tubeStations.add(Station.MAIDA_VALE);
        tubeStations.add(Station.WARWICK_AVENUE);
        tubeStations.add(Station.PADDINGTON);
        tubeStations.add(Station.EDGWARE_ROAD);
        tubeStations.add(Station.MARYLEBONE);
        tubeStations.add(Station.BAKER_STREET);
        tubeStations.add(Station.REGENTS_PARK);
        tubeStations.add(Station.OXFORD_CIRCUS);
        tubeStations.add(Station.PICCADILLY_CIRCUS);
        tubeStations.add(Station.CHARING_CROSS);
        tubeStations.add(Station.EMBANKMENT);
        tubeStations.add(Station.WATERLOO);
        tubeStations.add(Station.LAMBETH_NORTH);
        tubeStations.add(Station.ELEPHANT_AND_CASTLE);
        return tubeStations;
    }
}
