package dms.pastor.tools.tube;

public class ToStationConverter {

    public static Station convert(String stationAsString){
        return new Station(stationAsString,null,null);
    }
}
