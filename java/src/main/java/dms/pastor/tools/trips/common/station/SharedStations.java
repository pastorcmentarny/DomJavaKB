package dms.pastor.tools.trips.common.station;

import java.util.ArrayList;
import java.util.List;

public class SharedStations {

    public static List<StationName> addHammersmithToEdwareSection() {
        var tubeStations = new ArrayList<StationName>();
        tubeStations.add(StationName.HAMMERSMITH);
        tubeStations.add(StationName.GOLDHAWK_ROAD);
        tubeStations.add(StationName.SHEPHERDS_BUSH_MARKET);
        tubeStations.add(StationName.WOOD_LANE);
        tubeStations.add(StationName.LATIMER_ROAD);
        tubeStations.add(StationName.LADBROKE_GROVE);
        tubeStations.add(StationName.WESTBOURNE_PARK);
        tubeStations.add(StationName.ROYAL_OAK);
        tubeStations.add(StationName.PADDINGTON);
        tubeStations.add(StationName.EDGWARE_ROAD);
        return tubeStations;
    }

    public static List<StationName> addBakerStreetToLiverpoolStreet() {
        var stationList = new ArrayList<StationName>();
        stationList.add(StationName.BAKER_STREET);
        stationList.add(StationName.GREAT_PORTLAND_STREET);
        stationList.add(StationName.EUSTON_SQUARE);
        stationList.add(StationName.KINGS_CROSS_ST_PANCRAS);
        stationList.add(StationName.FARRINGDON);
        stationList.add(StationName.BARBICAN);
        stationList.add(StationName.MOORGATE);
        stationList.add(StationName.LIVERPOOL_STREET);
        return stationList;
    }

    public static List<StationName> addAldgateEastToBarking() {
        var stationList = new ArrayList<StationName>();
        stationList.add(StationName.BARKING);
        stationList.add(StationName.EAST_HAM);
        stationList.add(StationName.UPTON_PARK);
        stationList.add(StationName.PLAISTOW);
        stationList.add(StationName.WEST_HAM);
        stationList.add(StationName.BROMLEY_BY_BOW);
        stationList.add(StationName.BOW_ROAD);
        stationList.add(StationName.MILE_END);
        stationList.add(StationName.STEPNEY_GREEN);
        stationList.add(StationName.WHITECHAPEL);
        stationList.add(StationName.ALDGATE_EAST);
        return stationList;
    }

    public static List<StationName> addTowerHillToGloucesterRoad() {
        var tubeStations = new ArrayList<StationName>();
        tubeStations.add(StationName.TOWER_HILL);
        tubeStations.add(StationName.MONUMENT);
        tubeStations.add(StationName.CANNON_STREET);
        tubeStations.add(StationName.MANSION_HOUSE);
        tubeStations.add(StationName.BLACKFRIARS);
        tubeStations.add(StationName.TEMPLE);
        tubeStations.add(StationName.EMBANKMENT);
        tubeStations.add(StationName.WESTMINSTER);
        tubeStations.add(StationName.ST_JAMESS_PARK);
        tubeStations.add(StationName.VICTORIA);
        tubeStations.add(StationName.SLOANE_SQUARE);
        tubeStations.add(StationName.SOUTH_KENSINGTON);
        tubeStations.add(StationName.GLOUCESTER_ROAD);
        return tubeStations;
    }

    public static List<StationName> addHighStreetKensingtonToBayswater() {
        var tubeStations = new ArrayList<StationName>();
        tubeStations.add(StationName.HIGH_STREET_KENSINGTON);
        tubeStations.add(StationName.NOTTING_HILL_GATE);
        tubeStations.add(StationName.BAYSWATER);
        return tubeStations;
    }

    public static List<StationName> addUxbridgeToRaynersLane() {
        var tubeStations = new ArrayList<StationName>();
        tubeStations.add(StationName.UXBRIDGE);
        tubeStations.add(StationName.HILLINGDON);
        tubeStations.add(StationName.ICKENHAM);
        tubeStations.add(StationName.RUISLIP);
        tubeStations.add(StationName.RUISLIP_MANOR);
        tubeStations.add(StationName.EASTCOTE);
        tubeStations.add(StationName.RAYNERS_LANE);
        return tubeStations;

    }
}
