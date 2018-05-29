package dms.pastor.tools.trips.tube;

import dms.pastor.tools.trips.tube.station.Stations;
import dms.pastor.tools.trips.tube.station.TubeStation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

import static dms.pastor.tools.trips.tube.data.DataOperations.loadFromFile;
import static dms.pastor.tools.trips.tube.data.DataOperations.saveToFile;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
final class USSDominikApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(USSDominikApplication.class);

    private USSDominikApplication() {
    }

    public static void main(String[] args) {

        final List<TubeStation> tubeStationList = loadFromFile();

        TubeCLI tubeCLI = new TubeCLI(new Stations(tubeStationList), new Scanner(System.in));
        tubeCLI.mainMenu();

        saveToFile(tubeStationList);

        LOGGER.info("Done. Goodbye!");
    }


}
