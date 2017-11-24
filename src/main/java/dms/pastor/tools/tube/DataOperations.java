package dms.pastor.tools.tube;

import dms.pastor.domain.exception.SomethingWentWrongException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static dms.pastor.tools.tube.USSDominikApplication.BASE_PATH;
import static dms.pastor.tools.tube.USSDominikApplication.STATION_PATH;

public class DataOperations {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataOperations.class);
    public static final String PATH = BASE_PATH + "tube" + File.separator + "station" + Timestamp.valueOf(LocalDateTime.now()) + ".txt";

    static void saveToFile(List<Station> stationList) {
        LOGGER.info("Saving data..");
        DataWriter dataWriter = new DataWriter();
        dataWriter.save(STATION_PATH, stationList);
    }

    static List<Station> loadFromFile() {
        LOGGER.info("Loading data..");
        DataUploader dataUploader = new DataUploader();
        return dataUploader.load(STATION_PATH);
    }

    static void backup() {
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
