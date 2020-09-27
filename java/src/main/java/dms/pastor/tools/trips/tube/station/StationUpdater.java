package dms.pastor.tools.trips.tube.station;

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
            final TubeStation tubeStation = stations.findStation(option);

            tubeStation.setBlogged();

            System.out.println("You set " + tubeStation.getName() + " was blogged.");
        } catch (NotFoundException nfe) {
            System.out.println("TubeStation " + option + " not found.");
        }
    }

    public static void updateStationTo(Stations stations, String option, Action action) {
        try {
            final TubeStation tubeStation = stations.findStation(option);

            setStationStatus(stations, action, tubeStation);

            final TubeStation updatedTubeStation = stations.findStation(tubeStation.getName());
            System.out.println("You set " + updatedTubeStation.getName() + " status to " + updatedTubeStation.getStatus().asName() + ".");
        } catch (NotFoundException nfe) {
            System.out.println("TubeStation " + option + " not found.");
        }
    }

    private static void setStationStatus(Stations stations, Action action, TubeStation tubeStation) {
        switch (action) {
            case PASSED -> stations.setPassedFor(tubeStation);
            case VISITED -> stations.setVisitedFor(tubeStation);
            default -> throw new NotImplementYetException(action.name().toLowerCase());
        }
    }


}
