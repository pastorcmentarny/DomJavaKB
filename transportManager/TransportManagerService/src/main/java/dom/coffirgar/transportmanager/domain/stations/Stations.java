package dom.coffirgar.transportmanager.domain.stations;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Stations {
    private List<Station> stations;

    public int allStations() {
        return stations.size();
    }

    public int countStationPassed() {
        return Math.toIntExact(stations.stream().filter(Station::isPassedAlready).count());
    }
}
