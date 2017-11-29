package dms.pastor.tools.tube;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

import static dms.pastor.tools.tube.DataOperations.loadFromFile;
import static dms.pastor.tools.tube.DataOperations.saveToFile;

/**
 * Author Dominik Symonowicz
 * Created 07/11/2017
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

        final List<Station> stationList = loadFromFile();

        TubeCLI tubeCLI = new TubeCLI(new Stations(stationList), new Scanner(System.in));
        tubeCLI.mainMenu();

        saveToFile(stationList);

        LOGGER.info("Done. Goodbye!");
    }


}
