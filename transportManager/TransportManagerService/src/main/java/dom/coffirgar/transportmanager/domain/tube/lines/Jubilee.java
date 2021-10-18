package dom.coffirgar.transportmanager.domain.tube.lines;


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
public class Jubilee extends Line {

    @Override
    public List<StationName> getStations() {
        var tubeStations = new ArrayList<StationName>();
        tubeStations.add(StationName.STANMORE);
        tubeStations.add(StationName.CANNONS_PARK);
        tubeStations.add(StationName.QUEENSBURY);
        tubeStations.add(StationName.KINGSBURY);
        tubeStations.add(StationName.WEMBLEY_PARK);
        tubeStations.add(StationName.NEASDEN);
        tubeStations.add(StationName.DOLLIS_HILL);
        tubeStations.add(StationName.WILLESDEN_GREEN);
        tubeStations.add(StationName.KILBURN);
        tubeStations.add(StationName.WEST_HAMPSTEAD);
        tubeStations.add(StationName.FINCHLEY_ROAD);
        tubeStations.add(StationName.SWISS_COTTAGE);
        tubeStations.add(StationName.ST_JOHNS_WOOD);
        tubeStations.add(StationName.BAKER_STREET);
        tubeStations.add(StationName.BOND_STREET);
        tubeStations.add(StationName.GREEN_PARK);
        tubeStations.add(StationName.WESTMINSTER);
        tubeStations.add(StationName.WATERLOO);
        tubeStations.add(StationName.SOUTHWARK);
        tubeStations.add(StationName.LONDON_BRIDGE);
        tubeStations.add(StationName.BERMONDSEY);
        tubeStations.add(StationName.CANADA_WATER);
        tubeStations.add(StationName.CANARY_WHARF);
        tubeStations.add(StationName.NORTH_GREENWICH);
        tubeStations.add(StationName.CANNING_TOWN);
        tubeStations.add(StationName.WEST_HAM);
        tubeStations.add(StationName.STRATFORD);
        return tubeStations;
    }
}
