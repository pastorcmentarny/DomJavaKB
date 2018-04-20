package dms.pastor.tools.tube.options;

import dms.pastor.domain.exception.NotFoundException;
import dms.pastor.domain.exception.NotImplementYetException;
import dms.pastor.tools.tube.station.Station;
import dms.pastor.tools.tube.station.Stations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author Dominik Symonowicz
 * Created 20/04/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class StationUpdater {
    public static final Logger LOGGER = LoggerFactory.getLogger(StationUpdater.class);

    static void updateStationTo(Stations stations, String option, Action action) {
        try {
            final Station station = stations.findStation(option);

            setStationStatus(stations, action, station);

            final Station updatedStation = stations.findStation(station.getName());
            System.out.println("You set " + updatedStation.getName() + " status to " + updatedStation.getStatus().asName() + ".");
        } catch (NotFoundException nfe) {
            System.out.println("Station " + option + " not found.");
        }
    }

    private static void setStationStatus(Stations stations, Action action, Station station) {
        switch (action) {
            case PASSED:
                stations.setPassedFor(station);
                break;
            case VISITED:
                stations.setVisitedFor(station);
                break;
            default:
                throw new NotImplementYetException(action.name().toLowerCase());
        }
    }

    protected enum Action {PASSED, VISITED}
}
