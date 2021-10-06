package dms.pastor.tools.trips.tube.lines;

import dms.pastor.tools.trips.common.station.SharedStations;
import dms.pastor.tools.trips.common.station.StationName;

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
public class District extends Line {


    @Override
    public List<StationName> getStations() {
        var tubeStations = new ArrayList<StationName>();
        tubeStations.add(StationName.UPMINSTER);
        tubeStations.add(StationName.UPMINSTER_BRIDGE);
        tubeStations.add(StationName.HORNCHURCH);
        tubeStations.add(StationName.ELM_PARK);
        tubeStations.add(StationName.DAGENHAM_EAST);
        tubeStations.add(StationName.DAGENHAM_HEATHWAY);
        tubeStations.add(StationName.BECONTREE);
        tubeStations.add(StationName.UPNEY);
        tubeStations.addAll(SharedStations.addAldgateEastToBarking());
        tubeStations.addAll(SharedStations.addTowerHillToGloucesterRoad());
        tubeStations.addAll(SharedStations.addHighStreetKensingtonToBayswater());
        tubeStations.add(StationName.PADDINGTON);
        tubeStations.add(StationName.EDGWARE_ROAD);
        tubeStations.add(StationName.EARLS_COURT);
        tubeStations.add(StationName.KENSINGTON_OLYMPIA);
        tubeStations.add(StationName.WEST_BROMPTON);
        tubeStations.add(StationName.FULHAM_BROADWAY);
        tubeStations.add(StationName.PARSONS_GREEN);
        tubeStations.add(StationName.PUTNEY_BRIDGE);
        tubeStations.add(StationName.EAST_PUTNEY);
        tubeStations.add(StationName.SOUTHFIELDS);
        tubeStations.add(StationName.WIMBLEDON_PARK);
        tubeStations.add(StationName.WIMBLEDON);
        tubeStations.add(StationName.WEST_KENSINGTON);
        tubeStations.add(StationName.BARONS_COURT);
        tubeStations.add(StationName.HAMMERSMITH);
        tubeStations.add(StationName.RAVENSCOURT_PARK);
        tubeStations.add(StationName.STAMFORD_BROOK);
        tubeStations.add(StationName.TURNHAM_GREEN);
        tubeStations.add(StationName.GUNNERSBURY);
        tubeStations.add(StationName.KEW_GARDENS);
        tubeStations.add(StationName.RICHMOND);
        tubeStations.add(StationName.CHISWICK_PARK);
        tubeStations.add(StationName.ACTON_TOWN);
        tubeStations.add(StationName.EALING_COMMON);
        tubeStations.add(StationName.EALING_BROADWAY);
        return tubeStations;
    }
}
