package dms.pastor.tools.trips.tube;

import dms.pastor.tools.trips.common.station.Station;
import dms.pastor.tools.trips.common.station.Stations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

import static dms.pastor.tools.trips.tube.data.DataOperations.loadFromFile;
import static dms.pastor.tools.trips.tube.data.DataOperations.saveToFile;

/**
 * Author Dominik Symonowicz
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
final class USSDominikApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(USSDominikApplication.class);

    private USSDominikApplication() {
    }

    public static void main(String[] args) {

        final List<Station> stationList = loadFromFile();

        TubeCLI tubeCLI = new TubeCLI(new Stations(stationList), new Scanner(System.in));
        tubeCLI.mainMenu();

        saveToFile(stationList);

        LOGGER.info("Done. Goodbye! DO NOT FORGOT TO COPY station.txt from out/productuion ... or even better change the code");
    }


}
