package dom.coffirgar.transportmanager.domain.tube.lines;



import dom.coffirgar.transportmanager.domain.stations.StationName;

import java.util.List;

/**
 * Author Dominik Symonowicz
 * Created 06/06/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public abstract class Line {
    private final List<StationName> tubeStationNames = getStations();

    public String name() {
        return getClass().getSimpleName();
    }

    public int getSize() {
        return tubeStationNames.size();
    }

    public abstract List<StationName> getStations();


}
