package dms.pastor.tools.trips.common.options;

import java.util.List;

/**
 * Author Dominik Symonowicz
 * Created 23/05/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public interface Station {
    List<Station> getTubeStationList();

    Station findStation(String option);

    String asFormattedString();
}
