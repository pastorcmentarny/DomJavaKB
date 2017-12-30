package dms.pastor.tools.tube.options;

import dms.pastor.tools.tube.station.Station;
import dms.pastor.tools.tube.station.Stations;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * tag-command-pattern
 * <p>
 */
public class DisplayStatusForAllStationsOption implements Option {
    @Override
    public void choose(Stations stations) {
        stations.getStationList().stream()
                .map(Station::asFormattedString)
                .forEach(System.out::println);

    }
}
