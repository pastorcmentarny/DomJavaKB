package dms.pastor.tools.tube.data;

import dms.pastor.domain.exception.SomethingWentWrongException;
import dms.pastor.tools.tube.station.Station;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static java.io.File.separator;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class DataOperations {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataOperations.class);
    private static final String SRC = "src" + separator;
    private static final String RESOURCES = "resources" + separator;
    private static final String BASE_PATH = System.getProperty("user.dir") +
            separator + SRC + "main" +
            separator + RESOURCES;
    private static final String STATION_PATH = BASE_PATH + "tube" + File.separator + "station.txt";

    private static final String PATH = BASE_PATH + "tube" + File.separator + "station" + Timestamp.valueOf(LocalDateTime.now()) + ".txt";

    private DataOperations() {
    }

    public static void saveToFile(List<Station> stationList) {
        LOGGER.info("Saving data..");
        DataWriter dataWriter = new DataWriter();
        dataWriter.save(STATION_PATH, stationList);
    }

    public static List<Station> loadFromFile() {
        LOGGER.info("Loading data..");
        DataUploader dataUploader = new DataUploader();
        return dataUploader.load(STATION_PATH);
    }

    public static void backup() {
        LOGGER.info("Backup saved data");
        final List<Station> originalStationList = loadFromFile();
        DataWriter dataWriter = new DataWriter();
        try {
            final boolean created = new File(PATH).createNewFile();
            if (!created) {
                throw new SomethingWentWrongException("Creating file at " + PATH);
            }
        } catch (IOException e) {
            throw new SomethingWentWrongException("Creating file at " + PATH, e);
        }
        dataWriter.save(PATH, originalStationList);
    }
}
