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
public class Jubilee extends Line {

    @Override
    public List<Station> getStations() {
        var tubeStations = new ArrayList<Station>();
        tubeStations.add(Station.STANMORE);
        tubeStations.add(Station.CANNONS_PARK);
        tubeStations.add(Station.QUEENSBURY);
        tubeStations.add(Station.KINGSBURY);
        tubeStations.add(Station.WEMBLEY_PARK);
        tubeStations.add(Station.NEASDEN);
        tubeStations.add(Station.DOLLIS_HILL);
        tubeStations.add(Station.WILLESDEN_GREEN);
        tubeStations.add(Station.KILBURN);
        tubeStations.add(Station.WEST_HAMPSTEAD);
        tubeStations.add(Station.FINCHLEY_ROAD);
        tubeStations.add(Station.SWISS_COTTAGE);
        tubeStations.add(Station.ST_JOHNS_WOOD);
        tubeStations.add(Station.BAKER_STREET);
        tubeStations.add(Station.BOND_STREET);
        tubeStations.add(Station.GREEN_PARK);
        tubeStations.add(Station.WESTMINSTER);
        tubeStations.add(Station.WATERLOO);
        tubeStations.add(Station.SOUTHWARK);
        tubeStations.add(Station.LONDON_BRIDGE);
        tubeStations.add(Station.BERMONDSEY);
        tubeStations.add(Station.CANADA_WATER);
        tubeStations.add(Station.CANARY_WHARF);
        tubeStations.add(Station.NORTH_GREENWICH);
        tubeStations.add(Station.CANNING_TOWN);
        tubeStations.add(Station.WEST_HAM);
        tubeStations.add(Station.STRATFORD);
        return tubeStations;
    }
}
