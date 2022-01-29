package dom.coffirgar.transportmanager;

import dom.coffirgar.transportmanager.domain.stations.Station;
import dom.coffirgar.transportmanager.domain.stations.StationName;
import dom.coffirgar.transportmanager.domain.stations.StationType;

import java.util.ArrayList;
import java.util.List;

public class TestUtils {
    public static List<Station> getAllStationsAsNotVisited(){
        List<Station> stations = new ArrayList<>();

        for(StationName name : StationName.values()){
            if(StationType.isTubeType(name.getStationType())){
                stations.add(Station.notVisited(name.getStationName()));
            }
        }
        return stations;
    }
}
