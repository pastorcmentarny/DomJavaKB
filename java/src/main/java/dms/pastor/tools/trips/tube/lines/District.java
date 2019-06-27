package dms.pastor.tools.trips.tube.lines;

import dms.pastor.tools.trips.tube.station.SharedStations;
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
public class District extends Line {


    @Override
    public List<Station> getStations() {
        var tubeStations = new ArrayList<Station>();
        tubeStations.add(Station.UPMINSTER);
        tubeStations.add(Station.UPMINSTER_BRIDGE);
        tubeStations.add(Station.HORNCHURCH);
        tubeStations.add(Station.ELM_PARK);
        tubeStations.add(Station.DAGENHAM_EAST);
        tubeStations.add(Station.DAGENHAM_HEATHWAY);
        tubeStations.add(Station.BECONTREE);
        tubeStations.add(Station.UPNEY);
        tubeStations.addAll(SharedStations.addAldgateEastToBarking());
        tubeStations.addAll(SharedStations.addTowerHillToGloucesterRoad());
        tubeStations.addAll(SharedStations.addHighStreetKensingtonToBayswater());
        tubeStations.add(Station.PADDINGTON);
        tubeStations.add(Station.EDGWARE_ROAD);
        tubeStations.add(Station.EARLS_COURT);
        tubeStations.add(Station.KENSINGTON_OLYMPIA);
        tubeStations.add(Station.WEST_BROMPTON);
        tubeStations.add(Station.FULHAM_BROADWAY);
        tubeStations.add(Station.PARSONS_GREEN);
        tubeStations.add(Station.PUTNEY_BRIDGE);
        tubeStations.add(Station.EAST_PUTNEY);
        tubeStations.add(Station.SOUTHFIELDS);
        tubeStations.add(Station.WIMBLEDON_PARK);
        tubeStations.add(Station.WIMBLEDON);
        tubeStations.add(Station.WEST_KENSINGTON);
        tubeStations.add(Station.BARONS_COURT);
        tubeStations.add(Station.HAMMERSMITH);
        tubeStations.add(Station.RAVENSCOURT_PARK);
        tubeStations.add(Station.STAMFORD_BROOK);
        tubeStations.add(Station.TURNHAM_GREEN);
        tubeStations.add(Station.GUNNERSBURY);
        tubeStations.add(Station.KEW_GARDENS);
        tubeStations.add(Station.RICHMOND);
        tubeStations.add(Station.CHISWICK_PARK);
        tubeStations.add(Station.ACTON_TOWN);
        tubeStations.add(Station.EALING_COMMON);
        tubeStations.add(Station.EALING_BROADWAY);
        return tubeStations;
    }
}
