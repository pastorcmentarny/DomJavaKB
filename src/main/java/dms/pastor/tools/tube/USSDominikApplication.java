package dms.pastor.tools.tube;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import static dms.pastor.tools.tube.DataOperations.saveToFile;
import static java.io.File.separator;

/**
 * Author Dominik Symonowicz
 * Created 07/11/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
class USSDominikApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(USSDominikApplication.class);

    private static final String SRC = "src" + separator;
    private static final String RESOURCES = "resources" + separator;
    public static final String BASE_PATH = System.getProperty("user.dir") +
            separator + SRC + "main" +
            separator + RESOURCES;
    public static final String STATION_PATH = BASE_PATH + "tube" + File.separator + "station.txt";

    private USSDominikApplication() {
    }

    public static void main(String[] args) {
        final List<Station> stationList = DataOperations.loadFromFile();
        TubeCLI tubeCLI = new TubeCLI(new Stations(stationList), new Scanner(System.in));
        tubeCLI.main();

        stationList.forEach(System.out::println);
        saveToFile(stationList);

        LOGGER.info("Done. Goodbye!");
    }


}
