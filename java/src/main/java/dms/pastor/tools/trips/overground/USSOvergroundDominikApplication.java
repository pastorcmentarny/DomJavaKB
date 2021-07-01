package dms.pastor.tools.trips.overground;

import dms.pastor.tools.trips.common.station.Station;
import dms.pastor.tools.trips.common.station.Stations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

import static dms.pastor.tools.trips.overground.data.DataOperations.loadFromFile;
import static dms.pastor.tools.trips.overground.data.DataOperations.saveToFile;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
final class USSOvergroundDominikApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(USSOvergroundDominikApplication.class);

    private USSOvergroundDominikApplication() {
    }

    public static void main(String[] args) {

        final List<Station> overgroundStationList = loadFromFile();

        OvergroundCLI overgroundCLI = new OvergroundCLI(new Stations(overgroundStationList), new Scanner(System.in));
        overgroundCLI.mainMenu();

        saveToFile(overgroundStationList);

        LOGGER.info("Done. Goodbye! DO NOT FORGOT TO COPY station.txt from out/production ... or even better change the code");
    }


}
