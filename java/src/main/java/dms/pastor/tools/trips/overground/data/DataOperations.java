package dms.pastor.tools.trips.overground.data;

import dms.pastor.domain.exception.SomethingWentTerribleWrongError;
import dms.pastor.domain.exception.SomethingWentWrongException;
import dms.pastor.tools.trips.common.data.DataUploader;
import dms.pastor.tools.trips.common.data.DataWriter;
import dms.pastor.tools.trips.common.station.Station;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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

    public static final Path STATION_PATH;

    static {
        final URL resource = DataOperations.class.getClassLoader().getResource("transport/overground/station.txt");
        if (Objects.isNull(resource)) {
            throw new SomethingWentTerribleWrongError("Where is my bloody file ?");
        }
        STATION_PATH = new File(resource.getPath()).toPath();
    }


    private DataOperations() {
    }

    public static void saveToFile(List<Station> overgroundStationList) {
        LOGGER.info("Saving data..");
        DataWriter DataWriter = new DataWriter();
        DataWriter.save(STATION_PATH, overgroundStationList);
    }

    public static List<Station> loadFromFile() {
        DataUploader dataUploader = new DataUploader();
        return dataUploader.load(DataOperations.STATION_PATH);
    }

    public static void backup() {
        LOGGER.info("Backup saved data");
        final List<Station> originalOvergroundStationList = loadFromFile();
        final String backupPath = System.getProperty("user.dir") + "/backup-" + LocalDateTime.now().toString().replaceAll(":", "-").replaceAll(" ", "") + "-station.txt";

        DataWriter DataWriter = new DataWriter();
        try {
            final File backupFile = new File(backupPath);
            final boolean created = backupFile.createNewFile();
            if (!created) {
                throw new SomethingWentWrongException("Creating file at " + backupPath);
            }
            DataWriter.save(backupFile.toPath(), originalOvergroundStationList);

        } catch (IOException e) {
            throw new SomethingWentWrongException("Creating file at " + backupPath, e);
        }
    }

}
