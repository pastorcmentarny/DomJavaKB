package dms.pastor.tools.tube;

import static dms.pastor.tools.tube.Status.NOT_VISITED;

/**
 * Author Dominik Symonowicz
 * Created 07/11/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
final class ToStationConverter {

    private ToStationConverter() {
    }

    public static Station convert(String stationAsString) {
        StationLineValidator.validate(stationAsString);
        return new Station(stationAsString, NOT_VISITED, Line.noLine());
    }
}
