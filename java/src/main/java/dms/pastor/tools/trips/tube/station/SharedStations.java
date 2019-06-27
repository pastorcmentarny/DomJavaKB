package dms.pastor.tools.trips.tube.station;

import java.util.ArrayList;
import java.util.List;

public class SharedStations {

    public static List<Station> addHammersmithToEdwareSection() {
        var tubeStations = new ArrayList<Station>();
        tubeStations.add(Station.HAMMERSMITH);
        tubeStations.add(Station.GOLDHAWK_ROAD);
        tubeStations.add(Station.SHEPHERDS_BUSH_MARKET);
        tubeStations.add(Station.WOOD_LANE);
        tubeStations.add(Station.LATIMER_ROAD);
        tubeStations.add(Station.LADBROKE_GROVE);
        tubeStations.add(Station.WESTBOURNE_PARK);
        tubeStations.add(Station.ROYAL_OAK);
        tubeStations.add(Station.PADDINGTON);
        tubeStations.add(Station.EDGWARE_ROAD);
        return tubeStations;
    }

    public static List<Station> addBakerStreetToLiverpoolStreet() {
        var stationList = new ArrayList<Station>();
        stationList.add(Station.BAKER_STREET);
        stationList.add(Station.GREAT_PORTLAND_STREET);
        stationList.add(Station.EUSTON_SQUARE);
        stationList.add(Station.KINGS_CROSS_ST_PANCRAS);
        stationList.add(Station.FARRINGDON);
        stationList.add(Station.BARBICAN);
        stationList.add(Station.MOORGATE);
        stationList.add(Station.LIVERPOOL_STREET);
        return stationList;
    }

    public static List<Station> addAldgateEastToBarking() {
        var stationList = new ArrayList<Station>();
        stationList.add(Station.BARKING);
        stationList.add(Station.EAST_HAM);
        stationList.add(Station.UPTON_PARK);
        stationList.add(Station.PLAISTOW);
        stationList.add(Station.WEST_HAM);
        stationList.add(Station.BROMLEY_BY_BOW);
        stationList.add(Station.BOW_ROAD);
        stationList.add(Station.MILE_END);
        stationList.add(Station.STEPNEY_GREEN);
        stationList.add(Station.WHITECHAPEL);
        stationList.add(Station.ALDGATE_EAST);
        return stationList;
    }

    public static List<Station> addTowerHillToGloucesterRoad() {
        var tubeStations = new ArrayList<Station>();
        tubeStations.add(Station.TOWER_HILL);
        tubeStations.add(Station.MONUMENT);
        tubeStations.add(Station.CANNON_STREET);
        tubeStations.add(Station.MANSION_HOUSE);
        tubeStations.add(Station.BLACKFRIARS);
        tubeStations.add(Station.TEMPLE);
        tubeStations.add(Station.EMBANKMENT);
        tubeStations.add(Station.WESTMINSTER);
        tubeStations.add(Station.ST_JAMESS_PARK);
        tubeStations.add(Station.VICTORIA);
        tubeStations.add(Station.SLOANE_SQUARE);
        tubeStations.add(Station.SOUTH_KENSINGTON);
        tubeStations.add(Station.GLOUCESTER_ROAD);
        return tubeStations;
    }

    public static List<Station> addHighStreetKensingtonToBayswater() {
        var tubeStations = new ArrayList<Station>();
        tubeStations.add(Station.HIGH_STREET_KENSINGTON);
        tubeStations.add(Station.NOTTING_HILL_GATE);
        tubeStations.add(Station.BAYSWATER);
        return tubeStations;
    }

    public static List<Station> addUxbridgeToRaynersLane() {
        var tubeStations = new ArrayList<Station>();
        tubeStations.add(Station.UXBRIDGE);
        tubeStations.add(Station.HILLINGDON);
        tubeStations.add(Station.ICKENHAM);
        tubeStations.add(Station.RUISLIP);
        tubeStations.add(Station.RUISLIP_MANOR);
        tubeStations.add(Station.EASTCOTE);
        tubeStations.add(Station.RAYNERS_LANE);
        return tubeStations;

    }
}
