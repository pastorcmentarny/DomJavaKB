package dms.pastor.tools.trips.overground.lines;

import dms.pastor.tools.trips.common.station.StationName;
import dms.pastor.tools.trips.common.station.StationType;

import java.util.ArrayList;
import java.util.List;

/**
 * Author Dominik Symonowicz
 * Created 08/06/2018
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Overground extends OvergroundLine {


    @Override
    public List<StationName> getStations() {
        var overgroundStations = new ArrayList<StationName>();
        final var allStations = StationName.values();
        for (StationName station : allStations) {
            if (StationType.isOvergroundType(station.getStationType())) {
                overgroundStations.add(station);
            }

        }
        return overgroundStations;
    }
}
