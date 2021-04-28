package dms.pastor.tools.trips.common.station;

import dms.pastor.domain.exception.NotFoundException;
import dms.pastor.domain.exception.NotImplementYetException;

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

    public static void setStationBlogged(Stations stations, String option) {
        try {
            final Station station = stations.findStation(option);

            station.setBlogged();

            System.out.println("You set " + station.getName() + " was blogged.");
        } catch (NotFoundException nfe) {
            System.out.println("TubeStation " + option + " not found.");
        }
    }

    public static void updateStationTo(Stations stations, String option, Action action) {
        try {
            final Station station = stations.findStation(option);

            setStationStatus(stations, action, station);

            final Station updatedStation = stations.findStation(station.getName());
            System.out.println("You set " + updatedStation.getName() + " status to " + updatedStation.getStatus().asName() + ".");
        } catch (NotFoundException nfe) {
            System.out.println("TubeStation " + option + " not found.");
        }
    }

    private static void setStationStatus(Stations stations, Action action, Station station) {
        switch (action) {
            case PASSED -> stations.setPassedFor(station);
            case VISITED -> stations.setVisitedFor(station);
            default -> throw new NotImplementYetException(action.name().toLowerCase());
        }
    }


}
