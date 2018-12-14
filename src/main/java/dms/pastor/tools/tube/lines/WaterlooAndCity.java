package dms.pastor.tools.tube.lines;

import dms.pastor.tools.tube.station.StationName;

import java.util.ArrayList;
import java.util.List;

/* Waterloo & City line is named after all station it was stopped Waterloo abd City (known as Bank)*/
/* change to set */
public class WaterlooAndCity extends Line {
    public WaterlooAndCity() {
        setName("Waterloo & City");
    }

    private List<StationName> stationList = getList();


    private static List<StationName> getList() {
        List<StationName> stationNames = new ArrayList<>();
        stationNames.add(StationName.WATERLOO);
        stationNames.add(StationName.BANK);
        return stationNames;
    }
}
