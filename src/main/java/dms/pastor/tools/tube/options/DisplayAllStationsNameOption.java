package dms.pastor.tools.tube.options;

import dms.pastor.tools.tube.Stations;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class DisplayAllStationsNameOption implements Option {
    @Override
    public void choose(Stations stations) {
        stations.getStationList().forEach(station -> System.out.println(station.getName()));
        displayWarningIfTotalStationNumberIsWrong(stations);
    }

    private void displayWarningIfTotalStationNumberIsWrong(Stations stations) {
        final int totalNumber = 269; //it is 270 as there are 2 Edgware road stations
        if (stations.totalNumber() != totalNumber) {
            System.out.println("WARNING! Total number should be " + totalNumber + " but file contains only " + stations.totalNumber());
        }
    }
}
