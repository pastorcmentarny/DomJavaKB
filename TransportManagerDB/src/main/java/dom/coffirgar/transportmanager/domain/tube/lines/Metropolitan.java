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
public class Metropolitan extends Line {


    @Override
    public List<StationName> getStations() {
        var tubeStations = new ArrayList<StationName>();
        tubeStations.add(StationName.CHESHAM);
        tubeStations.add(StationName.AMERSHAM);
        tubeStations.add(StationName.CHALFONT_AND_LATIMER);
        tubeStations.add(StationName.CHORLEYWOOD);
        tubeStations.add(StationName.RICKMANSWORTH);
        tubeStations.add(StationName.WATFORD);
        tubeStations.add(StationName.CROXLEY);
        tubeStations.add(StationName.MOOR_PARK);
        tubeStations.add(StationName.NORTHWOOD);
        tubeStations.add(StationName.NORTHWOOD_HILLS);
        tubeStations.add(StationName.PINNER);
        tubeStations.add(StationName.NORTH_HARROW);
        tubeStations.addAll(SharedStations.addUxbridgeToRaynersLane());
        tubeStations.add(StationName.WEST_HARROW);
        tubeStations.add(StationName.HARROW_ON_THE_HILL);
        tubeStations.add(StationName.NORTHWICK_PARK);
        tubeStations.add(StationName.PRESTON_ROAD);
        tubeStations.add(StationName.WEMBLEY_PARK);
        tubeStations.add(StationName.FINCHLEY_ROAD);
        tubeStations.addAll(SharedStations.addBakerStreetToLiverpoolStreet());
        tubeStations.add(StationName.ALDGATE);

        return tubeStations;
    }
}
