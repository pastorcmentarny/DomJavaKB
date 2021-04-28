package dms.pastor.tools.trips.overground.lines;

import dms.pastor.tools.trips.common.station.StationName;

import java.util.List;

/**
 * Author Dominik Symonowicz
 * Created 06/06/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public abstract class OvergroundLine {
    private final List<StationName> overgroundStations = getStations();

    public String name() {
        return getClass().getSimpleName();
    }

    public int getSize() {
        return overgroundStations.size();
    }

    public abstract List<StationName> getStations();

}
