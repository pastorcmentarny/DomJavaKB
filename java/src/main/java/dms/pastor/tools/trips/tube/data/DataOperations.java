package dms.pastor.tools.trips.tube.data;

import dms.pastor.domain.exception.SomethingWentWrongException;
import dms.pastor.tools.trips.tube.station.TubeStation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

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

    //FIXME improve it as getPath() may produce NPE
    public static final Path STATION_PATH = new File(DataOperations.class.getClassLoader().getResource("transport/tube/station.txt").getPath()).toPath();


    private DataOperations() {
    }

    public static void saveToFile(List<TubeStation> tubeStationList) {
        LOGGER.info("Saving data..");
        DataWriter dataWriter = new DataWriter();
        dataWriter.save(STATION_PATH, tubeStationList);
    }

    public static List<TubeStation> loadFromFile() {
        DataUploader dataUploader = new DataUploader();
        return dataUploader.load(DataOperations.STATION_PATH);
    }

    public static void backup() {
        LOGGER.info("Backup saved data");
        final List<TubeStation> originalTubeStationList = loadFromFile();
        String backupPath = getBackupPath();
        DataWriter dataWriter = new DataWriter();
        try {
            final boolean created = new File(backupPath).createNewFile();
            if (!created) {
                throw new SomethingWentWrongException("Creating file at " + backupPath);
            }
        } catch (IOException e) {
            throw new SomethingWentWrongException("Creating file at " + backupPath, e);
        }
        //TODO fix me dataWriter.save(backupPath, originalTubeStationList);
    }

    //TODO fix me as it throws null pointer exception
    private static String getBackupPath() {
        return DataOperations.class.getClassLoader().getResource("tube/tube" + Timestamp.valueOf(LocalDateTime.now()) + "station.txt").getPath();
    }
}
